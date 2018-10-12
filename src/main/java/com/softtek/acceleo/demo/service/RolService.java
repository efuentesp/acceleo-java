package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Rol;
import java.util.List;

public interface RolService {

	public void addRol(Rol rol);

	public void editRol(Rol rol);
	
	public List<Rol> listRols(Rol rol);

	public Rol getRol(int empid);

	public void deleteRol(Rol rol);
	
	public List<Rol> listRolsQuery(Rol rol, String query, int page, int size);

	public List<Rol> listRolsPagination(Rol rol, int page, int size);
	
	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);

}

