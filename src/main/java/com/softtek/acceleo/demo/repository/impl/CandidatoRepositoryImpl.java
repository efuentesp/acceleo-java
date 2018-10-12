/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los candidato. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Candidato;
import com.softtek.acceleo.demo.repository.CandidatoRepository;
/**
 * Clase candidatoRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("candidatoRepository")
public class CandidatoRepositoryImpl implements CandidatoRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un candidato.
	 */
	public void addCandidato(Candidato candidato) {
		sessionFactory.getCurrentSession().persist(candidato);
	}
	/**
	 * Edita un candidato.
	 */
	public void editCandidato(Candidato candidato) {
		sessionFactory.getCurrentSession().update(candidato);

	}
	/**
	 * Consulta informacion de candidato.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Candidato> listCandidatos(Candidato candidato) {

		return (List<Candidato>) sessionFactory.getCurrentSession()
				.createCriteria(Candidato.class).list();
	}

	/**
	 * Consulta informacion de candidato y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Candidato> listCandidatosQuery(Candidato candidato, String query, int page, int size) {
		
		return (List<Candidato>) sessionFactory.getCurrentSession()
			.createCriteria(Candidato.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("solicitud", "%" + query +"%"),
Restrictions.like("fecha", "%" + query +"%")),
Restrictions.like("candidato", "%" + query +"%")),
Restrictions.like("estado", "%" + query +"%")),
Restrictions.like("candidato", "%" + query +"%")),
Restrictions.like("apellidomaterno", "%" + query +"%")),
Restrictions.like("apellidopaterno", "%" + query +"%")),
Restrictions.like("evento", "%" + query +"%")),
Restrictions.like("es", "%" + query +"%")),
Restrictions.like("candidato", "%" + query +"%")),
Restrictions.like("nombre", "%" + query +"%")),
Restrictions.like("candidato", "%" + query +"%")),
Restrictions.like("candidato", "%" + query +"%"))
					
					
					
					
					
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de candidato y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Candidato> listCandidatosPagination(Candidato candidato, int page, int size) {
			return (List<Candidato>) sessionFactory.getCurrentSession()
				.createCriteria(Candidato.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de candidato consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Candidato.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de candidato consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Candidato.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("solicitud", "%" + query +"%"),Restrictions.like("fecha", "%" + query +"%")),Restrictions.like("candidato", "%" + query +"%")),Restrictions.like("estado", "%" + query +"%")),Restrictions.like("candidato", "%" + query +"%")),Restrictions.like("apellidomaterno", "%" + query +"%")),Restrictions.like("apellidopaterno", "%" + query +"%")),Restrictions.like("evento", "%" + query +"%")),Restrictions.like("es", "%" + query +"%")),Restrictions.like("candidato", "%" + query +"%")),Restrictions.like("nombre", "%" + query +"%")),Restrictions.like("candidato", "%" + query +"%")),Restrictions.like("candidato", "%" + query +"%"))	
	
	
	
	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de candidato consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Candidato.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un candidato.
	 */
	public Candidato getCandidato(int empid) {
		return (Candidato) sessionFactory.getCurrentSession().get(
				Candidato.class, empid);
	}

	/**
	 * Elimina un candidato.
	 */
	public void deleteCandidato(Candidato candidato) {
		sessionFactory.getCurrentSession().delete(candidato);
	}

}
