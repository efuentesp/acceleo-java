/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los comitetecnico. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.softtek.acceleo.demo.domain.Comitetecnico;
import com.softtek.acceleo.demo.repository.ComitetecnicoRepository;

/**
 * Clase comitetecnicoRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("comitetecnicoRepository")
public class ComitetecnicoRepositoryImpl implements ComitetecnicoRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un comitetecnico.
	 */
	public void addComitetecnico(Comitetecnico comitetecnico) {
		sessionFactory.getCurrentSession().persist(comitetecnico);
	}
	/**
	 * Edita un comitetecnico.
	 */
	public void editComitetecnico(Comitetecnico comitetecnico) {
		sessionFactory.getCurrentSession().update(comitetecnico);
		
	}
	/**
	 * Consulta informacion de comitetecnico.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Comitetecnico> listComitetecnicos(Comitetecnico comitetecnico) {
		List<Comitetecnico> comitetecnicos = sessionFactory.getCurrentSession().createCriteria(Comitetecnico.class).list();
		return comitetecnicos;
	}
	
	/**
	 * Consulta informacion de comitetecnico.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Comitetecnico> listComitetecnicosByComitetecnico(Comitetecnico comitetecnico, int id) {
		List<Comitetecnico> comitetecnicos = 
		sessionFactory.getCurrentSession().createCriteria(Comitetecnico.class)
		.add(Restrictions.like("comitetecnicoId",id)).list();
		return comitetecnicos;
	}
 
	/**
	 * Consulta informacion de comitetecnico.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Comitetecnico> listComitetecnicosByUsername(Comitetecnico comitetecnico, String id) {
		List<Comitetecnico> comitetecnicos = sessionFactory.getCurrentSession().createCriteria(Comitetecnico.class).add(Restrictions.like("username",id)).list();
		return comitetecnicos;
	}
	
	/**
	 * Consulta informacion de comitetecnico y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Comitetecnico> listComitetecnicosQuery(Comitetecnico comitetecnico, String query, int page, int size) {
		
		return (List<Comitetecnico>) sessionFactory.getCurrentSession()
			.createCriteria(Comitetecnico.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("comitetecnico", "%" + query +"%"), 
			Restrictions.like("dummy", "%" + query +"%")),
			Restrictions.like("generalesfideicomisoId", "%" + query +"%")),
			Restrictions.like("generalesnombre", "%" + query +"%")),
			Restrictions.like("generalesintegracion", "%" + query +"%")),
			Restrictions.like("generalesfacultades", "%" + query +"%")),
			Restrictions.like("generalescomentarios", "%" + query +"%")),
			Restrictions.like("generalesfechaconstitucion", "%" + query +"%")),
			Restrictions.like("generalesmiembrosquorum", "%" + query +"%")),
			Restrictions.like("generalesestatus", "%" + query +"%")),
			Restrictions.like("presidentepropietarionombre", "%" + query +"%")),
			Restrictions.like("presidentepropietariopropietario", "%" + query +"%")),
			Restrictions.like("presidentepropietariopropietarionacionalidad", "%" + query +"%")),
			Restrictions.like("presidentepropietariopropietariosino", "%" + query +"%")),
			Restrictions.like("presidentesuplentenombre", "%" + query +"%")),
			Restrictions.like("presidentesuplentepropietario", "%" + query +"%")),
			Restrictions.like("presidentesuplentepropietarionacionalidad", "%" + query +"%")),
			Restrictions.like("presidentesuplentepropietariosino", "%" + query +"%")),
			Restrictions.like("secretariopropietarionombre", "%" + query +"%")),
			Restrictions.like("secretariopropietariopropietario", "%" + query +"%")),
			Restrictions.like("secretariopropietariopropietarionacionalidad", "%" + query +"%")),
			Restrictions.like("secretariopropietariopropietariosino", "%" + query +"%")),
			Restrictions.like("secretariosuplentenombre", "%" + query +"%")),
			Restrictions.like("secretariosuplentepropietario", "%" + query +"%")),
			Restrictions.like("secretariosuplentepropietarionacionalidad", "%" + query +"%")),
			Restrictions.like("secretariosuplentepropietariosino", "%" + query +"%")),
			Restrictions.like("vocalpropietarionombre", "%" + query +"%")),
			Restrictions.like("vocalpropietariopropietario", "%" + query +"%")),
			Restrictions.like("vocalpropietariopropietarionacionalidad", "%" + query +"%")),
			Restrictions.like("vocalpropietariopropietariosino", "%" + query +"%")),
			Restrictions.like("vocalsuplentenombre", "%" + query +"%")),
			Restrictions.like("vocalsuplentepropietario", "%" + query +"%")),
			Restrictions.like("vocalsuplentepropietarionacionalidad", "%" + query +"%")),
			Restrictions.like("vocalsuplentepropietariosino", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de comitetecnico y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Comitetecnico> listComitetecnicosPagination(Comitetecnico comitetecnico, int page, int size) {
			return (List<Comitetecnico>) sessionFactory.getCurrentSession()
				.createCriteria(Comitetecnico.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de comitetecnico consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Comitetecnico.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de comitetecnico consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Comitetecnico.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("comitetecnico", "%" + query +"%"), 
			Restrictions.like("dummy", "%" + query +"%")),
			Restrictions.like("generalesfideicomisoId", "%" + query +"%")),
			Restrictions.like("generalesnombre", "%" + query +"%")),
			Restrictions.like("generalesintegracion", "%" + query +"%")),
			Restrictions.like("generalesfacultades", "%" + query +"%")),
			Restrictions.like("generalescomentarios", "%" + query +"%")),
			Restrictions.like("generalesfechaconstitucion", "%" + query +"%")),
			Restrictions.like("generalesmiembrosquorum", "%" + query +"%")),
			Restrictions.like("generalesestatus", "%" + query +"%")),
			Restrictions.like("presidentepropietarionombre", "%" + query +"%")),
			Restrictions.like("presidentepropietariopropietario", "%" + query +"%")),
			Restrictions.like("presidentepropietariopropietarionacionalidad", "%" + query +"%")),
			Restrictions.like("presidentepropietariopropietariosino", "%" + query +"%")),
			Restrictions.like("presidentesuplentenombre", "%" + query +"%")),
			Restrictions.like("presidentesuplentepropietario", "%" + query +"%")),
			Restrictions.like("presidentesuplentepropietarionacionalidad", "%" + query +"%")),
			Restrictions.like("presidentesuplentepropietariosino", "%" + query +"%")),
			Restrictions.like("secretariopropietarionombre", "%" + query +"%")),
			Restrictions.like("secretariopropietariopropietario", "%" + query +"%")),
			Restrictions.like("secretariopropietariopropietarionacionalidad", "%" + query +"%")),
			Restrictions.like("secretariopropietariopropietariosino", "%" + query +"%")),
			Restrictions.like("secretariosuplentenombre", "%" + query +"%")),
			Restrictions.like("secretariosuplentepropietario", "%" + query +"%")),
			Restrictions.like("secretariosuplentepropietarionacionalidad", "%" + query +"%")),
			Restrictions.like("secretariosuplentepropietariosino", "%" + query +"%")),
			Restrictions.like("vocalpropietarionombre", "%" + query +"%")),
			Restrictions.like("vocalpropietariopropietario", "%" + query +"%")),
			Restrictions.like("vocalpropietariopropietarionacionalidad", "%" + query +"%")),
			Restrictions.like("vocalpropietariopropietariosino", "%" + query +"%")),
			Restrictions.like("vocalsuplentenombre", "%" + query +"%")),
			Restrictions.like("vocalsuplentepropietario", "%" + query +"%")),
			Restrictions.like("vocalsuplentepropietarionacionalidad", "%" + query +"%")),
			Restrictions.like("vocalsuplentepropietariosino", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de comitetecnico consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Comitetecnico.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un comitetecnico.
	 */
	public Comitetecnico getComitetecnico(UUID empid) {
		return (Comitetecnico) sessionFactory.getCurrentSession().get(
				Comitetecnico.class, empid);
	}

	/**
	 * Elimina un comitetecnico.
	 */
	public void deleteComitetecnico(Comitetecnico comitetecnico) {
		sessionFactory.getCurrentSession().delete(comitetecnico);
	}

}

