package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Perfil;
import java.util.List;

public interface PerfilService {

	public void addPerfil(Perfil perfil);

	public void editPerfil(Perfil perfil);
	
	public List<Perfil> listPerfils(Perfil perfil);

	public Perfil getPerfil(int empid);

	public void deletePerfil(Perfil perfil);
	
	public List<Perfil> listPerfilsQuery(Perfil perfil, String query, int page, int size);

	public List<Perfil> listPerfilsPagination(Perfil perfil, int page, int size);
	
	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);

}

