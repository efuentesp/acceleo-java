/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los aportacioninmueble. 
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
import com.softtek.acceleo.demo.domain.Aportacioninmueble;
import com.softtek.acceleo.demo.repository.AportacioninmuebleRepository;

/**
 * Clase aportacioninmuebleRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("aportacioninmuebleRepository")
public class AportacioninmuebleRepositoryImpl implements AportacioninmuebleRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un aportacioninmueble.
	 */
	public void addAportacioninmueble(Aportacioninmueble aportacioninmueble) {
		sessionFactory.getCurrentSession().persist(aportacioninmueble);
	}
	/**
	 * Edita un aportacioninmueble.
	 */
	public void editAportacioninmueble(Aportacioninmueble aportacioninmueble) {
		sessionFactory.getCurrentSession().update(aportacioninmueble);
		
	}
	/**
	 * Consulta informacion de aportacioninmueble.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Aportacioninmueble> listAportacioninmuebles(Aportacioninmueble aportacioninmueble) {
		List<Aportacioninmueble> aportacioninmuebles = sessionFactory.getCurrentSession().createCriteria(Aportacioninmueble.class).list();
		return aportacioninmuebles;
	}
	
	/**
	 * Consulta informacion de aportacioninmueble.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Aportacioninmueble> listAportacioninmueblesByAportacioninmueble(Aportacioninmueble aportacioninmueble, int id) {
		List<Aportacioninmueble> aportacioninmuebles = 
		sessionFactory.getCurrentSession().createCriteria(Aportacioninmueble.class)
		.add(Restrictions.like("aportacioninmuebleId",id)).list();
		return aportacioninmuebles;
	}
 
	/**
	 * Consulta informacion de aportacioninmueble.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Aportacioninmueble> listAportacioninmueblesByUsername(Aportacioninmueble aportacioninmueble, String id) {
		List<Aportacioninmueble> aportacioninmuebles = sessionFactory.getCurrentSession().createCriteria(Aportacioninmueble.class).add(Restrictions.like("username",id)).list();
		return aportacioninmuebles;
	}
	
	/**
	 * Consulta informacion de aportacioninmueble y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Aportacioninmueble> listAportacioninmueblesQuery(Aportacioninmueble aportacioninmueble, String query, int page, int size) {
		
		return (List<Aportacioninmueble>) sessionFactory.getCurrentSession()
			.createCriteria(Aportacioninmueble.class).setFirstResult((page - 1) * size)
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
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.like("aportacioninmueble", "%" + query +"%"), 
			Restrictions.like("dummy", "%" + query +"%")),
			Restrictions.like("datosfideicomisofideicomisoId", "%" + query +"%")),
			Restrictions.like("datosfideicomisosubfisoId", "%" + query +"%")),
			Restrictions.like("datosfideicomisotiponegocio", "%" + query +"%")),
			Restrictions.like("datosfideicomisoproducto", "%" + query +"%")),
			Restrictions.like("identificacioninmuebleidinmueble", "%" + query +"%")),
			Restrictions.like("identificacioninmueblefechaalta", "%" + query +"%")),
			Restrictions.like("identificacioninmuebletipoinmueble", "%" + query +"%")),
			Restrictions.like("identificacioninmueblearbol", "%" + query +"%")),
			Restrictions.like("identificacioninmueblefecharegistro", "%" + query +"%")),
			Restrictions.like("identificacioninmuebletipofraccion", "%" + query +"%")),
			Restrictions.like("identificacioninmuebledescripcion", "%" + query +"%")),
			Restrictions.like("generalesinmueblevalorinicial", "%" + query +"%")),
			Restrictions.like("generalesinmuebleubicacion", "%" + query +"%")),
			Restrictions.like("generalesinmuebleestado", "%" + query +"%")),
			Restrictions.like("generalesinmueblesuperficie", "%" + query +"%")),
			Restrictions.like("generalesinmuebleindivisos", "%" + query +"%")),
			Restrictions.like("generalesinmuebledias", "%" + query +"%")),
			Restrictions.like("generalesinmuebleproyectoejecutivo", "%" + query +"%")),
			Restrictions.like("generalesinmueblevaloractual", "%" + query +"%")),
			Restrictions.like("generalesinmuebleciudad", "%" + query +"%")),
			Restrictions.like("generalesinmueblesuperficieconstruida", "%" + query +"%")),
			Restrictions.like("generalesinmueblefraccionamientounidad", "%" + query +"%")),
			Restrictions.like("generalesinmuebleclavecatastral", "%" + query +"%")),
			Restrictions.like("generalesinmueblevalor", "%" + query +"%")),
			Restrictions.like("generalesinmuebleestatus", "%" + query +"%")),
			Restrictions.like("datosconstitucionescritura", "%" + query +"%")),
			Restrictions.like("datosconstitucionnumescritura", "%" + query +"%")),
			Restrictions.like("datosconstitucionnombrenotario", "%" + query +"%")),
			Restrictions.like("datosconstitucionestadonotario", "%" + query +"%")),
			Restrictions.like("datosconstituciontelefononotario", "%" + query +"%")),
			Restrictions.like("datosconstitucionfecharpp", "%" + query +"%")),
			Restrictions.like("datosconstitucionfechaescritura", "%" + query +"%")),
			Restrictions.like("datosconstitucionnumnotaria", "%" + query +"%")),
			Restrictions.like("datosconstitucionciudadnotario", "%" + query +"%")),
			Restrictions.like("datosconstitucionemailnotario", "%" + query +"%")),
			Restrictions.like("datosconstitucionnumrpp", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de aportacioninmueble y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Aportacioninmueble> listAportacioninmueblesPagination(Aportacioninmueble aportacioninmueble, int page, int size) {
			return (List<Aportacioninmueble>) sessionFactory.getCurrentSession()
				.createCriteria(Aportacioninmueble.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de aportacioninmueble consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Aportacioninmueble.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de aportacioninmueble consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Aportacioninmueble.class).setProjection(Projections.rowCount())
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
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.like("aportacioninmueble", "%" + query +"%"), 
			Restrictions.like("dummy", "%" + query +"%")),
			Restrictions.like("datosfideicomisofideicomisoId", "%" + query +"%")),
			Restrictions.like("datosfideicomisosubfisoId", "%" + query +"%")),
			Restrictions.like("datosfideicomisotiponegocio", "%" + query +"%")),
			Restrictions.like("datosfideicomisoproducto", "%" + query +"%")),
			Restrictions.like("identificacioninmuebleidinmueble", "%" + query +"%")),
			Restrictions.like("identificacioninmueblefechaalta", "%" + query +"%")),
			Restrictions.like("identificacioninmuebletipoinmueble", "%" + query +"%")),
			Restrictions.like("identificacioninmueblearbol", "%" + query +"%")),
			Restrictions.like("identificacioninmueblefecharegistro", "%" + query +"%")),
			Restrictions.like("identificacioninmuebletipofraccion", "%" + query +"%")),
			Restrictions.like("identificacioninmuebledescripcion", "%" + query +"%")),
			Restrictions.like("generalesinmueblevalorinicial", "%" + query +"%")),
			Restrictions.like("generalesinmuebleubicacion", "%" + query +"%")),
			Restrictions.like("generalesinmuebleestado", "%" + query +"%")),
			Restrictions.like("generalesinmueblesuperficie", "%" + query +"%")),
			Restrictions.like("generalesinmuebleindivisos", "%" + query +"%")),
			Restrictions.like("generalesinmuebledias", "%" + query +"%")),
			Restrictions.like("generalesinmuebleproyectoejecutivo", "%" + query +"%")),
			Restrictions.like("generalesinmueblevaloractual", "%" + query +"%")),
			Restrictions.like("generalesinmuebleciudad", "%" + query +"%")),
			Restrictions.like("generalesinmueblesuperficieconstruida", "%" + query +"%")),
			Restrictions.like("generalesinmueblefraccionamientounidad", "%" + query +"%")),
			Restrictions.like("generalesinmuebleclavecatastral", "%" + query +"%")),
			Restrictions.like("generalesinmueblevalor", "%" + query +"%")),
			Restrictions.like("generalesinmuebleestatus", "%" + query +"%")),
			Restrictions.like("datosconstitucionescritura", "%" + query +"%")),
			Restrictions.like("datosconstitucionnumescritura", "%" + query +"%")),
			Restrictions.like("datosconstitucionnombrenotario", "%" + query +"%")),
			Restrictions.like("datosconstitucionestadonotario", "%" + query +"%")),
			Restrictions.like("datosconstituciontelefononotario", "%" + query +"%")),
			Restrictions.like("datosconstitucionfecharpp", "%" + query +"%")),
			Restrictions.like("datosconstitucionfechaescritura", "%" + query +"%")),
			Restrictions.like("datosconstitucionnumnotaria", "%" + query +"%")),
			Restrictions.like("datosconstitucionciudadnotario", "%" + query +"%")),
			Restrictions.like("datosconstitucionemailnotario", "%" + query +"%")),
			Restrictions.like("datosconstitucionnumrpp", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de aportacioninmueble consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Aportacioninmueble.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un aportacioninmueble.
	 */
	public Aportacioninmueble getAportacioninmueble(UUID empid) {
		return (Aportacioninmueble) sessionFactory.getCurrentSession().get(
				Aportacioninmueble.class, empid);
	}

	/**
	 * Elimina un aportacioninmueble.
	 */
	public void deleteAportacioninmueble(Aportacioninmueble aportacioninmueble) {
		sessionFactory.getCurrentSession().delete(aportacioninmueble);
	}

}

