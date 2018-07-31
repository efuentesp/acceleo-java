
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los menus. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.MenuRepository;
import com.softtek.acceleo.demo.domain.Menu;
import com.softtek.acceleo.demo.service.MenuService;
/**
 * Clase MenuServiceImpl.
 * @author PSG.
 *
 */
@Service("menuService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;

	/**
	 * Agrega un menu.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addMenu(Menu menu) {
		
		menuRepository.addMenu(menu);
	}

	/**
	 * Edita un menu.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editMenu(Menu menu) {
		
		menuRepository.editMenu(menu);
	}
	
	/**
	 * Consulta informacion de menus.
	 */
	public List<Menu> listMenus(Menu menu) {

		return menuRepository.listMenus(menu);
	}

	/**
	 * Obtiene informacion de un menu.
	 */
	public Menu getMenu(int empid) {

		return menuRepository.getMenu(empid);
	}

	/**
	 * Elimina un menu.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteMenu(Menu menu) {
		System.out.println("Entrando al deleteMenu");

		 menuRepository.deleteMenu(menu);
	}

	/**
	 * Consulta informacion de menus y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Menu> listMenusPagination(Menu menu, int page, int size) {

		return menuRepository.listMenusPagination(menu, page, size);
	}

	/**
	 * Obtiene el numero de menus consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return menuRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de menus consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return menuRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de menus consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return menuRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los menus y la pagina.
	 */
	public List<Menu> listMenusQuery(Menu menu, String query, int page, int size) {
		// TODO Auto-generated method stub
		return menuRepository.listMenusQuery(menu, query, page, size);
	}

}

