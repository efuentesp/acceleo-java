
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los applications. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.ApplicationRepository;
import com.softtek.acceleo.demo.domain.Application;
import com.softtek.acceleo.demo.service.ApplicationService;
/**
 * Clase ApplicationServiceImpl.
 * @author PSG.
 *
 */
@Service("applicationService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationRepository applicationRepository;

	/**
	 * Agrega un application.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addApplication(Application application) {
		
		applicationRepository.addApplication(application);
	}

	/**
	 * Edita un application.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editApplication(Application application) {
		
		applicationRepository.editApplication(application);
	}
	
	/**
	 * Consulta informacion de applications.
	 */
	public List<Application> listApplications(Application application) {

		return applicationRepository.listApplications(application);
	}

	/**
	 * Obtiene informacion de un application.
	 */
	public Application getApplication(int empid) {

		return applicationRepository.getApplication(empid);
	}

	/**
	 * Elimina un application.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteApplication(Application application) {
		System.out.println("Entrando al deleteApplication");

		 applicationRepository.deleteApplication(application);
	}

	/**
	 * Consulta informacion de applications y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Application> listApplicationsPagination(Application application, int page, int size) {

		return applicationRepository.listApplicationsPagination(application, page, size);
	}

	/**
	 * Obtiene el numero de applications consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return applicationRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de applications consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return applicationRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de applications consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return applicationRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los applications y la pagina.
	 */
	public List<Application> listApplicationsQuery(Application application, String query, int page, int size) {
		// TODO Auto-generated method stub
		return applicationRepository.listApplicationsQuery(application, query, page, size);
	}

}

