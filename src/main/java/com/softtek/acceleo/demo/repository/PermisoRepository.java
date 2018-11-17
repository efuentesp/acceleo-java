package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Permiso;

public interface PermisoRepository {
	
  public void addPermiso(Permiso permiso);
  
  public void editPermiso(Permiso permiso);
 
  public List<Permiso> listPermisos(Permiso permiso);   
    
  public Permiso getPermiso(UUID empid);   
    
  public void deletePermiso(Permiso permiso); 

  public List<Permiso> listPermisosQuery(Permiso permiso, String query, int page, int size);

  public List<Permiso> listPermisosPagination(Permiso permiso, int page, int size);
  
      public long getTotalRows();
  
      public long getTotalRows(String query);
  
      public long getTotalRowsSearch(String query);	

}  
