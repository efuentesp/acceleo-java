
package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "functionalservice")
public class Functionalservice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "functionalserviceId")
	private Integer  functionalserviceId;


	@NotNull
	@Column(name = "size") 
	private Double size;
	@NotNull
	@Column(name = "name") 
	private String name;
	@NotNull
	@Column(name = "code") 
	private String code;
	@NotNull
	@Column(name = "repetitions") 
	private Integer repetitions;
	@NotNull
	@Column(name = "comments") 
	private String comments;


	@NotNull
	@Column(name = "menuId") 
	private Integer menuId;
	@Column(name = "description") 
	private String description;
	@NotNull
	@Column(name = "complexityId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Complexity complexityId;
	@NotNull
	@Column(name = "repositoryId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Repository repositoryId;
	@NotNull
	@Column(name = "dataId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Data dataId;
	@NotNull
	@Column(name = "algorithmtypeId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Algorithmtype algorithmtypeId;
	@NotNull
	@Column(name = "reusabilityId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Reusability reusabilityId;

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
