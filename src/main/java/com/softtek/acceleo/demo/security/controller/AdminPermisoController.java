package com.softtek.acceleo.demo.security.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.softtek.acceleo.demo.domain.AdminPermiso;
import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.AuthorityPrivilege;
import com.softtek.acceleo.demo.domain.ConfigPermisos;
import com.softtek.acceleo.demo.domain.Privilege;
import com.softtek.acceleo.demo.security.JwtTokenUtil;
import com.softtek.acceleo.demo.security.repository.AuthorityPrivilegeRepository;
import com.softtek.acceleo.demo.security.repository.AuthorityRepository;
import com.softtek.acceleo.demo.security.repository.PrivilegeRepository;
import com.softtek.acceleo.demo.security.repository.UserAuthorityRepository;
import com.softtek.acceleo.demo.security.service.JwtAuthenticationError;
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

	@Value("${jwt.header}")
	private String tokenHeader;

	AdminPermiso adminPermiso = new AdminPermiso();

	/**
	 * Obtiene informacion de los afilliados.
	 * 
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<AdminPermiso>.
	 */
	@RequestMapping(value = "/adminPermiso", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('MANAGESEARCH')")
	public @ResponseBody List<ConfigPermisos> getAdminPermisos(@RequestParam Map<String, String> requestParams,
			HttpServletRequest request, HttpServletResponse response) {

		List<ConfigPermisos> listAdminPermiso = null;

		listAdminPermiso = adminPermisoService.listAdminPermiso();

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");

		System.out.println("Respuesta: " + listAdminPermiso.size());

		return listAdminPermiso;
	}

	@RequestMapping(value = "/adminPermiso", method = RequestMethod.PUT, produces = "application/json")
	@PreAuthorize("hasRole('MANAGEUPDATE')")
	public void updateAuthorityPrivilege(@RequestBody ConfigPermisos configPermisos) {

		// UpdateData
		adminPermisoService.updateAuthorityPrivilege(configPermisos);

		System.out.println("Dato Actualizado");
	}

	/*
	 * /_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
	 * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_
	 */

	@RequestMapping(value = "/auth/permissions", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_ROLE:READ')")
	public @ResponseBody List<Map<String, String>> getPermissions(HttpServletRequest request,
			HttpServletResponse response) {
		List<Map<String, String>> lstPrivileges = new ArrayList<>();

		List<Privilege> lstPrivilege = privilegeRepository.getPrivilege();
		for (Privilege privilege : lstPrivilege) {
			Map<String, String> privilegeMAP = new HashMap<>();

			privilegeMAP.put("code", privilege.getName());
			privilegeMAP.put("description", privilege.getName());

			lstPrivileges.add(privilegeMAP);
		}

		return lstPrivileges;
	}

	@RequestMapping(value = "/auth/permissions/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_ROLE:READ')")
	public @ResponseBody Map<String, String> getPermission(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") String id) {

		UUID uuid = UUID.fromString(id);
		Privilege privilege = privilegeRepository.getPrivilege(uuid);

		Map<String, String> privilegeMAP = new HashMap<>();

		privilegeMAP.put("code", privilege.getName());
		privilegeMAP.put("description", privilege.getName());

		return privilegeMAP;
	}

	@RequestMapping(value = "/auth/roles/{id}/permissions", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_ROLE:READ')")
	public @ResponseBody List<Map<String, String>> getRolePermission(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("id") String idRole) {
		/**
		 * String userName = jwtTokenUtil.getUsernameFromToken(tkn); String userRole =
		 * jwtTokenUtil.getRoleFromToken(tkn);
		 */
		List<Map<String, String>> lstPrivileges = new ArrayList<>();

		Authority authority = new Authority();
		UUID uuid = UUID.fromString(idRole);
		authority.setIdAuthority(uuid);

		List<AuthorityPrivilege> lstAutPriv = authorityPrivilegeRepository
				.getAuthorityPrivilegePorIdAuthority(authority);
		for (AuthorityPrivilege autPriv : lstAutPriv) {
			Map<String, String> autPrivMAP = new HashMap<>();

			autPrivMAP.put("code", autPriv.getIdPrivilege().getName());
			autPrivMAP.put("description", autPriv.getIdPrivilege().getName());

			lstPrivileges.add(autPrivMAP);
		}

		return lstPrivileges;
	}

	@RequestMapping(value = "/auth/permissionsvsroles", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_ROLE:READ')")
	public @ResponseBody List<Map<String, Object>> getPermissionVSRole(HttpServletRequest request,
			HttpServletResponse response) {
		List<Map<String, Object>> lstPrivilegeRes = new ArrayList<>();

		List<Privilege> lstPrivilege = privilegeRepository.getPrivilege();
		List<Authority> lstAuthority = authorityRepository.getAuthority();

		for (Privilege privil : lstPrivilege) {
			List<AuthorityPrivilege> lstAuth = authorityPrivilegeRepository.getAuthorityPrivilegePorIdPrivilege(privil);
			Map<String, Object> privilegeMAP = new HashMap<>();

			Map<String, String> permissionMAP = new HashMap<>();
			permissionMAP.put("id", privil.getIdPrivilege().toString());
			permissionMAP.put("resource", privil.getGrupo().getName());
			permissionMAP.put("action", privil.getName());
			permissionMAP.put("scope", "own");
			permissionMAP.put("description", privil.getName());
//<<<<<<< HEAD
//			
//			//logger.info("privilege: " + privil.getName());
//			List<Map<String, String>> roles = new ArrayList<>();
//			for( Authority authority : lstAuthority ) {
//				Map<String, String> authorithyMAP = new HashMap<>();
//				
//=======

			logger.info("privilege: " + privil.getName());
			List<Map<String, Object>> roles = new ArrayList<>();
			for (Authority authority : lstAuthority) {
				Map<String, Object> authorithyMAP = new HashMap<>();

//>>>>>>> 760130f0dfc203ff3817b90f050848a12b79684e
				authorithyMAP.put("id", authority.getIdAuthority().toString());
				authorithyMAP.put("name", authority.getName());
				authorithyMAP.put("description", authority.getName());
				boolean authPrivilege = Boolean.FALSE;
//<<<<<<< HEAD
//				
//				for( AuthorityPrivilege autPriv : lstAuth ) {
//					//logger.info("\t\t authority: " + authority.getIdAuthority().toString() + " ---->> " + autPriv.getIdAuthority().getIdAuthority().toString());
//					//if( authority.getIdAuthority().toString() == autPriv.getIdAuthority().getIdAuthority().toString() ) {
//					if( authority.getIdAuthority().toString().equals(autPriv.getIdAuthority().getIdAuthority().toString()) ) {
//=======

				for (AuthorityPrivilege autPriv : lstAuth) {
					logger.info("\t\t authority: " + authority.getIdAuthority().toString() + " ---->> "
							+ autPriv.getIdAuthority().getIdAuthority().toString());
					// if( authority.getIdAuthority().toString() ==
					// autPriv.getIdAuthority().getIdAuthority().toString() ) {
					if (authority.getIdAuthority().toString()
							.equals(autPriv.getIdAuthority().getIdAuthority().toString())) {
//>>>>>>> 760130f0dfc203ff3817b90f050848a12b79684e
						////////authPrivilege = Boolean.TRUE;
						authPrivilege = autPriv.getEnabled();
						break;
					}
				}

				if (authPrivilege) {
					authorithyMAP.put("assigned", true);
				} else {
					authorithyMAP.put("assigned", false);
				}
//<<<<<<< HEAD
//				
//				//logger.info("\t id: " + authorithyMAP.get("id") + "\t name: " + authorithyMAP.get("name") + "\t descripcion: " + authorithyMAP.get("descripcion") + "\t assigned: " + authorithyMAP.get("assigned"));
//				
//=======

				logger.info("\t id: " + authorithyMAP.get("id") + "\t name: " + authorithyMAP.get("name")
						+ "\t descripcion: " + authorithyMAP.get("descripcion") + "\t assigned: "
						+ authorithyMAP.get("assigned"));

//>>>>>>> 760130f0dfc203ff3817b90f050848a12b79684e
				roles.add(authorithyMAP);
			}

			privilegeMAP.put("permission", permissionMAP);
			privilegeMAP.put("roles", roles);
//<<<<<<< HEAD
//			
//			logger.info(permissionMAP.get("name") + " ---->> " + roles);
//=======

//>>>>>>> 760130f0dfc203ff3817b90f050848a12b79684e
			lstPrivilegeRes.add(privilegeMAP);
		}

		return lstPrivilegeRes;
	}

	@RequestMapping(value = "/auth/assign_role_permission", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_PERMISSION:CREATE') and hasRole('ROLE_PERMISSION:UPDATE')")
	public ResponseEntity<?> assignRolePermission(@RequestBody HashMap<String, String> authorityPrivilegeBean,
			UriComponentsBuilder ucBuilder, HttpServletRequest request) {
		try {
			logger.info("User REST :" + tokenHeader);
			String token = request.getHeader(tokenHeader).substring(7);
			UUID uuidRolUserAuteticado = UUID.fromString(jwtTokenUtil.getIdRoleFromToken(token));
			logger.info("uuidRolUserAuteticado :" + uuidRolUserAuteticado);

			UUID uuidRol = UUID.fromString(authorityPrivilegeBean.get("roleId"));
			UUID uuidPermission = UUID.fromString(authorityPrivilegeBean.get("permissionId"));

			logger.info("roleId: " + authorityPrivilegeBean.get("roleId") + "\tpermissionId: "
					+ authorityPrivilegeBean.get("permissionId"));
			 AuthorityPrivilege authorityPrivilegeFound =
			 authorityPrivilegeRepository.getAuthorityPrivilege(uuidRol, uuidPermission);
//			AuthorityPrivilege authorityPrivilegeFound = authorityPrivilegeRepository
//					.getAuthorityPrivilege(uuidRolUserAuteticado, uuidPermission);

			if (authorityPrivilegeFound != null) {

				authorityPrivilegeFound.setEnabled(Boolean.TRUE);
				authorityPrivilegeRepository.updateRolePermission(authorityPrivilegeFound);

				return new ResponseEntity(new JwtAuthenticationError("Permiso asignado al Rol", 201), HttpStatus.OK);
			} else {
				/**
				 * Se obtienen de base de datos para validar que son roles y permisos dados de
				 * alta en B.D.
				 **/
				Authority authority = authorityRepository.getAuthority(uuidRol);
				Privilege privilege = privilegeRepository.getPrivilege(uuidPermission);

				if (authority != null && privilege != null) {
					authorityPrivilegeFound = new AuthorityPrivilege();

					authorityPrivilegeFound.setIdAuthority(authority);
					authorityPrivilegeFound.setIdPrivilege(privilege);
					authorityPrivilegeFound.setEnabled(Boolean.TRUE);

					authorityPrivilegeRepository.insertAuthorityPrivilege(authorityPrivilegeFound);

					return new ResponseEntity(new JwtAuthenticationError("Permiso asignado al Rol", 201),
							HttpStatus.OK);
				} else {
					return new ResponseEntity(
							new JwtAuthenticationError("Permiso NO asignado a un Rol (Verifique rol y/o permiso)", 412),
							HttpStatus.PRECONDITION_FAILED);
				}
			}
		} catch (Exception e) {
			logger.error("Error --> " + e.getMessage());
			return new ResponseEntity(new JwtAuthenticationError("Permiso NO asignado a un Rol", 412),
					HttpStatus.PRECONDITION_FAILED);
		}
	}

	@RequestMapping(value = "/auth/remove_role_permission", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_PERMISSION:UPDATE')")
	public ResponseEntity<?> removeRolePermission(@RequestBody HashMap<String, String> authorityPrivilegeBean,
			UriComponentsBuilder ucBuilder, HttpServletRequest request) {
		logger.info("Esto es una prueba...");
		try {
			logger.info("User REST :" + tokenHeader);
			String token = request.getHeader(tokenHeader).substring(7);
			UUID uuidRolUserAuteticado = UUID.fromString(jwtTokenUtil.getIdRoleFromToken(token));
			logger.info("uuidRolUserAuteticado :" + uuidRolUserAuteticado);

			UUID uuidRol = UUID.fromString(authorityPrivilegeBean.get("roleId"));
			UUID uuidPermission = UUID.fromString(authorityPrivilegeBean.get("permissionId"));

			logger.info("roleId: " + authorityPrivilegeBean.get("roleId") + "\tpermissionId: "
					+ authorityPrivilegeBean.get("permissionId"));

			// Se verifica que el usuario autenticado tenga los permisos necesarios para
			// remover permisos.
			AuthorityPrivilege authorityPrivilegeFound = authorityPrivilegeRepository.getAuthorityPrivilege(uuidRol, uuidPermission);
			//AuthorityPrivilege authorityPrivilegeFound = authorityPrivilegeRepository.getAuthorityPrivilege(uuidRolUserAuteticado, uuidPermission);

			if (authorityPrivilegeFound != null) {
				// Se remueven permisos para el rol indicado (No es el mismo que esta
				// autenticado en la aplicacion, )
				// AuthorityPrivilege authorityPrivilegeFoundToModify =
				// authorityPrivilegeRepository.getAuthorityPrivilege(uuidRol, uuidPermission);

				authorityPrivilegeFound.setEnabled(Boolean.FALSE);
				authorityPrivilegeRepository.updateRolePermission(authorityPrivilegeFound);
				// authorityPrivilegeFoundToModify.setEnabled(Boolean.FALSE);
				// authorityPrivilegeRepository.updateRolePermission(authorityPrivilegeFoundToModify);

				return new ResponseEntity(new JwtAuthenticationError("Permiso desasignado al Rol", 201), HttpStatus.OK);
			} else {
				return new ResponseEntity(
						new JwtAuthenticationError("Permiso NO desasignado a Rol (Verifique rol y/o permiso)", 412),
						HttpStatus.PRECONDITION_FAILED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error --> " + e.getMessage());
			return new ResponseEntity(new JwtAuthenticationError("Permiso NO desasignado al Rol", 412),
					HttpStatus.PRECONDITION_FAILED);
		}
	}

	/*
	 * /_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
	 * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_
	 */

}
