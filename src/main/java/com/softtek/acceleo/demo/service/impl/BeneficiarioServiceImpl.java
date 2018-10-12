
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los beneficiarios. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.BeneficiarioRepository;
import com.softtek.acceleo.demo.domain.Beneficiario;
import com.softtek.acceleo.demo.service.BeneficiarioService;
/**
 * Clase BeneficiarioServiceImpl.
 * @author PSG.
 *
 */
@Service("beneficiarioService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BeneficiarioServiceImpl implements BeneficiarioService {

	@Autowired
	private BeneficiarioRepository beneficiarioRepository;

	/**
	 * Agrega un beneficiario.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addBeneficiario(Beneficiario beneficiario) {
		
		beneficiarioRepository.addBeneficiario(beneficiario);
	}

	/**
	 * Edita un beneficiario.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editBeneficiario(Beneficiario beneficiario) {
		
		beneficiarioRepository.editBeneficiario(beneficiario);
	}
	
	/**
	 * Consulta informacion de beneficiarios.
	 */
	public List<Beneficiario> listBeneficiarios(Beneficiario beneficiario) {

		return beneficiarioRepository.listBeneficiarios(beneficiario);
	}

	/**
	 * Obtiene informacion de un beneficiario.
	 */
	public Beneficiario getBeneficiario(int empid) {

		return beneficiarioRepository.getBeneficiario(empid);
	}

	/**
	 * Elimina un beneficiario.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteBeneficiario(Beneficiario beneficiario) {
		System.out.println("Entrando al deleteBeneficiario");

		 beneficiarioRepository.deleteBeneficiario(beneficiario);
	}

	/**
	 * Consulta informacion de beneficiarios y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Beneficiario> listBeneficiariosPagination(Beneficiario beneficiario, int page, int size) {

		return beneficiarioRepository.listBeneficiariosPagination(beneficiario, page, size);
	}

	/**
	 * Obtiene el numero de beneficiarios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return beneficiarioRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de beneficiarios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return beneficiarioRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de beneficiarios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return beneficiarioRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los beneficiarios y la pagina.
	 */
	public List<Beneficiario> listBeneficiariosQuery(Beneficiario beneficiario, String query, int page, int size) {
		// TODO Auto-generated method stub
		return beneficiarioRepository.listBeneficiariosQuery(beneficiario, query, page, size);
	}

}

