
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Module;

public interface ModuleRepository {

	
	 public void addModule(Module module);   
	 
	 public void editModule(Module module);
	   
	 public List<Module> listModules(Module module);   
	    
	 public Module getModule(int empid);   
	    
	 public void deleteModule(Module module); 

	 public List<Module> listModulesQuery(Module module, String query, int page, int size);

	 public List<Module> listModulesPagination(Module module, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

}

