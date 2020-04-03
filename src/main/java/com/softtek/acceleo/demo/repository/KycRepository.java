package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Kyc;

public interface KycRepository {
	
  public void addKyc(Kyc kyc);
  
  public void editKyc(Kyc kyc);
 
  public List<Kyc> listKycs(Kyc kyc);   
    
  public Kyc getKyc(UUID empid);   
    
  public void deleteKyc(Kyc kyc); 

  public List<Kyc> listKycsQuery(Kyc kyc, String query, int page, int size);

  public List<Kyc> listKycsPagination(Kyc kyc, int page, int size);
  
  public long getTotalRows();

  public long getTotalRows(String query);

  public long getTotalRowsSearch(String query);	

}  
