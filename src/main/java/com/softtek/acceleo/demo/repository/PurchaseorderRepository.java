package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Purchaseorder;

public interface PurchaseorderRepository {
	
  public void addPurchaseorder(Purchaseorder purchaseorder);
  
  public void editPurchaseorder(Purchaseorder purchaseorder);
 
  public List<Purchaseorder> listPurchaseorders(Purchaseorder purchaseorder);   
    
  public Purchaseorder getPurchaseorder(int empid);   
    
  public void deletePurchaseorder(Purchaseorder purchaseorder); 

  public List<Purchaseorder> listPurchaseordersQuery(Purchaseorder purchaseorder, String query, int page, int size);

  public List<Purchaseorder> listPurchaseordersPagination(Purchaseorder purchaseorder, int page, int size);
  
      public long getTotalRows();
  
      public long getTotalRows(String query);
  
      public long getTotalRowsSearch(String query);	

}  
