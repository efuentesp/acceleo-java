package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Menu;
import java.util.List;

public interface MenuService {

	public void addMenu(Menu menu);

	public void editMenu(Menu menu);
	
	public List<Menu> listMenus(Menu menu);

	public Menu getMenu(int empid);

	public void deleteMenu(Menu menu);
	
	public List<Menu> listMenusQuery(Menu menu, String query, int page, int size);

	public List<Menu> listMenusPagination(Menu menu, int page, int size);
	
	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);

}

