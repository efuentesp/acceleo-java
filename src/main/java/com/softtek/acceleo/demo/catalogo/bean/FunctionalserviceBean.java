/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Functionalservice.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class FunctionalserviceBean {
/**
 * Clase FunctionalserviceBean.
 * @author PSG.
 *
 */
	private Integer functionalserviceId;

	private Integer repetitions;
	private String name;
	private String code;
	private Double size;
	private String description;
	private String comments;
	private Integer menuId;
	private Complexity complexityId;
	private enum Complexity { s,ms,mc,c,m}
	private Repository repositoryId;
	private enum Repository { e5_7,e8_10,e11_25,e2_4}
	private Data dataId;
	private enum Data { d41_100,d10_25,d26_40,d0_10}
	private Algorithmtype algorithmtypeId;
	private enum Algorithmtype { a1,a2}
	private Reusability reusabilityId;
	private enum Reusability { r1,r2}

	public Integer getFunctionalserviceId() {
		return functionalserviceId;
	}
	public void setFunctionalserviceId(Integer functionalserviceId) {
		this.functionalserviceId = functionalserviceId;
	}
	
	public Integer getRepetitions () {
	    return repetitions;  		
    }
	public void setRepetitions(Integer repetitions) {
		this.repetitions = repetitions;
	}
	
	public String getName () {
	    return name;  		
    }
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode () {
	    return code;  		
    }
	public void setCode(String code) {
		this.code = code;
	}
	
	public Double getSize () {
	    return size;  		
    }
	public void setSize(Double size) {
		this.size = size;
	}
	
	public String getDescription () {
	    return description;  		
    }
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getComments () {
	    return comments;  		
    }
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Integer getMenuId () {
	    return menuId;  		
    }
	public void setMenuId (Integer menuId) {
		this.menuId = menuId;
	}
	public Complexity getComplexityId () {
	    return complexityId;  		
    }
	public void setComplexityId (Complexity complexityId) {
		this.complexityId = complexityId;
	}
	public Repository getRepositoryId () {
	    return repositoryId;  		
    }
	public void setRepositoryId (Repository repositoryId) {
		this.repositoryId = repositoryId;
	}
	public Data getDataId () {
	    return dataId;  		
    }
	public void setDataId (Data dataId) {
		this.dataId = dataId;
	}
	public Algorithmtype getAlgorithmtypeId () {
	    return algorithmtypeId;  		
    }
	public void setAlgorithmtypeId (Algorithmtype algorithmtypeId) {
		this.algorithmtypeId = algorithmtypeId;
	}
	public Reusability getReusabilityId () {
	    return reusabilityId;  		
    }
	public void setReusabilityId (Reusability reusabilityId) {
		this.reusabilityId = reusabilityId;
	}

}
