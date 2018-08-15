/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los cuentadeahorro. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Cuentadeahorro;
import com.softtek.acceleo.demo.repository.CuentadeahorroRepository;
/**
 * Clase cuentadeahorroRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("cuentadeahorroRepository")
public class CuentadeahorroRepositoryImpl implements CuentadeahorroRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un cuentadeahorro.
	 */
	public void addCuentadeahorro(Cuentadeahorro cuentadeahorro) {
		sessionFactory.getCurrentSession().persist(cuentadeahorro);
	}
	/**
	 * Edita un cuentadeahorro.
	 */
	public void editCuentadeahorro(Cuentadeahorro cuentadeahorro) {
		sessionFactory.getCurrentSession().update(cuentadeahorro);

	}
	/**
	 * Consulta informacion de cuentadeahorro.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Cuentadeahorro> listCuentadeahorros(Cuentadeahorro cuentadeahorro) {

		return (List<Cuentadeahorro>) sessionFactory.getCurrentSession()
				.createCriteria(Cuentadeahorro.class).list();
	}

	/**
	 * Consulta informacion de cuentadeahorro y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Cuentadeahorro> listCuentadeahorrosQuery(Cuentadeahorro cuentadeahorro, String query, int page, int size) {
		
		return (List<Cuentadeahorro>) sessionFactory.getCurrentSession()
			.createCriteria(Cuentadeahorro.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("fechadisponibilidad", "%" + query +"%"),
Restrictions.like("cuentadeahorro", "%" + query +"%")),
Restrictions.like("fechacontratacion", "%" + query +"%")),
Restrictions.like("cuentadeahorro", "%" + query +"%")),
Restrictions.like("cuentadeahorro", "%" + query +"%")),
Restrictions.like("numero", "%" + query +"%")),
Restrictions.like("tipo", "%" + query +"%")),
Restrictions.like("fechavencimiento", "%" + query +"%")),
Restrictions.like("cuentadeahorro", "%" + query +"%")),
Restrictions.like("cuentadeahorro", "%" + query +"%"))
					
					
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de cuentadeahorro y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Cuentadeahorro> listCuentadeahorrosPagination(Cuentadeahorro cuentadeahorro, int page, int size) {
			return (List<Cuentadeahorro>) sessionFactory.getCurrentSession()
				.createCriteria(Cuentadeahorro.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de cuentadeahorro consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Cuentadeahorro.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de cuentadeahorro consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Cuentadeahorro.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("fechadisponibilidad", "%" + query +"%"),Restrictions.like("cuentadeahorro", "%" + query +"%")),Restrictions.like("fechacontratacion", "%" + query +"%")),Restrictions.like("cuentadeahorro", "%" + query +"%")),Restrictions.like("cuentadeahorro", "%" + query +"%")),Restrictions.like("numero", "%" + query +"%")),Restrictions.like("tipo", "%" + query +"%")),Restrictions.like("fechavencimiento", "%" + query +"%")),Restrictions.like("cuentadeahorro", "%" + query +"%")),Restrictions.like("cuentadeahorro", "%" + query +"%"))	
	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de cuentadeahorro consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Cuentadeahorro.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un cuentadeahorro.
	 */
	public Cuentadeahorro getCuentadeahorro(int empid) {
		return (Cuentadeahorro) sessionFactory.getCurrentSession().get(
				Cuentadeahorro.class, empid);
	}

	/**
	 * Elimina un cuentadeahorro.
	 */
	public void deleteCuentadeahorro(Cuentadeahorro cuentadeahorro) {
		sessionFactory.getCurrentSession().delete(cuentadeahorro);
	}

}
