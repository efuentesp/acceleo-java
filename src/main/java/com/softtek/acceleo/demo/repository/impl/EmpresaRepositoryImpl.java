/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los empresa. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Empresa;
import com.softtek.acceleo.demo.repository.EmpresaRepository;
/**
 * Clase empresaRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("empresaRepository")
public class EmpresaRepositoryImpl implements EmpresaRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un empresa.
	 */
	public void addEmpresa(Empresa empresa) {
		sessionFactory.getCurrentSession().persist(empresa);
	}
	/**
	 * Edita un empresa.
	 */
	public void editEmpresa(Empresa empresa) {
		sessionFactory.getCurrentSession().update(empresa);

	}
	/**
	 * Consulta informacion de empresa.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Empresa> listEmpresas(Empresa empresa) {

		return (List<Empresa>) sessionFactory.getCurrentSession()
				.createCriteria(Empresa.class).list();
	}

	/**
	 * Consulta informacion de empresa y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Empresa> listEmpresasQuery(Empresa empresa, String query, int page, int size) {
		
		return (List<Empresa>) sessionFactory.getCurrentSession()
			.createCriteria(Empresa.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("empresa", "%" + query +"%"),
Restrictions.like("empresa", "%" + query +"%")),
Restrictions.like("clave", "%" + query +"%")),
Restrictions.like("nombrecorto", "%" + query +"%")),
Restrictions.like("empresa", "%" + query +"%")),
Restrictions.like("razonsocial", "%" + query +"%")),
Restrictions.like("empresa", "%" + query +"%")),
Restrictions.like("empresa", "%" + query +"%"))
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de empresa y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Empresa> listEmpresasPagination(Empresa empresa, int page, int size) {
			return (List<Empresa>) sessionFactory.getCurrentSession()
				.createCriteria(Empresa.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de empresa consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Empresa.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de empresa consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Empresa.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("empresa", "%" + query +"%"),Restrictions.like("empresa", "%" + query +"%")),Restrictions.like("clave", "%" + query +"%")),Restrictions.like("nombrecorto", "%" + query +"%")),Restrictions.like("empresa", "%" + query +"%")),Restrictions.like("razonsocial", "%" + query +"%")),Restrictions.like("empresa", "%" + query +"%")),Restrictions.like("empresa", "%" + query +"%"))	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de empresa consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Empresa.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un empresa.
	 */
	public Empresa getEmpresa(int empid) {
		return (Empresa) sessionFactory.getCurrentSession().get(
				Empresa.class, empid);
	}

	/**
	 * Elimina un empresa.
	 */
	public void deleteEmpresa(Empresa empresa) {
		sessionFactory.getCurrentSession().delete(empresa);
	}

}
