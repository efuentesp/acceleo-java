/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los beneficiario. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Beneficiario;
import com.softtek.acceleo.demo.repository.BeneficiarioRepository;
/**
 * Clase beneficiarioRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("beneficiarioRepository")
public class BeneficiarioRepositoryImpl implements BeneficiarioRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un beneficiario.
	 */
	public void addBeneficiario(Beneficiario beneficiario) {
		sessionFactory.getCurrentSession().persist(beneficiario);
	}
	/**
	 * Edita un beneficiario.
	 */
	public void editBeneficiario(Beneficiario beneficiario) {
		sessionFactory.getCurrentSession().update(beneficiario);

	}
	/**
	 * Consulta informacion de beneficiario.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Beneficiario> listBeneficiarios(Beneficiario beneficiario) {

		return (List<Beneficiario>) sessionFactory.getCurrentSession()
				.createCriteria(Beneficiario.class).list();
	}

	/**
	 * Consulta informacion de beneficiario y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Beneficiario> listBeneficiariosQuery(Beneficiario beneficiario, String query, int page, int size) {
		
		return (List<Beneficiario>) sessionFactory.getCurrentSession()
			.createCriteria(Beneficiario.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("apellido_paterno", "%" + query +"%"),
Restrictions.like("apellido_materno", "%" + query +"%")),
Restrictions.like("beneficiario", "%" + query +"%")),
Restrictions.like("curp", "%" + query +"%")),
Restrictions.like("beneficiario", "%" + query +"%")),
Restrictions.like("beneficiario", "%" + query +"%")),
Restrictions.like("beneficiario", "%" + query +"%")),
Restrictions.like("parentesco", "%" + query +"%")),
Restrictions.like("fecha_nacimiento", "%" + query +"%")),
Restrictions.like("nombre", "%" + query +"%")),
Restrictions.like("afiliado", "%" + query +"%"))
					
					
					
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de beneficiario y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Beneficiario> listBeneficiariosPagination(Beneficiario beneficiario, int page, int size) {
			return (List<Beneficiario>) sessionFactory.getCurrentSession()
				.createCriteria(Beneficiario.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de beneficiario consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Beneficiario.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de beneficiario consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Beneficiario.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("apellido_paterno", "%" + query +"%"),Restrictions.like("apellido_materno", "%" + query +"%")),Restrictions.like("beneficiario", "%" + query +"%")),Restrictions.like("curp", "%" + query +"%")),Restrictions.like("beneficiario", "%" + query +"%")),Restrictions.like("beneficiario", "%" + query +"%")),Restrictions.like("beneficiario", "%" + query +"%")),Restrictions.like("parentesco", "%" + query +"%")),Restrictions.like("fecha_nacimiento", "%" + query +"%")),Restrictions.like("nombre", "%" + query +"%")),Restrictions.like("afiliado", "%" + query +"%"))	
	
	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de beneficiario consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Beneficiario.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un beneficiario.
	 */
	public Beneficiario getBeneficiario(int empid) {
		return (Beneficiario) sessionFactory.getCurrentSession().get(
				Beneficiario.class, empid);
	}

	/**
	 * Elimina un beneficiario.
	 */
	public void deleteBeneficiario(Beneficiario beneficiario) {
		sessionFactory.getCurrentSession().delete(beneficiario);
	}

}
