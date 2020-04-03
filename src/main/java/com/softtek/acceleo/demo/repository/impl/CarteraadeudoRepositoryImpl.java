/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los carteraadeudo. 
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
import com.softtek.acceleo.demo.domain.Carteraadeudo;
import com.softtek.acceleo.demo.repository.CarteraadeudoRepository;

/**
 * Clase carteraadeudoRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("carteraadeudoRepository")
public class CarteraadeudoRepositoryImpl implements CarteraadeudoRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un carteraadeudo.
	 */
	public void addCarteraadeudo(Carteraadeudo carteraadeudo) {
		sessionFactory.getCurrentSession().persist(carteraadeudo);
	}
	/**
	 * Edita un carteraadeudo.
	 */
	public void editCarteraadeudo(Carteraadeudo carteraadeudo) {
		sessionFactory.getCurrentSession().update(carteraadeudo);
		
	}
	/**
	 * Consulta informacion de carteraadeudo.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Carteraadeudo> listCarteraadeudos(Carteraadeudo carteraadeudo) {
		List<Carteraadeudo> carteraadeudos = sessionFactory.getCurrentSession().createCriteria(Carteraadeudo.class).list();
		return carteraadeudos;
	}
	
	/**
	 * Consulta informacion de carteraadeudo.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Carteraadeudo> listCarteraadeudosByCarteraadeudo(Carteraadeudo carteraadeudo, int id) {
		List<Carteraadeudo> carteraadeudos = 
		sessionFactory.getCurrentSession().createCriteria(Carteraadeudo.class)
		.add(Restrictions.like("carteraadeudoId",id)).list();
		return carteraadeudos;
	}
 
	/**
	 * Consulta informacion de carteraadeudo.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Carteraadeudo> listCarteraadeudosByUsername(Carteraadeudo carteraadeudo, String id) {
		List<Carteraadeudo> carteraadeudos = sessionFactory.getCurrentSession().createCriteria(Carteraadeudo.class).add(Restrictions.like("username",id)).list();
		return carteraadeudos;
	}
	
	/**
	 * Consulta informacion de carteraadeudo y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Carteraadeudo> listCarteraadeudosQuery(Carteraadeudo carteraadeudo, String query, int page, int size) {
		
		return (List<Carteraadeudo>) sessionFactory.getCurrentSession()
			.createCriteria(Carteraadeudo.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.like("carteraadeudo", "%" + query +"%"), 
			Restrictions.like("honorarioscontratoId", "%" + query +"%")),
			Restrictions.like("folioadeudo", "%" + query +"%")),
			Restrictions.like("calificacion", "%" + query +"%")),
			Restrictions.like("fechacalculo", "%" + query +"%")),
			Restrictions.like("del", "%" + query +"%")),
			Restrictions.like("al", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("importe", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de carteraadeudo y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Carteraadeudo> listCarteraadeudosPagination(Carteraadeudo carteraadeudo, int page, int size) {
			return (List<Carteraadeudo>) sessionFactory.getCurrentSession()
				.createCriteria(Carteraadeudo.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de carteraadeudo consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Carteraadeudo.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de carteraadeudo consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Carteraadeudo.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.like("carteraadeudo", "%" + query +"%"), 
			Restrictions.like("honorarioscontratoId", "%" + query +"%")),
			Restrictions.like("folioadeudo", "%" + query +"%")),
			Restrictions.like("calificacion", "%" + query +"%")),
			Restrictions.like("fechacalculo", "%" + query +"%")),
			Restrictions.like("del", "%" + query +"%")),
			Restrictions.like("al", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("importe", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de carteraadeudo consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Carteraadeudo.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un carteraadeudo.
	 */
	public Carteraadeudo getCarteraadeudo(UUID empid) {
		return (Carteraadeudo) sessionFactory.getCurrentSession().get(
				Carteraadeudo.class, empid);
	}

	/**
	 * Elimina un carteraadeudo.
	 */
	public void deleteCarteraadeudo(Carteraadeudo carteraadeudo) {
		sessionFactory.getCurrentSession().delete(carteraadeudo);
	}

}

