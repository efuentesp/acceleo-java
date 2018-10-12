/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los cuentabancaria. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Cuentabancaria;
import com.softtek.acceleo.demo.repository.CuentabancariaRepository;
/**
 * Clase cuentabancariaRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("cuentabancariaRepository")
public class CuentabancariaRepositoryImpl implements CuentabancariaRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un cuentabancaria.
	 */
	public void addCuentabancaria(Cuentabancaria cuentabancaria) {
		sessionFactory.getCurrentSession().persist(cuentabancaria);
	}
	/**
	 * Edita un cuentabancaria.
	 */
	public void editCuentabancaria(Cuentabancaria cuentabancaria) {
		sessionFactory.getCurrentSession().update(cuentabancaria);

	}
	/**
	 * Consulta informacion de cuentabancaria.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Cuentabancaria> listCuentabancarias(Cuentabancaria cuentabancaria) {

		return (List<Cuentabancaria>) sessionFactory.getCurrentSession()
				.createCriteria(Cuentabancaria.class).list();
	}

	/**
	 * Consulta informacion de cuentabancaria y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Cuentabancaria> listCuentabancariasQuery(Cuentabancaria cuentabancaria, String query, int page, int size) {
		
		return (List<Cuentabancaria>) sessionFactory.getCurrentSession()
			.createCriteria(Cuentabancaria.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("cuentabancaria", "%" + query +"%"),
Restrictions.like("cuentabancaria", "%" + query +"%")),
Restrictions.like("de", "%" + query +"%")),
Restrictions.like("cuentabancaria", "%" + query +"%")),
Restrictions.like("clabe", "%" + query +"%")),
Restrictions.like("cuentabancaria", "%" + query +"%")),
Restrictions.like("cuentabancaria", "%" + query +"%")),
Restrictions.like("cuenta", "%" + query +"%")),
Restrictions.like("emitidapor", "%" + query +"%"))
					
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de cuentabancaria y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Cuentabancaria> listCuentabancariasPagination(Cuentabancaria cuentabancaria, int page, int size) {
			return (List<Cuentabancaria>) sessionFactory.getCurrentSession()
				.createCriteria(Cuentabancaria.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de cuentabancaria consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Cuentabancaria.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de cuentabancaria consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Cuentabancaria.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("cuentabancaria", "%" + query +"%"),Restrictions.like("cuentabancaria", "%" + query +"%")),Restrictions.like("de", "%" + query +"%")),Restrictions.like("cuentabancaria", "%" + query +"%")),Restrictions.like("clabe", "%" + query +"%")),Restrictions.like("cuentabancaria", "%" + query +"%")),Restrictions.like("cuentabancaria", "%" + query +"%")),Restrictions.like("cuenta", "%" + query +"%")),Restrictions.like("emitidapor", "%" + query +"%"))	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de cuentabancaria consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Cuentabancaria.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un cuentabancaria.
	 */
	public Cuentabancaria getCuentabancaria(int empid) {
		return (Cuentabancaria) sessionFactory.getCurrentSession().get(
				Cuentabancaria.class, empid);
	}

	/**
	 * Elimina un cuentabancaria.
	 */
	public void deleteCuentabancaria(Cuentabancaria cuentabancaria) {
		sessionFactory.getCurrentSession().delete(cuentabancaria);
	}

}
