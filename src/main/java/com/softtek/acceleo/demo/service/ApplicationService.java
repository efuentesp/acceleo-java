package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Application;
import java.util.List;

public interface ApplicationService {

	public void addApplication(Application application);

	public void editApplication(Application application);
	
	public List<Application> listApplications(Application application);

	public Application getApplication(int empid);

	public void deleteApplication(Application application);
	
	public List<Application> listApplicationsQuery(Application application, String query, int page, int size);

	public List<Application> listApplicationsPagination(Application application, int page, int size);
	
	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);

}

