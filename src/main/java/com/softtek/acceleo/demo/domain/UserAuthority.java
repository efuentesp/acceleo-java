package com.softtek.acceleo.demo.domain;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;//----------------------------

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

//import org.jetbrains.annotations.NotNull;
//import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "user_authority")
public class UserAuthority {
//    @Id
//    @Column(name = "ID_USER_AUTH")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long idUserAuthority;
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
	@Column(name = "id_user_auth", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID idUserAuthority;
		
    @Column(name = "enabled")
    private Boolean enabled;
    
	//@OneToOne(cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_user")
	private User idUser;
    
    //@OneToOne(cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_authority")
    //@Where(clause = "ENABLED = '1'")
	private Authority idAuthority;
	
	public User getIdUser() {
		return idUser;
	}
	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}
	public Authority getIdAuthority() {
		return idAuthority;
	}
	public void setIdAuthority(Authority idAuthority) {
		this.idAuthority = idAuthority;
	}
	
    public UUID getIdUserAuthority() {
		return idUserAuthority;
	}
	public void setIdUserAuthority(UUID idUserAuthority) {
		this.idUserAuthority = idUserAuthority;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	
	
}
