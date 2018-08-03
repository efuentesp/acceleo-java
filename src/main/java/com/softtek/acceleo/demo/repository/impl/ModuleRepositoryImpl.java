/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los module. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Module;
import com.softtek.acceleo.demo.repository.ModuleRepository;
/**
 * Clase moduleRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("moduleRepository")
public class ModuleRepositoryImpl implements ModuleRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un module.
	 */
	public void addModule(Module module) {
		sessionFactory.getCurrentSession().persist(module);
	}
	/**
	 * Edita un module.
	 */
	public void editModule(Module module) {
		sessionFactory.getCurrentSession().update(module);

	}
	/**
	 * Consulta informacion de module.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Module> listModules(Module module) {

		return (List<Module>) sessionFactory.getCurrentSession()
				.createCriteria(Module.class).list();
	}

	/**
	 * Consulta informacion de module y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Module> listModulesQuery(Module module, String query, int page, int size) {
		
		return (List<Module>) sessionFactory.getCurrentSession()
			.createCriteria(Module.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("name", "%" + query +"%"),
Restrictions.like("module", "%" + query +"%")),
Restrictions.like("code", "%" + query +"%")),
Restrictions.like("module", "%" + query +"%")),
Restrictions.like("module", "%" + query +"%")),
Restrictions.like("application", "%" + query +"%")),
Restrictions.like("module", "%" + query +"%"))
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de module y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Module> listModulesPagination(Module module, int page, int size) {
			return (List<Module>) sessionFactory.getCurrentSession()
				.createCriteria(Module.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de module consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Module.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de module consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Module.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("name", "%" + query +"%"),Restrictions.like("module", "%" + query +"%")),Restrictions.like("code", "%" + query +"%")),Restrictions.like("module", "%" + query +"%")),Restrictions.like("module", "%" + query +"%")),Restrictions.like("application", "%" + query +"%")),Restrictions.like("module", "%" + query +"%"))	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de module consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Module.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un module.
	 */
	public Module getModule(int empid) {
		return (Module) sessionFactory.getCurrentSession().get(
				Module.class, empid);
	}

	/**
	 * Elimina un module.
	 */
	public void deleteModule(Module module) {
		sessionFactory.getCurrentSession().delete(module);
	}

}
