/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los purchaseorders. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.PurchaseorderRepository;
import com.softtek.acceleo.demo.domain.Purchaseorder;
import com.softtek.acceleo.demo.service.PurchaseorderService;
/**
 * Clase PurchaseorderServiceImpl.
 * @author PSG.
 *
 */
@Service("purchaseorderService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PurchaseorderServiceImpl implements PurchaseorderService {

	@Autowired
	private PurchaseorderRepository purchaseorderRepository;

	/**
	 * Agrega un purchaseorder.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addPurchaseorder(Purchaseorder purchaseorder) {
		purchaseorderRepository.addPurchaseorder(purchaseorder);
	}

	/**
	 * Edita un purchaseorder.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editPurchaseorder(Purchaseorder purchaseorder) {
		purchaseorderRepository.editPurchaseorder(purchaseorder);
	}
	
	/**
	 * Consulta informacion de purchaseorders.
	 */
	public List<Purchaseorder> listPurchaseorders(Purchaseorder purchaseorder) {
		return purchaseorderRepository.listPurchaseorders(purchaseorder);
	}

	/**
	 * Obtiene informacion de un purchaseorder.
	 */
	public Purchaseorder getPurchaseorder(int empid) {
		return purchaseorderRepository.getPurchaseorder(empid);
	}

	/**
	 * Elimina un purchaseorder.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deletePurchaseorder(Purchaseorder purchaseorder) {
		 purchaseorderRepository.deletePurchaseorder(purchaseorder);
	}

	/**
	 * Consulta informacion de purchaseorders y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Purchaseorder> listPurchaseordersPagination(Purchaseorder purchaseorder, int page, int size) {
		return purchaseorderRepository.listPurchaseordersPagination(purchaseorder, page, size);
	}

	/**
	 * Obtiene el numero de purchaseorders consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return purchaseorderRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de purchaseorders consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return purchaseorderRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de purchaseorders consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return purchaseorderRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los purchaseorders y la pagina.
	 */
	public List<Purchaseorder> listPurchaseordersQuery(Purchaseorder purchaseorder, String query, int page, int size) {
		// TODO Auto-generated method stub
		return purchaseorderRepository.listPurchaseordersQuery(purchaseorder, query, page, size);
	}
}	
