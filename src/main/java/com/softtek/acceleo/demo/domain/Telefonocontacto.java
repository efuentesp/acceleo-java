package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.WhereJoinTable;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "telefonocontacto")
public class Telefonocontacto implements Serializable {

private static final long serialVersionUID = 1L;

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
@Column(name = "telefonocontactoId", columnDefinition = "VARBINARY(50)")
@Type(type="uuid-char")
private UUID telefonocontactoId;

@Column(name = "nombre")
@JsonProperty("nombre")
private String nombre;
@Column(name = "lada")
@JsonProperty("lada")
private String lada;
@Column(name = "telefono")
@JsonProperty("telefono")
private String telefono;
@Column(name = "extension")
@JsonProperty("extension")
private String extension;

public UUID getTelefonocontactoId() {
	return telefonocontactoId;
}
	
public void setTelefonocontactoId(UUID telefonocontactoId) {
	this.telefonocontactoId = telefonocontactoId;
}	

public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
this.nombre = nombre;
}
public String getLada() {
    return lada;
}
public void setLada(String lada) {
this.lada = lada;
}
public String getTelefono() {
    return telefono;
}
public void setTelefono(String telefono) {
this.telefono = telefono;
}
public String getExtension() {
    return extension;
}
public void setExtension(String extension) {
this.extension = extension;
}

}		
