/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los afiliado. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Afiliado;
import com.softtek.acceleo.demo.repository.AfiliadoRepository;
/**
 * Clase afiliadoRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("afiliadoRepository")
public class AfiliadoRepositoryImpl implements AfiliadoRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un afiliado.
	 */
	public void addAfiliado(Afiliado afiliado) {
		sessionFactory.getCurrentSession().persist(afiliado);
	}
	/**
	 * Edita un afiliado.
	 */
	public void editAfiliado(Afiliado afiliado) {
		sessionFactory.getCurrentSession().update(afiliado);

	}
	/**
	 * Consulta informacion de afiliado.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Afiliado> listAfiliados(Afiliado afiliado) {

		return (List<Afiliado>) sessionFactory.getCurrentSession()
				.createCriteria(Afiliado.class).list();
	}

	/**
	 * Consulta informacion de afiliado y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Afiliado> listAfiliadosQuery(Afiliado afiliado, String query, int page, int size) {
		
		return (List<Afiliado>) sessionFactory.getCurrentSession()
			.createCriteria(Afiliado.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("afiliado", "%" + query +"%"),
Restrictions.like("nss", "%" + query +"%")),
Restrictions.like("nombre", "%" + query +"%")),
Restrictions.like("acta_nacimiento", "%" + query +"%")),
Restrictions.like("numero", "%" + query +"%")),
Restrictions.like("semanas_cotizadas", "%" + query +"%")),
Restrictions.like("afiliado", "%" + query +"%")),
Restrictions.like("genero", "%" + query +"%")),
Restrictions.like("correo", "%" + query +"%")),
Restrictions.like("afiliado", "%" + query +"%")),
Restrictions.like("beneficiarios", "%" + query +"%")),
Restrictions.like("foto", "%" + query +"%")),
Restrictions.like("afiliado", "%" + query +"%")),
Restrictions.like("apellido_materno", "%" + query +"%")),
Restrictions.like("domicilio", "%" + query +"%")),
Restrictions.like("direccioncorreo", "%" + query +"%")),
Restrictions.like("apellido_paterno", "%" + query +"%")),
Restrictions.like("fecha_afiliacion", "%" + query +"%")),
Restrictions.like("observaciones", "%" + query +"%"))
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de afiliado y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Afiliado> listAfiliadosPagination(Afiliado afiliado, int page, int size) {
			return (List<Afiliado>) sessionFactory.getCurrentSession()
				.createCriteria(Afiliado.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de afiliado consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Afiliado.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de afiliado consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Afiliado.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("afiliado", "%" + query +"%"),Restrictions.like("nss", "%" + query +"%")),Restrictions.like("nombre", "%" + query +"%")),Restrictions.like("acta_nacimiento", "%" + query +"%")),Restrictions.like("numero", "%" + query +"%")),Restrictions.like("semanas_cotizadas", "%" + query +"%")),Restrictions.like("afiliado", "%" + query +"%")),Restrictions.like("genero", "%" + query +"%")),Restrictions.like("correo", "%" + query +"%")),Restrictions.like("afiliado", "%" + query +"%")),Restrictions.like("beneficiarios", "%" + query +"%")),Restrictions.like("foto", "%" + query +"%")),Restrictions.like("afiliado", "%" + query +"%")),Restrictions.like("apellido_materno", "%" + query +"%")),Restrictions.like("domicilio", "%" + query +"%")),Restrictions.like("direccioncorreo", "%" + query +"%")),Restrictions.like("apellido_paterno", "%" + query +"%")),Restrictions.like("fecha_afiliacion", "%" + query +"%")),Restrictions.like("observaciones", "%" + query +"%"))	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de afiliado consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Afiliado.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un afiliado.
	 */
	public Afiliado getAfiliado(int empid) {
		return (Afiliado) sessionFactory.getCurrentSession().get(
				Afiliado.class, empid);
	}

	/**
	 * Elimina un afiliado.
	 */
	public void deleteAfiliado(Afiliado afiliado) {
		sessionFactory.getCurrentSession().delete(afiliado);
	}

}
