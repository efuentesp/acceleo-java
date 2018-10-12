package com.softtek.acceleo.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;
import org.hibernate.annotations.WhereJoinTable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "authority")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_authority")
    private Long idAuthority;

    @Column(name = "name", length = 50)
    @NotNull
    @OrderBy("name ASC")
    private String name;
    
    @Column(name = "enabled")
    @NotNull
    private Boolean enabled;
    
    
    @Column(name = "creationdate")
    @NotNull
    private Date creationDate;

    @Column(name = "modifieddate")
    private Date modifiedDate;
    

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "authority_privilege", joinColumns = { 
			@JoinColumn(name = "id_authority", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "id_privilege", nullable = false, updatable = false) })
	@WhereJoinTable(clause = "enabled = '1'") 
	@JsonIgnore 
	private List<Privilege> privilege;
    
    
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_authority", joinColumns = { 
			@JoinColumn(name = "id_authority", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "id_user", nullable = false, updatable = false) })
	//@WhereJoinTable(clause = "ENABLED = '1'")
	@JsonIgnore 
	private List<User> user;

	public Long getIdAuthority() {
        return idAuthority;
    }

    public void setIdAuthority(Long idAuthority) {
        this.idAuthority = idAuthority;
    }
    
    public List<Privilege> getPrivilege() {
		return privilege;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrivilege(List<Privilege> privilege) {
		this.privilege = privilege;
	}
        
    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
    
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
    
}