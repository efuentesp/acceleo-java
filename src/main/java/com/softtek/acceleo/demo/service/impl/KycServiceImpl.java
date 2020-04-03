/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los kycs. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.KycRepository;
import com.softtek.acceleo.demo.domain.Kyc;
import com.softtek.acceleo.demo.service.KycService;
/**
 * Clase KycServiceImpl.
 * @author PSG.
 *
 */
@Service("kycService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class KycServiceImpl implements KycService {

	@Autowired
	private KycRepository kycRepository;

	/**
	 * Agrega un kyc.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addKyc(Kyc kyc) {
		kycRepository.addKyc(kyc);
	}

	/**
	 * Edita un kyc.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editKyc(Kyc kyc) {
		kycRepository.editKyc(kyc);
	}
	
	/**
	 * Consulta informacion de kycs.
	 */
	public List<Kyc> listKycs(Kyc kyc) {
		return kycRepository.listKycs(kyc);
	}

	/**
	 * Obtiene informacion de un kyc.
	 */
	public Kyc getKyc(UUID empid) {
		return kycRepository.getKyc(empid);
	}

	/**
	 * Elimina un kyc.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteKyc(Kyc kyc) {
		 kycRepository.deleteKyc(kyc);
	}

	/**
	 * Consulta informacion de kycs y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Kyc> listKycsPagination(Kyc kyc, int page, int size) {
		return kycRepository.listKycsPagination(kyc, page, size);
	}

	/**
	 * Obtiene el numero de kycs consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return kycRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de kycs consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return kycRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de kycs consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return kycRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los kycs y la pagina.
	 */
	public List<Kyc> listKycsQuery(Kyc kyc, String query, int page, int size) {
		// TODO Auto-generated method stub
		return kycRepository.listKycsQuery(kyc, query, page, size);
	}
}	
