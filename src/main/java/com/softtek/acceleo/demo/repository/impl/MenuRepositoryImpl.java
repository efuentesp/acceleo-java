/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los menu. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Menu;
import com.softtek.acceleo.demo.repository.MenuRepository;
/**
 * Clase menuRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("menuRepository")
public class MenuRepositoryImpl implements MenuRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un menu.
	 */
	public void addMenu(Menu menu) {
		sessionFactory.getCurrentSession().persist(menu);
	}
	/**
	 * Edita un menu.
	 */
	public void editMenu(Menu menu) {
		sessionFactory.getCurrentSession().update(menu);

	}
	/**
	 * Consulta informacion de menu.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Menu> listMenus(Menu menu) {

		return (List<Menu>) sessionFactory.getCurrentSession()
				.createCriteria(Menu.class).list();
	}

	/**
	 * Consulta informacion de menu y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Menu> listMenusQuery(Menu menu, String query, int page, int size) {
		
		return (List<Menu>) sessionFactory.getCurrentSession()
			.createCriteria(Menu.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("menu", "%" + query +"%"),
Restrictions.like("path", "%" + query +"%")),
Restrictions.like("menu", "%" + query +"%")),
Restrictions.like("code", "%" + query +"%")),
Restrictions.like("module", "%" + query +"%"))
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de menu y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Menu> listMenusPagination(Menu menu, int page, int size) {
			return (List<Menu>) sessionFactory.getCurrentSession()
				.createCriteria(Menu.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de menu consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Menu.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de menu consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Menu.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("menu", "%" + query +"%"),Restrictions.like("path", "%" + query +"%")),Restrictions.like("menu", "%" + query +"%")),Restrictions.like("code", "%" + query +"%")),Restrictions.like("module", "%" + query +"%"))	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de menu consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Menu.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un menu.
	 */
	public Menu getMenu(int empid) {
		return (Menu) sessionFactory.getCurrentSession().get(
				Menu.class, empid);
	}

	/**
	 * Elimina un menu.
	 */
	public void deleteMenu(Menu menu) {
		sessionFactory.getCurrentSession().delete(menu);
	}

}
