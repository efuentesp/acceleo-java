package com.softtek.acceleo.demo.security.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.acceleo.demo.domain.AdminPermiso;
import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.AuthorityPrivilege;
import com.softtek.acceleo.demo.domain.ConfigPermisos;
import com.softtek.acceleo.demo.domain.Privilege;
import com.softtek.acceleo.demo.domain.User;
import com.softtek.acceleo.demo.security.JwtTokenUtil;
import com.softtek.acceleo.demo.security.repository.AuthorityPrivilegeRepository;
import com.softtek.acceleo.demo.security.repository.AuthorityRepository;
import com.softtek.acceleo.demo.security.repository.PrivilegeRepository;
import com.softtek.acceleo.demo.security.repository.UserAuthorityRepository;
import com.softtek.acceleo.demo.service.AdminPermisoService;
import com.softtek.acceleo.demo.service.UserService;



@RestController
public class AdminPermisoController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AdminPermisoService adminPermisoService;

	@Autowired
	private UserService userService;
	
	@Autowired
	public AuthorityPrivilegeRepository authorityPrivilegeRepository;
	
	@Autowired
	public UserAuthorityRepository userAuthorityRepository; 	
	
	@Autowired
	public PrivilegeRepository privilegeRepository; 		
	
	@Autowired
	public AuthorityRepository authorityRepository;
	
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	
	AdminPermiso adminPermiso = new AdminPermiso();
	
	/**
	 * Obtiene informacion de los afilliados.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<AdminPermiso>.
	 */
	@RequestMapping(value = "/adminPermiso", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('MANAGESEARCH')")
	public @ResponseBody  List<ConfigPermisos> getAdminPermisos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {


		List<ConfigPermisos> listAdminPermiso = null;

		
       	listAdminPermiso = adminPermisoService.listAdminPermiso();


		response.setHeader("Access-Control-Expose-Headers", "x-total-count");

		System.out.println("Respuesta: "+ listAdminPermiso.size());
		
		return listAdminPermiso;
	}
	
	@RequestMapping(value = "/adminPermiso", method = RequestMethod.PUT, produces = "application/json")
	@PreAuthorize("hasRole('MANAGEUPDATE')")  
    public void updateAuthorityPrivilege(@RequestBody ConfigPermisos configPermisos) {
		
		// UpdateData
		adminPermisoService.updateAuthorityPrivilege(configPermisos);
		
		System.out.println("Dato Actualizado");
	}
	
/*/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_*/
	
	@RequestMapping(value = "/auth/roles/{id}/permissions", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_ROLE:READ')")
	public @ResponseBody List<Map<String, String>> getRolePermission(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") String idRole) {
		/**
		 *String userName = jwtTokenUtil.getUsernameFromToken(tkn);
		 *String userRole = jwtTokenUtil.getRoleFromToken(tkn);
		 */
		List<Map<String, String>> lstPrivileges = new ArrayList<>();
		
		
		Authority authority = new Authority();
		authority.setIdAuthority(Long.valueOf(idRole));
		
		List<AuthorityPrivilege> lstAutPriv = authorityPrivilegeRepository.getAuthorityPrivilegePorIdAuthority(authority);
		for( AuthorityPrivilege autPriv : lstAutPriv ) {
			Map<String, String> autPrivMAP = new HashMap<>();
			
			autPrivMAP.put("code", autPriv.getIdPrivilege().getName());
			autPrivMAP.put("description", autPriv.getIdPrivilege().getName());
			
			lstPrivileges.add(autPrivMAP);
		}
		
		return lstPrivileges;
	}
	
	@RequestMapping(value = "/auth/permissionsvsroles", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_ROLE:READ')")
	public @ResponseBody  List<Map<String, Object>> getPermissionVSRole(HttpServletRequest request, HttpServletResponse response) {
		List<Map<String, Object>> lstPrivilegeRes = new ArrayList<>();
		
		List<Privilege> lstPrivilege = privilegeRepository.getPrivilege();
		List<Authority> lstAuthority = authorityRepository.getAuthority();
				
		for( Privilege privil : lstPrivilege ) {
			List<AuthorityPrivilege> lstAuth = authorityPrivilegeRepository.getAuthorityPrivilegePorIdPrivilege(privil);
			Map<String, Object> privilegeMAP = new HashMap<>();
			
			Map<String, String> permissionMAP = new HashMap<>();
			permissionMAP.put("id", Long.toString(privil.getIdPrivilege()));
			permissionMAP.put("resource", privil.getGrupo().getName());
			permissionMAP.put("action", privil.getName());
			permissionMAP.put("scope", "own");
			permissionMAP.put("description", privil.getName());
			
			
			List<Map<String, String>> roles = new ArrayList<>();
			for( Authority authority : lstAuthority ) {
				Map<String, String> authorithyMAP = new HashMap<>();
				
				authorithyMAP.put("id", Long.toString(authority.getIdAuthority().longValue()));
				authorithyMAP.put("name", authority.getName());
				authorithyMAP.put("description", authority.getName());
				boolean authPrivilege = Boolean.FALSE;
				
				for( AuthorityPrivilege autPriv : lstAuth ) {
					if( authority.getIdAuthority().longValue() == autPriv.getIdAuthority().getIdAuthority().longValue() ) {
						authPrivilege = Boolean.TRUE;
						break;
					}
				}
				
				if( authPrivilege ) {
					authorithyMAP.put("assigned", "true");
				}else {
					authorithyMAP.put("assigned", "false");
				}
				
				roles.add(authorithyMAP);
			}
			
			privilegeMAP.put("permission", permissionMAP);
			privilegeMAP.put("roles", roles);
			
			lstPrivilegeRes.add(privilegeMAP);
		}
		
		return lstPrivilegeRes;
	}	
/*/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_*/
	
	
}
