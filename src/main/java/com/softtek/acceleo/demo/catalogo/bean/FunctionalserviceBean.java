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

	private Double size;
	private String name;
	private String code;
	private Integer repetitions;
	private String comments;
	private Integer menuId;
	private String description;
	private Complexity complexityId;
	private enum Complexity { mc,ms,s,m,c}
	private Repository repositoryId;
	private enum Repository { e5_7,e11_25,e2_4,e8_10}
	private Data dataId;
	private enum Data { d10_25,d0_10,d26_40,d41_100}
	private Algorithmtype algorithmtypeId;
	private enum Algorithmtype { a1,a2}
	private Reusability reusabilityId;
	private enum Reusability { r2,r1}

	public Integer getFunctionalserviceId() {
		return functionalserviceId;
	}
	public void setFunctionalserviceId(Integer functionalserviceId) {
		this.functionalserviceId = functionalserviceId;
	}
	
	public Double getSize () {
	    return size;  		
    }
	public void setSize(Double size) {
		this.size = size;
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
	
	public Integer getRepetitions () {
	    return repetitions;  		
    }
	public void setRepetitions(Integer repetitions) {
		this.repetitions = repetitions;
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
	public String getDescription () {
	    return description;  		
    }
	public void setDescription (String description) {
		this.description = description;
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
