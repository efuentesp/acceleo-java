/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Menus. 
 */
package com.softtek.acceleo.demo.catalogo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.RestController;
import com.softtek.acceleo.demo.exception.GenericException;

import com.softtek.acceleo.demo.catalogo.bean.MenuBean;
import com.softtek.acceleo.demo.domain.Menu;
import com.softtek.acceleo.demo.service.MenuService;

/**
 * Clase MenuController.
 * @author PSG.
 *
 */
@RestController
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	Menu menu = new Menu();

	/************************************** SEARCH
	 * Obtiene informacion de los menus.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Menu>.
	 */
	@RequestMapping(value = "/menu", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('MENUSEARCH')")
	public @ResponseBody  List<Menu> getMenus(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Menu> listMenu = null;

		if (query==null && _page == 0) {
       		listMenu = menuService.listMenus(menu);
			rows = menuService.getTotalRows();
		} else if (query!= null){
			listMenu = menuService.listMenusQuery(menu, query, _page, 10);
			rows = menuService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listMenu = menuService.listMenusPagination(menu, _page, 10);
			rows = menuService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listMenu;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un menu.
	 * @param id.
	 * @return Menu.
	 */
	@RequestMapping(value = "/idmenu/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('MENUSEARCH')")
	    public @ResponseBody  Menu getMenu(@PathVariable("id") int id) {	        
	        Menu menu = null;
	        
	        menu = menuService.getMenu(id);
			return menu;
	 }

	/*************************** CREATE
	 * Crea un nuevo menu.
	 * @param menu.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/menu", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('MENUCREATE')")
	    public ResponseEntity<Void> createMenu(@RequestBody Menu menu,    UriComponentsBuilder ucBuilder) {
	   
	        menuService.addMenu(menu);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/menu/{id}").buildAndExpand(menu.getMenuId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un menu.
	  * @param id.
	  * @param menu.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/menu/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('MENUUPDATE')") 
	    public ResponseEntity<Menu> actualizarMenu(
				@PathVariable("id") int id, 
				@RequestBody Menu menu) {
	        
	        Menu menuFound = menuService.getMenu(id);
	         
	        if (menuFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Menu>(HttpStatus.NOT_FOUND);
	        }
	
	menuFound.setPath(menu.getPath());
	menuFound.setCode(menu.getCode());
menuFound.setModuleId(menu.getModuleId());

			
			menuFound.setMenuId(menu.getMenuId());

		    menuService.editMenu(menuFound);
	        return new ResponseEntity<Menu>(menuFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un menu.
		 * @param id.
		 * @return ResponseEntity<Menu>.
		 */
		@RequestMapping(value = "/menu/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('MENUDELETE')")  
	    public ResponseEntity<Menu> deleteMenu(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Menu menu = menuService.getMenu(id);
	         if (menu == null) {
	             return new ResponseEntity<Menu>(HttpStatus.NOT_FOUND);
	         }
	  
           
	             menuService.deleteMenu(menu);
            	 return new ResponseEntity<Menu>(HttpStatus.OK);
           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Menu>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un menu.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveMenu", method = RequestMethod.POST)
	@PreAuthorize("hasRole('MENU')")  
	public @ResponseBody String saveMenu(
			@ModelAttribute("command") MenuBean menuBean) {

		Menu menu = prepareModel(menuBean);
		menuService.addMenu(menu);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un menu.
	 * @param menuBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editMenu", method = RequestMethod.POST)
	@PreAuthorize("hasRole('MENU')")  
	public @ResponseBody String editMenu(
			@ModelAttribute("command") MenuBean menuBean) {


		Menu menu = prepareModel(menuBean);
		menuService.editMenu(menu);
		return "SUCCESS";
	}

	/**
	 * Agrega un MENU.
	 * @param MENUBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchMenu", method = RequestMethod.GET)
	@PreAuthorize("hasRole('MENU')")  
	public ModelAndView addMenu(
			@ModelAttribute("command") MenuBean menuBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Menu menu = null;
		if (menuBean != null)
			menu = prepareModel(menuBean);
		model.put("menus",
				prepareListofBean(menuService.listMenus(menu)));
		return new ModelAndView("searchMenu", model);
	}

	/**
	 * Elimina un menu.
	 * @param menuBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteMenu", method = RequestMethod.POST)
	@PreAuthorize("hasRole('MENU')")  
	public ModelAndView deleteMenu(
			@ModelAttribute("command") MenuBean menuBean,
			BindingResult result) {
		System.out.println("delete " + menuBean.getMenuId());
		menuService.deleteMenu(prepareModel(menuBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menu", null);
		model.put("menus",
				prepareListofBean(menuService.listMenus(null)));
		return new ModelAndView("searchMenu", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryMenu", method = RequestMethod.GET)
	@PreAuthorize("hasRole('MENU')")  
	public ModelAndView entryMenu() {
		return new ModelAndView("redirect:/searchMenu");
	}

	private Menu prepareModel(MenuBean menuBean) {
		Menu menu = new Menu();

		menu.setModuleId(menuBean.getModuleId());
		//menu.setDisplay_resultmenuId(menuBean.getMenuId());
		//menu.setExposed_filtermenuId(menuBean.getMenuId());
		menu.setCode(menuBean.getCode());
		menu.setPath(menuBean.getPath());
		menu.setMenuId(menuBean.getMenuId());
		menuBean.setMenuId(null);

		return menu;
	}

	/**
	 * Convierte un objeto de tipo MenuBean a un objeto de tipo Menu.
	 * @param menuBean.
	 * @return Menu.
	 */
	private List<MenuBean> prepareListofBean(List<Menu> menus) {
		List<MenuBean> beans = null;
		if (menus != null && !menus.isEmpty()) {
			beans = new ArrayList<MenuBean>();
			MenuBean bean = null;
			for (Menu menu : menus) {
				bean = new MenuBean();

				bean.setModuleId(menu.getModuleId());
				//bean.setDisplay_resultmenuId(menu.getMenuId());
				//bean.setExposed_filtermenuId(menu.getMenuId());
				bean.setCode(menu.getCode());
				bean.setPath(menu.getPath());
				bean.setMenuId(menu.getMenuId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


