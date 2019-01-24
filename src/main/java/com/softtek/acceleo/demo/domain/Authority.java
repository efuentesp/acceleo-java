package com.softtek.acceleo.demo.domain;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.WhereJoinTable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "authority")
public class Authority {

	@Id
	@NotNull
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			          name = "UUID", 
	                  strategy = "org.hibernate.id.UUIDGenerator", 
	                  parameters = {
	                		@Parameter( 
	                				name = "uuid_gen_strategy_class", 
	                				value = "org.hibernate.id.uuid.CustomVersionOneStrategy" 
	                		) 
					  } 
					 )
	@Column(name = "id_authority", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID idAuthority;	

    @Column(name = "name", length = 50)
    @NotNull
    @OrderBy("name ASC")
    private String name;
    
    @Column(name = "enabled")
    @NotNull
    private Boolean enabled;
        
    @Column(name = "creationdate", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "modifieddate", nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "authority_privilege", 
			joinColumns = {@JoinColumn(name = "id_authority", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "id_privilege", nullable = false, updatable = false) })
	@WhereJoinTable(clause = "enabled = '1'") 
	@JsonIgnore
	private List<Privilege> privileges;
	

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_authority", joinColumns = { 
			@JoinColumn(name = "id_authority", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "id_user", nullable = false, updatable = false) })
	//@WhereJoinTable(clause = "enabled = '1'")
	@JsonIgnore 
	private List<User> user;

	public UUID getIdAuthority() {
        return idAuthority;
    }

    public void setIdAuthority(UUID idAuthority) {
        this.idAuthority = idAuthority;
    }
    
    public List<Privilege> getPrivileges() {
		return privileges;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrivileges(List<Privilege> privilege) {
		this.privileges = privilege;
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