package com.softtek.acceleo.demo.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "grupo")
public class Grupo {

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
	@Column(name = "id_grupo", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID idGrupo;	

    @Column(name = "NAME", length = 30, unique = true)
    @NotNull
    @Size(min = 4, max = 30)
    private String name;

	public UUID getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(UUID idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
