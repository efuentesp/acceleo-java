/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los certificacions. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.CertificacionRepository;
import com.softtek.acceleo.demo.domain.Certificacion;
import com.softtek.acceleo.demo.service.CertificacionService;
/**
 * Clase CertificacionServiceImpl.
 * @author PSG.
 *
 */
@Service("certificacionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CertificacionServiceImpl implements CertificacionService {

	@Autowired
	private CertificacionRepository certificacionRepository;

	/**
	 * Agrega un certificacion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCertificacion(Certificacion certificacion) {
		certificacionRepository.addCertificacion(certificacion);
	}

	/**
	 * Edita un certificacion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editCertificacion(Certificacion certificacion) {
		certificacionRepository.editCertificacion(certificacion);
	}
	
	/**
	 * Consulta informacion de certificacions.
	 */
	public List<Certificacion> listCertificacions(Certificacion certificacion) {
		return certificacionRepository.listCertificacions(certificacion);
	}

	/**
	 * Obtiene informacion de un certificacion.
	 */
	public Certificacion getCertificacion(int empid) {
		return certificacionRepository.getCertificacion(empid);
	}

	/**
	 * Elimina un certificacion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteCertificacion(Certificacion certificacion) {
		 certificacionRepository.deleteCertificacion(certificacion);
	}

	/**
	 * Consulta informacion de certificacions y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Certificacion> listCertificacionsPagination(Certificacion certificacion, int page, int size) {
		return certificacionRepository.listCertificacionsPagination(certificacion, page, size);
	}

	/**
	 * Obtiene el numero de certificacions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return certificacionRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de certificacions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return certificacionRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de certificacions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return certificacionRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los certificacions y la pagina.
	 */
	public List<Certificacion> listCertificacionsQuery(Certificacion certificacion, String query, int page, int size) {
		// TODO Auto-generated method stub
		return certificacionRepository.listCertificacionsQuery(certificacion, query, page, size);
	}
}	
