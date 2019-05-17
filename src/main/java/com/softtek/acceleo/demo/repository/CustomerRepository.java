package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Customer;

public interface CustomerRepository {
	
  public void addCustomer(Customer customer);
  
  public void editCustomer(Customer customer);
 
  public List<Customer> listCustomers(Customer customer);   
    
  public Customer getCustomer(int empid);   
    
  public void deleteCustomer(Customer customer); 

  public List<Customer> listCustomersQuery(Customer customer, String query, int page, int size);

  public List<Customer> listCustomersPagination(Customer customer, int page, int size);
  
      public long getTotalRows();
  
      public long getTotalRows(String query);
  
      public long getTotalRowsSearch(String query);	

}  
