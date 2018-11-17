package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Usuario;

public interface UsuarioRepository {
	
  public void addUsuario(Usuario usuario);
  
  public void editUsuario(Usuario usuario);
 
  public List<Usuario> listUsuarios(Usuario usuario);   
    
  public Usuario getUsuario(UUID empid);   
    
  public void deleteUsuario(Usuario usuario); 

  public List<Usuario> listUsuariosQuery(Usuario usuario, String query, int page, int size);

  public List<Usuario> listUsuariosPagination(Usuario usuario, int page, int size);
  
      public long getTotalRows();
  
      public long getTotalRows(String query);
  
      public long getTotalRowsSearch(String query);	

}  
