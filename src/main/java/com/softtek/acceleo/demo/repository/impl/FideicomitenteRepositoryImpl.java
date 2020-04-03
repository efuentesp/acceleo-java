/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los fideicomitente. 
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
import com.softtek.acceleo.demo.domain.Fideicomitente;
import com.softtek.acceleo.demo.repository.FideicomitenteRepository;

/**
 * Clase fideicomitenteRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("fideicomitenteRepository")
public class FideicomitenteRepositoryImpl implements FideicomitenteRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un fideicomitente.
	 */
	public void addFideicomitente(Fideicomitente fideicomitente) {
		sessionFactory.getCurrentSession().persist(fideicomitente);
	}
	/**
	 * Edita un fideicomitente.
	 */
	public void editFideicomitente(Fideicomitente fideicomitente) {
		sessionFactory.getCurrentSession().update(fideicomitente);
		
	}
	/**
	 * Consulta informacion de fideicomitente.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Fideicomitente> listFideicomitentes(Fideicomitente fideicomitente) {
		List<Fideicomitente> fideicomitentes = sessionFactory.getCurrentSession().createCriteria(Fideicomitente.class).list();
		return fideicomitentes;
	}
	
	/**
	 * Consulta informacion de fideicomitente.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Fideicomitente> listFideicomitentesByFideicomitente(Fideicomitente fideicomitente, int id) {
		List<Fideicomitente> fideicomitentes = 
		sessionFactory.getCurrentSession().createCriteria(Fideicomitente.class)
		.add(Restrictions.like("fideicomitenteId",id)).list();
		return fideicomitentes;
	}
 
	/**
	 * Consulta informacion de fideicomitente.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Fideicomitente> listFideicomitentesByUsername(Fideicomitente fideicomitente, String id) {
		List<Fideicomitente> fideicomitentes = sessionFactory.getCurrentSession().createCriteria(Fideicomitente.class).add(Restrictions.like("username",id)).list();
		return fideicomitentes;
	}
	
	/**
	 * Consulta informacion de fideicomitente y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Fideicomitente> listFideicomitentesQuery(Fideicomitente fideicomitente, String query, int page, int size) {
		
		return (List<Fideicomitente>) sessionFactory.getCurrentSession()
			.createCriteria(Fideicomitente.class).setFirstResult((page - 1) * size)
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
			Restrictions.like("fideicomitente", "%" + query +"%"), 
			Restrictions.like("numerofideicomitente", "%" + query +"%")),
			Restrictions.like("tipopersona", "%" + query +"%")),
			Restrictions.like("participante", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("regimenfiscal", "%" + query +"%")),
			Restrictions.like("generalescontroladorfideicomiso", "%" + query +"%")),
			Restrictions.like("generalesnacionalidad", "%" + query +"%")),
			Restrictions.like("generalespaisorigen", "%" + query +"%")),
			Restrictions.like("generalesactividad", "%" + query +"%")),
			Restrictions.like("generalesaportarecursos", "%" + query +"%")),
			Restrictions.like("generalespaisresidencia", "%" + query +"%")),
			Restrictions.like("generalesclientescotiabank", "%" + query +"%")),
			Restrictions.like("generalespep", "%" + query +"%")),
			Restrictions.like("generalesestatus", "%" + query +"%")),
			Restrictions.like("generalesgrupofilial", "%" + query +"%")),
			Restrictions.like("generalescalidadmigratoria", "%" + query +"%")),
			Restrictions.like("generaleslugaroperacion", "%" + query +"%")),
			Restrictions.like("generalesoperacuentaterceros", "%" + query +"%")),
			Restrictions.like("generalesnivelparticipante", "%" + query +"%")),
			Restrictions.like("generalesclienterelacionpep", "%" + query +"%")),
			Restrictions.like("generalesgrado", "%" + query +"%")),
			Restrictions.like("informacionpldkychonorarios", "%" + query +"%")),
			Restrictions.like("informacionpldkyccomisiones", "%" + query +"%")),
			Restrictions.like("informacionpldkycotros", "%" + query +"%")),
			Restrictions.like("informacionpldkycsueldos", "%" + query +"%")),
			Restrictions.like("informacionpldkycventa", "%" + query +"%")),
			Restrictions.like("informacionpldkycinversiones", "%" + query +"%")),
			Restrictions.like("informacionpldkycarrendamiento", "%" + query +"%")),
			Restrictions.like("informacionpldkyctipopatrimonio", "%" + query +"%")),
			Restrictions.like("informacionpldkycinstrumento", "%" + query +"%")),
			Restrictions.like("informacionpldkycrazonapertura", "%" + query +"%")),
			Restrictions.like("informacionpldkyccomentarios", "%" + query +"%")),
			Restrictions.like("informacionpldkycnivelriesgo", "%" + query +"%")),
			Restrictions.like("informacionpldkycestatuscalculopld", "%" + query +"%")),
			Restrictions.like("informacionpldkycfechaveriffircosoft", "%" + query +"%")),
			Restrictions.like("identificacionrfc", "%" + query +"%")),
			Restrictions.like("identificacioncurp", "%" + query +"%")),
			Restrictions.like("identificacionnoserieefirma", "%" + query +"%")),
			Restrictions.like("identificacioncorreo", "%" + query +"%")),
			Restrictions.like("identificacionfechaconstitucion", "%" + query +"%")),
			Restrictions.like("identificacionsexo", "%" + query +"%")),
			Restrictions.like("identificacionfechainiciorelneg", "%" + query +"%")),
			Restrictions.like("identificacionnoidentificacion", "%" + query +"%")),
			Restrictions.like("identificacioncomprobaciondomicilio", "%" + query +"%")),
			Restrictions.like("identificacionactividadempresarial", "%" + query +"%")),
			Restrictions.like("identificacionclasificacionfatca", "%" + query +"%")),
			Restrictions.like("identificacionidentoficialvig", "%" + query +"%")),
			Restrictions.like("identificacionvigencia", "%" + query +"%")),
			Restrictions.like("identificacionresideciafiscalpaisresidfisc1", "%" + query +"%")),
			Restrictions.like("identificacionresideciafiscalidentificacionnoidentfisc1", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitentepaiscasa", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitentepaisoficina", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitentepaiscelular", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitenteladacasa", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitenteladaoficina", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitenteladacelular", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitentenumerocasa", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitentenumerooficina", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitentenumerocelular", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitenteextoficina", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitenteextcelular", "%" + query +"%")),
			Restrictions.like("escrituranoescritura", "%" + query +"%")),
			Restrictions.like("escrituranotario", "%" + query +"%")),
			Restrictions.like("escrituranonotaria", "%" + query +"%")),
			Restrictions.like("escrituraciudad", "%" + query +"%")),
			Restrictions.like("escrituraestado", "%" + query +"%")),
			Restrictions.like("escriturafecha", "%" + query +"%")),
			Restrictions.like("escrituratelefono", "%" + query +"%")),
			Restrictions.like("escrituracorreo", "%" + query +"%")),
			Restrictions.like("cuentaskyctipocuenta", "%" + query +"%")),
			Restrictions.like("cuentaskycnocuenta", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de fideicomitente y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Fideicomitente> listFideicomitentesPagination(Fideicomitente fideicomitente, int page, int size) {
			return (List<Fideicomitente>) sessionFactory.getCurrentSession()
				.createCriteria(Fideicomitente.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de fideicomitente consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Fideicomitente.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de fideicomitente consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Fideicomitente.class).setProjection(Projections.rowCount())
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
			Restrictions.like("fideicomitente", "%" + query +"%"), 
			Restrictions.like("numerofideicomitente", "%" + query +"%")),
			Restrictions.like("tipopersona", "%" + query +"%")),
			Restrictions.like("participante", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("regimenfiscal", "%" + query +"%")),
			Restrictions.like("generalescontroladorfideicomiso", "%" + query +"%")),
			Restrictions.like("generalesnacionalidad", "%" + query +"%")),
			Restrictions.like("generalespaisorigen", "%" + query +"%")),
			Restrictions.like("generalesactividad", "%" + query +"%")),
			Restrictions.like("generalesaportarecursos", "%" + query +"%")),
			Restrictions.like("generalespaisresidencia", "%" + query +"%")),
			Restrictions.like("generalesclientescotiabank", "%" + query +"%")),
			Restrictions.like("generalespep", "%" + query +"%")),
			Restrictions.like("generalesestatus", "%" + query +"%")),
			Restrictions.like("generalesgrupofilial", "%" + query +"%")),
			Restrictions.like("generalescalidadmigratoria", "%" + query +"%")),
			Restrictions.like("generaleslugaroperacion", "%" + query +"%")),
			Restrictions.like("generalesoperacuentaterceros", "%" + query +"%")),
			Restrictions.like("generalesnivelparticipante", "%" + query +"%")),
			Restrictions.like("generalesclienterelacionpep", "%" + query +"%")),
			Restrictions.like("generalesgrado", "%" + query +"%")),
			Restrictions.like("informacionpldkychonorarios", "%" + query +"%")),
			Restrictions.like("informacionpldkyccomisiones", "%" + query +"%")),
			Restrictions.like("informacionpldkycotros", "%" + query +"%")),
			Restrictions.like("informacionpldkycsueldos", "%" + query +"%")),
			Restrictions.like("informacionpldkycventa", "%" + query +"%")),
			Restrictions.like("informacionpldkycinversiones", "%" + query +"%")),
			Restrictions.like("informacionpldkycarrendamiento", "%" + query +"%")),
			Restrictions.like("informacionpldkyctipopatrimonio", "%" + query +"%")),
			Restrictions.like("informacionpldkycinstrumento", "%" + query +"%")),
			Restrictions.like("informacionpldkycrazonapertura", "%" + query +"%")),
			Restrictions.like("informacionpldkyccomentarios", "%" + query +"%")),
			Restrictions.like("informacionpldkycnivelriesgo", "%" + query +"%")),
			Restrictions.like("informacionpldkycestatuscalculopld", "%" + query +"%")),
			Restrictions.like("informacionpldkycfechaveriffircosoft", "%" + query +"%")),
			Restrictions.like("identificacionrfc", "%" + query +"%")),
			Restrictions.like("identificacioncurp", "%" + query +"%")),
			Restrictions.like("identificacionnoserieefirma", "%" + query +"%")),
			Restrictions.like("identificacioncorreo", "%" + query +"%")),
			Restrictions.like("identificacionfechaconstitucion", "%" + query +"%")),
			Restrictions.like("identificacionsexo", "%" + query +"%")),
			Restrictions.like("identificacionfechainiciorelneg", "%" + query +"%")),
			Restrictions.like("identificacionnoidentificacion", "%" + query +"%")),
			Restrictions.like("identificacioncomprobaciondomicilio", "%" + query +"%")),
			Restrictions.like("identificacionactividadempresarial", "%" + query +"%")),
			Restrictions.like("identificacionclasificacionfatca", "%" + query +"%")),
			Restrictions.like("identificacionidentoficialvig", "%" + query +"%")),
			Restrictions.like("identificacionvigencia", "%" + query +"%")),
			Restrictions.like("identificacionresideciafiscalpaisresidfisc1", "%" + query +"%")),
			Restrictions.like("identificacionresideciafiscalidentificacionnoidentfisc1", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitentepaiscasa", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitentepaisoficina", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitentepaiscelular", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitenteladacasa", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitenteladaoficina", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitenteladacelular", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitentenumerocasa", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitentenumerooficina", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitentenumerocelular", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitenteextoficina", "%" + query +"%")),
			Restrictions.like("identificaciontelefonosfideicomitenteextcelular", "%" + query +"%")),
			Restrictions.like("escrituranoescritura", "%" + query +"%")),
			Restrictions.like("escrituranotario", "%" + query +"%")),
			Restrictions.like("escrituranonotaria", "%" + query +"%")),
			Restrictions.like("escrituraciudad", "%" + query +"%")),
			Restrictions.like("escrituraestado", "%" + query +"%")),
			Restrictions.like("escriturafecha", "%" + query +"%")),
			Restrictions.like("escrituratelefono", "%" + query +"%")),
			Restrictions.like("escrituracorreo", "%" + query +"%")),
			Restrictions.like("cuentaskyctipocuenta", "%" + query +"%")),
			Restrictions.like("cuentaskycnocuenta", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de fideicomitente consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Fideicomitente.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un fideicomitente.
	 */
	public Fideicomitente getFideicomitente(UUID empid) {
		return (Fideicomitente) sessionFactory.getCurrentSession().get(
				Fideicomitente.class, empid);
	}

	/**
	 * Elimina un fideicomitente.
	 */
	public void deleteFideicomitente(Fideicomitente fideicomitente) {
		sessionFactory.getCurrentSession().delete(fideicomitente);
	}

}

