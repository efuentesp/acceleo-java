package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.WhereJoinTable;

@Entity
@Table(name = "profesor")
public class Profesor implements Serializable {

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
	@Column(name = "profesorId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  profesorId;		

	@NotNull
	@NotNull
	@Column(name = "noempleado")
	private Integer noempleado;
	
	@NotNull
	@Column(name = "nombreprofesor")
	@Size(min = 30, max = 50)
	private String nombreprofesor;
	
	@NotNull
	@Column(name = "apellidopaterno")
	@Size(min = 30, max = 50)
	private String apellidopaterno;
	
	@NotNull
	@Column(name = "rfc")
	@Size(min = 9, max = 9)
	private String rfc;
	
	@Column(name = "correopro")
	private String correopro;
	
	@Column(name = "telefono")
	private String telefono;
	

	public UUID getProfesorId() {
		return profesorId;
	}

	public void setProfesorId(UUID profesorId) {
		this.profesorId = profesorId;
	}
	
	public Integer getNoempleado () {
	    return noempleado;
	    }
	public void setNoempleado(Integer noempleado) {
		this.noempleado = noempleado;
	}	
	public String getNombreprofesor () {
	    return nombreprofesor;
	    }
	public void setNombreprofesor(String nombreprofesor) {
		this.nombreprofesor = nombreprofesor;
	}
	public String getApellidopaterno () {
	    return apellidopaterno;
	    }
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	public String getRfc () {
	    return rfc;
	    }
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getCorreopro () {
	    return correopro;
	    }
	public void setCorreopro(String correopro) {
		this.correopro = correopro;
	}
	public String getTelefono () {
	    return telefono;
	    }
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}		
