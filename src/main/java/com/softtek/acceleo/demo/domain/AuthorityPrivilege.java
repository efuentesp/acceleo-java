package com.softtek.acceleo.demo.domain;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "authority_privilege")
public class AuthorityPrivilege {
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
	@Column(name = "id_aut_priv", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID idAutorityPrivilege;	
    
    @Column(name = "enabled")    
    private Boolean enabled;
    
//	@Column(name = "ID_PRIVILEGE")
//  @NotNull
	//@OneToOne(cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_privilege")
    private Privilege idPrivilege;
    
//  @Column(name = "ID_AUTHORITY")
//  @NotNull
	//@OneToOne(cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_authority")
    private Authority idAuthority;
	    
	public UUID getIdAutorityPrivilege() {
		return idAutorityPrivilege;
	}

	public void setIdAutorityPrivilege(UUID idAutorityPrivilege) {
		this.idAutorityPrivilege = idAutorityPrivilege;
	}

    public Privilege getIdPrivilege() {
		return idPrivilege;
	}

	public void setIdPrivilege(Privilege idPrivilege) {
		this.idPrivilege = idPrivilege;
	}
    
	public Authority getIdAuthority() {
		return idAuthority;
	}

	public void setIdAuthority(Authority idAuthority) {
		this.idAuthority = idAuthority;
	}

    public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
}
