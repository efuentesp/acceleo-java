/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los fideicomiso. 
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
import com.softtek.acceleo.demo.domain.Fideicomiso;
import com.softtek.acceleo.demo.repository.FideicomisoRepository;

/**
 * Clase fideicomisoRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("fideicomisoRepository")
public class FideicomisoRepositoryImpl implements FideicomisoRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un fideicomiso.
	 */
	public void addFideicomiso(Fideicomiso fideicomiso) {
		sessionFactory.getCurrentSession().persist(fideicomiso);
	}
	/**
	 * Edita un fideicomiso.
	 */
	public void editFideicomiso(Fideicomiso fideicomiso) {
		sessionFactory.getCurrentSession().update(fideicomiso);
		
	}
	/**
	 * Consulta informacion de fideicomiso.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Fideicomiso> listFideicomisos(Fideicomiso fideicomiso) {
		System.out.println("***********************************************: " + fideicomiso.getFideicomisoId());
		List<Fideicomiso> fideicomisos = sessionFactory.getCurrentSession().createCriteria(Fideicomiso.class).list();
		return fideicomisos;
	}
	
	/**
	 * Consulta informacion de fideicomiso.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Fideicomiso> listFideicomisosByFideicomiso(Fideicomiso fideicomiso, int id) {
		List<Fideicomiso> fideicomisos = 
		sessionFactory.getCurrentSession().createCriteria(Fideicomiso.class)
		.add(Restrictions.like("fideicomisoId",id)).list();
		return fideicomisos;
	}
 
	/**
	 * Consulta informacion de fideicomiso.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Fideicomiso> listFideicomisosByUsername(Fideicomiso fideicomiso, String id) {
		List<Fideicomiso> fideicomisos = sessionFactory.getCurrentSession().createCriteria(Fideicomiso.class).add(Restrictions.like("username",id)).list();
		return fideicomisos;
	}
	
	/**
	 * Consulta informacion de fideicomiso y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Fideicomiso> listFideicomisosQuery(Fideicomiso fideicomiso, String query, int page, int size) {
		
		return (List<Fideicomiso>) sessionFactory.getCurrentSession()
			.createCriteria(Fideicomiso.class).setFirstResult((page - 1) * size)
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
			Restrictions.like("fideicomiso", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("numero", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("numerocliente", "%" + query +"%")),
			Restrictions.like("administrador", "%" + query +"%")),
			Restrictions.like("promotor", "%" + query +"%")),
			Restrictions.like("caracteristicastiponegocio", "%" + query +"%")),
			Restrictions.like("caracteristicasformamanejo", "%" + query +"%")),
			Restrictions.like("caracteristicasproducto", "%" + query +"%")),
			Restrictions.like("caracteristicasvalfatca", "%" + query +"%")),
			Restrictions.like("caracteristicasmontoapertura", "%" + query +"%")),
			Restrictions.like("caracteristicasmanejomanejosubfisos", "%" + query +"%")),
			Restrictions.like("caracteristicasmanejosujetoart151", "%" + query +"%")),
			Restrictions.like("caracteristicasmanejocerrado", "%" + query +"%")),
			Restrictions.like("caracteristicasmanejorevocable", "%" + query +"%")),
			Restrictions.like("caracteristicasmanejoescontratoeje", "%" + query +"%")),
			Restrictions.like("caracteristicasmanejocomitetecnico", "%" + query +"%")),
			Restrictions.like("caracteristicasmanejoofibanxico", "%" + query +"%")),
			Restrictions.like("caracteristicasmanejomanejamonext", "%" + query +"%")),
			Restrictions.like("caracteristicasmanejoivafronterizo", "%" + query +"%")),
			Restrictions.like("caracteristicasfechafechaalta", "%" + query +"%")),
			Restrictions.like("caracteristicasfechafechaconstitucion", "%" + query +"%")),
			Restrictions.like("caracteristicasfechafechavencimiento", "%" + query +"%")),
			Restrictions.like("caracteristicasfechaestado", "%" + query +"%")),
			Restrictions.like("adicionalestipofideicomisotipo", "%" + query +"%")),
			Restrictions.like("adicionalestipofideicomisotipopersona", "%" + query +"%")),
			Restrictions.like("adicionalestipofideicomisoconactividadempresarial", "%" + query +"%")),
			Restrictions.like("adicionalestipofideicomisopermisosre", "%" + query +"%")),
			Restrictions.like("adicionalestipofideicomisofechapermisosre", "%" + query +"%")),
			Restrictions.like("adicionalestipofideicomisoprovsustfiduciaria", "%" + query +"%")),
			Restrictions.like("adicionalestipofideicomisofondosinterfaseafore", "%" + query +"%")),
			Restrictions.like("adicionalestipofideicomisoregnalinvext", "%" + query +"%")),
			Restrictions.like("adicionalestipofideicomisofechainscripcion", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratoformalizacioncontrato", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratonoescritura", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratofechaescritura", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratonombrenotario", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratononotario", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratociudadnotario", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratoadministracion", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratoestadonotario", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratopaisnotario", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratofolioregistropublico", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratofechainscripcionregpublico", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratocontabilidaddelegada", "%" + query +"%")),
			Restrictions.like("datosbaxicoactividadeconomica", "%" + query +"%")),
			Restrictions.like("datosbaxicofiducuario", "%" + query +"%")),
			Restrictions.like("datosbaxicosectorbancario", "%" + query +"%")),
			Restrictions.like("datosbaxicolocalidad", "%" + query +"%")),
			Restrictions.like("datosbaxicocentroresp", "%" + query +"%")),
			Restrictions.like("datosbaxiconocr", "%" + query +"%")),
			Restrictions.like("datosbaxicorfccontrato", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de fideicomiso y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Fideicomiso> listFideicomisosPagination(Fideicomiso fideicomiso, int page, int size) {
			return (List<Fideicomiso>) sessionFactory.getCurrentSession()
				.createCriteria(Fideicomiso.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de fideicomiso consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Fideicomiso.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de fideicomiso consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Fideicomiso.class).setProjection(Projections.rowCount())
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
			Restrictions.like("fideicomiso", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("numero", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("numerocliente", "%" + query +"%")),
			Restrictions.like("administrador", "%" + query +"%")),
			Restrictions.like("promotor", "%" + query +"%")),
			Restrictions.like("caracteristicastiponegocio", "%" + query +"%")),
			Restrictions.like("caracteristicasformamanejo", "%" + query +"%")),
			Restrictions.like("caracteristicasproducto", "%" + query +"%")),
			Restrictions.like("caracteristicasvalfatca", "%" + query +"%")),
			Restrictions.like("caracteristicasmontoapertura", "%" + query +"%")),
			Restrictions.like("caracteristicasmanejomanejosubfisos", "%" + query +"%")),
			Restrictions.like("caracteristicasmanejosujetoart151", "%" + query +"%")),
			Restrictions.like("caracteristicasmanejocerrado", "%" + query +"%")),
			Restrictions.like("caracteristicasmanejorevocable", "%" + query +"%")),
			Restrictions.like("caracteristicasmanejoescontratoeje", "%" + query +"%")),
			Restrictions.like("caracteristicasmanejocomitetecnico", "%" + query +"%")),
			Restrictions.like("caracteristicasmanejoofibanxico", "%" + query +"%")),
			Restrictions.like("caracteristicasmanejomanejamonext", "%" + query +"%")),
			Restrictions.like("caracteristicasmanejoivafronterizo", "%" + query +"%")),
			Restrictions.like("caracteristicasfechafechaalta", "%" + query +"%")),
			Restrictions.like("caracteristicasfechafechaconstitucion", "%" + query +"%")),
			Restrictions.like("caracteristicasfechafechavencimiento", "%" + query +"%")),
			Restrictions.like("caracteristicasfechaestado", "%" + query +"%")),
			Restrictions.like("adicionalestipofideicomisotipo", "%" + query +"%")),
			Restrictions.like("adicionalestipofideicomisotipopersona", "%" + query +"%")),
			Restrictions.like("adicionalestipofideicomisoconactividadempresarial", "%" + query +"%")),
			Restrictions.like("adicionalestipofideicomisopermisosre", "%" + query +"%")),
			Restrictions.like("adicionalestipofideicomisofechapermisosre", "%" + query +"%")),
			Restrictions.like("adicionalestipofideicomisoprovsustfiduciaria", "%" + query +"%")),
			Restrictions.like("adicionalestipofideicomisofondosinterfaseafore", "%" + query +"%")),
			Restrictions.like("adicionalestipofideicomisoregnalinvext", "%" + query +"%")),
			Restrictions.like("adicionalestipofideicomisofechainscripcion", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratoformalizacioncontrato", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratonoescritura", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratofechaescritura", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratonombrenotario", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratononotario", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratociudadnotario", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratoadministracion", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratoestadonotario", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratopaisnotario", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratofolioregistropublico", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratofechainscripcionregpublico", "%" + query +"%")),
			Restrictions.like("adicionalesformalizacioncontratocontabilidaddelegada", "%" + query +"%")),
			Restrictions.like("datosbaxicoactividadeconomica", "%" + query +"%")),
			Restrictions.like("datosbaxicofiducuario", "%" + query +"%")),
			Restrictions.like("datosbaxicosectorbancario", "%" + query +"%")),
			Restrictions.like("datosbaxicolocalidad", "%" + query +"%")),
			Restrictions.like("datosbaxicocentroresp", "%" + query +"%")),
			Restrictions.like("datosbaxiconocr", "%" + query +"%")),
			Restrictions.like("datosbaxicorfccontrato", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de fideicomiso consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Fideicomiso.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un fideicomiso.
	 */
	public Fideicomiso getFideicomiso(UUID empid) {
		return (Fideicomiso) sessionFactory.getCurrentSession().get(
				Fideicomiso.class, empid);
	}

	/**
	 * Elimina un fideicomiso.
	 */
	public void deleteFideicomiso(Fideicomiso fideicomiso) {
		sessionFactory.getCurrentSession().delete(fideicomiso);
	}

}

