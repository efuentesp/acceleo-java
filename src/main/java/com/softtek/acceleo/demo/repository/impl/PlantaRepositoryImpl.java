/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los planta. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Planta;
import com.softtek.acceleo.demo.repository.PlantaRepository;
/**
 * Clase plantaRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("plantaRepository")
public class PlantaRepositoryImpl implements PlantaRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un planta.
	 */
	public void addPlanta(Planta planta) {
		sessionFactory.getCurrentSession().persist(planta);
	}
	/**
	 * Edita un planta.
	 */
	public void editPlanta(Planta planta) {
		sessionFactory.getCurrentSession().update(planta);

	}
	/**
	 * Consulta informacion de planta.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Planta> listPlantas(Planta planta) {

		return (List<Planta>) sessionFactory.getCurrentSession()
				.createCriteria(Planta.class).list();
	}

	/**
	 * Consulta informacion de planta y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Planta> listPlantasQuery(Planta planta, String query, int page, int size) {
		
		return (List<Planta>) sessionFactory.getCurrentSession()
			.createCriteria(Planta.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("direccion", "%" + query +"%"),
Restrictions.like("nombreplanta", "%" + query +"%")),
Restrictions.like("pertenece", "%" + query +"%")),
Restrictions.like("planta", "%" + query +"%")),
Restrictions.like("maximo", "%" + query +"%")),
Restrictions.like("planta", "%" + query +"%")),
Restrictions.like("planta", "%" + query +"%")),
Restrictions.like("planta", "%" + query +"%")),
Restrictions.like("diadepago", "%" + query +"%")),
Restrictions.like("minimo", "%" + query +"%")),
Restrictions.like("planta", "%" + query +"%"))
					
					
					
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de planta y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Planta> listPlantasPagination(Planta planta, int page, int size) {
			return (List<Planta>) sessionFactory.getCurrentSession()
				.createCriteria(Planta.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de planta consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Planta.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de planta consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Planta.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("direccion", "%" + query +"%"),Restrictions.like("nombreplanta", "%" + query +"%")),Restrictions.like("pertenece", "%" + query +"%")),Restrictions.like("planta", "%" + query +"%")),Restrictions.like("maximo", "%" + query +"%")),Restrictions.like("planta", "%" + query +"%")),Restrictions.like("planta", "%" + query +"%")),Restrictions.like("planta", "%" + query +"%")),Restrictions.like("diadepago", "%" + query +"%")),Restrictions.like("minimo", "%" + query +"%")),Restrictions.like("planta", "%" + query +"%"))	
	
	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de planta consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Planta.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un planta.
	 */
	public Planta getPlanta(int empid) {
		return (Planta) sessionFactory.getCurrentSession().get(
				Planta.class, empid);
	}

	/**
	 * Elimina un planta.
	 */
	public void deletePlanta(Planta planta) {
		sessionFactory.getCurrentSession().delete(planta);
	}

}
