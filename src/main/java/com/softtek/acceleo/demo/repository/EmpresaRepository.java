
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Empresa;

public interface EmpresaRepository {

	
	 public void addEmpresa(Empresa empresa);   
	 
	 public void editEmpresa(Empresa empresa);
	   
	 public List<Empresa> listEmpresas(Empresa empresa);   
	    
	 public Empresa getEmpresa(int empid);   
	    
	 public void deleteEmpresa(Empresa empresa); 

	 public List<Empresa> listEmpresasQuery(Empresa empresa, String query, int page, int size);

	 public List<Empresa> listEmpresasPagination(Empresa empresa, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

}

