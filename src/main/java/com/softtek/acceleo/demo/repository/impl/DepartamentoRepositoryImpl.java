/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los departamento. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Departamento;
import com.softtek.acceleo.demo.repository.DepartamentoRepository;
/**
 * Clase departamentoRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("departamentoRepository")
public class DepartamentoRepositoryImpl implements DepartamentoRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un departamento.
	 */
	public void addDepartamento(Departamento departamento) {
		sessionFactory.getCurrentSession().persist(departamento);
	}
	/**
	 * Edita un departamento.
	 */
	public void editDepartamento(Departamento departamento) {
		sessionFactory.getCurrentSession().update(departamento);

	}
	/**
	 * Consulta informacion de departamento.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Departamento> listDepartamentos(Departamento departamento) {

		return (List<Departamento>) sessionFactory.getCurrentSession()
				.createCriteria(Departamento.class).list();
	}

	/**
	 * Consulta informacion de departamento y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Departamento> listDepartamentosQuery(Departamento departamento, String query, int page, int size) {
		
		return (List<Departamento>) sessionFactory.getCurrentSession()
			.createCriteria(Departamento.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("representante", "%" + query +"%"),
Restrictions.like("departamento", "%" + query +"%")),
Restrictions.like("departamento", "%" + query +"%")),
Restrictions.like("departamento", "%" + query +"%")),
Restrictions.like("nombredepto", "%" + query +"%")),
Restrictions.like("pertenece", "%" + query +"%")),
Restrictions.like("departamento", "%" + query +"%")),
Restrictions.like("departamento", "%" + query +"%"))
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de departamento y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Departamento> listDepartamentosPagination(Departamento departamento, int page, int size) {
			return (List<Departamento>) sessionFactory.getCurrentSession()
				.createCriteria(Departamento.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de departamento consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Departamento.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de departamento consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Departamento.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("representante", "%" + query +"%"),Restrictions.like("departamento", "%" + query +"%")),Restrictions.like("departamento", "%" + query +"%")),Restrictions.like("departamento", "%" + query +"%")),Restrictions.like("nombredepto", "%" + query +"%")),Restrictions.like("pertenece", "%" + query +"%")),Restrictions.like("departamento", "%" + query +"%")),Restrictions.like("departamento", "%" + query +"%"))	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de departamento consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Departamento.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un departamento.
	 */
	public Departamento getDepartamento(int empid) {
		return (Departamento) sessionFactory.getCurrentSession().get(
				Departamento.class, empid);
	}

	/**
	 * Elimina un departamento.
	 */
	public void deleteDepartamento(Departamento departamento) {
		sessionFactory.getCurrentSession().delete(departamento);
	}

}
