
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Departamento;

public interface DepartamentoRepository {

	
	 public void addDepartamento(Departamento departamento);   
	 
	 public void editDepartamento(Departamento departamento);
	   
	 public List<Departamento> listDepartamentos(Departamento departamento);   
	    
	 public Departamento getDepartamento(int empid);   
	    
	 public void deleteDepartamento(Departamento departamento); 

	 public List<Departamento> listDepartamentosQuery(Departamento departamento, String query, int page, int size);

	 public List<Departamento> listDepartamentosPagination(Departamento departamento, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

}

