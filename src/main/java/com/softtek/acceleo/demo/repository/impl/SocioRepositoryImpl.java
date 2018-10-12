/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los socio. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Socio;
import com.softtek.acceleo.demo.repository.SocioRepository;
/**
 * Clase socioRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("socioRepository")
public class SocioRepositoryImpl implements SocioRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un socio.
	 */
	public void addSocio(Socio socio) {
		sessionFactory.getCurrentSession().persist(socio);
	}
	/**
	 * Edita un socio.
	 */
	public void editSocio(Socio socio) {
		sessionFactory.getCurrentSession().update(socio);

	}
	/**
	 * Consulta informacion de socio.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Socio> listSocios(Socio socio) {

		return (List<Socio>) sessionFactory.getCurrentSession()
				.createCriteria(Socio.class).list();
	}

	/**
	 * Consulta informacion de socio y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Socio> listSociosQuery(Socio socio, String query, int page, int size) {
		
		return (List<Socio>) sessionFactory.getCurrentSession()
			.createCriteria(Socio.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("telefono", "%" + query +"%"),
Restrictions.like("apellidopaterno", "%" + query +"%")),
Restrictions.like("es", "%" + query +"%")),
Restrictions.like("socio", "%" + query +"%")),
Restrictions.like("numero", "%" + query +"%")),
Restrictions.like("pertenece", "%" + query +"%")),
Restrictions.like("nombre", "%" + query +"%")),
Restrictions.like("labora", "%" + query +"%")),
Restrictions.like("socio", "%" + query +"%")),
Restrictions.like("correo", "%" + query +"%")),
Restrictions.like("apellidomaterno", "%" + query +"%")),
Restrictions.like("socio", "%" + query +"%")),
Restrictions.like("socio", "%" + query +"%")),
Restrictions.like("tipo", "%" + query +"%")),
Restrictions.like("socio", "%" + query +"%"))
					
					
					
					
					
					
					
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de socio y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Socio> listSociosPagination(Socio socio, int page, int size) {
			return (List<Socio>) sessionFactory.getCurrentSession()
				.createCriteria(Socio.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de socio consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Socio.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de socio consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Socio.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("telefono", "%" + query +"%"),Restrictions.like("apellidopaterno", "%" + query +"%")),Restrictions.like("es", "%" + query +"%")),Restrictions.like("socio", "%" + query +"%")),Restrictions.like("numero", "%" + query +"%")),Restrictions.like("pertenece", "%" + query +"%")),Restrictions.like("nombre", "%" + query +"%")),Restrictions.like("labora", "%" + query +"%")),Restrictions.like("socio", "%" + query +"%")),Restrictions.like("correo", "%" + query +"%")),Restrictions.like("apellidomaterno", "%" + query +"%")),Restrictions.like("socio", "%" + query +"%")),Restrictions.like("socio", "%" + query +"%")),Restrictions.like("tipo", "%" + query +"%")),Restrictions.like("socio", "%" + query +"%"))	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de socio consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Socio.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un socio.
	 */
	public Socio getSocio(int empid) {
		return (Socio) sessionFactory.getCurrentSession().get(
				Socio.class, empid);
	}

	/**
	 * Elimina un socio.
	 */
	public void deleteSocio(Socio socio) {
		sessionFactory.getCurrentSession().delete(socio);
	}

}
