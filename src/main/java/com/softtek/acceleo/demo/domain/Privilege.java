package com.softtek.acceleo.demo.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.WhereJoinTable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "privilege")
public class Privilege {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PRIVILEGE")
    private Long idPrivilege;

    @Column(name = "NAME", length = 50, unique = true)
    @NotNull
    @Size(min = 4, max = 50)
    private String name;

    @Column(name = "ENABLED", length = 100)
    @NotNull
    @Size(min = 4, max = 100)
    private Boolean enabled;

    @Column(name = "CREATIONDATE", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private Date creationdate;

    @Column(name = "MODIFIEDDATE", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private Date modifieddate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_GRUPO")
    private Grupo grupo;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "privileges")
//    @ManyToMany(mappedBy = "privilege")
    private List<Authority> authority;
    
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "authority_privilege", joinColumns = { 
			@JoinColumn(name = "ID_PRIVILEGE", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "ID_AUTHORITY", nullable = false, updatable = false) })
	@WhereJoinTable(clause = "ENABLED = '1'") 
	//@JsonIgnore
	private List<Authority> authorities;
    
   
	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public Long getIdPrivilege() {
		return idPrivilege;
	}

	public void setIdPrivilege(Long idPrivilege) {
		this.idPrivilege = idPrivilege;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Date getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

    public List<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}
}
