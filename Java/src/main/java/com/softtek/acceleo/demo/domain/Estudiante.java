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
@Table(name = "estudiante")
public class Estudiante implements Serializable {

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
	@Column(name = "estudianteId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  estudianteId;		

	@NotNull
	private UUID concierneporId;
	@NotNull
	@NotNull
	@Column(name = "matricula")
	private String matricula;
	
	@NotNull
	@Column(name = "nombreestudiante")
	@Size(min = 40, max = 50)
	private String nombreestudiante;
	
	@NotNull
	@Column(name = "apellidopaterno")
	@Size(min = 40, max = 50)
	private String apellidopaterno;
	
	@NotNull
	@Column(name = "fechanacimiento")
	private Date fechanacimiento;
	
	@NotNull
	private String genero;
	@NotNull
	private String tiponivel;
	@NotNull
	private String tipoarea;
	@Column(name = "correoest")
	private String correoest;
	
	@Column(name = "telefono")
	@Size(min = 10, max = 20)
	private String telefono;
	

	public UUID getEstudianteId() {
		return estudianteId;
	}

	public void setEstudianteId(UUID estudianteId) {
		this.estudianteId = estudianteId;
	}
	
	public UUID getConcierneporId () {
	    return concierneporId;
	    }
	public void setConciernepor(UUID concierneporId) {
		this.concierneporId = concierneporId;
	}
	public String getMatricula () {
	    return matricula;
	    }
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNombreestudiante () {
	    return nombreestudiante;
	    }
	public void setNombreestudiante(String nombreestudiante) {
		this.nombreestudiante = nombreestudiante;
	}
	public String getApellidopaterno () {
	    return apellidopaterno;
	    }
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	public Date getFechanacimiento () {
	    return fechanacimiento;
	    }
	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	public String getGenero () {
	    return genero;
	    }
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getTiponivel () {
	    return tiponivel;
	    }
	public void setTiponivel(String tiponivel) {
		this.tiponivel = tiponivel;
	}
	public String getTipoarea () {
	    return tipoarea;
	    }
	public void setTipoarea(String tipoarea) {
		this.tipoarea = tipoarea;
	}
	public String getCorreoest () {
	    return correoest;
	    }
	public void setCorreoest(String correoest) {
		this.correoest = correoest;
	}
	public String getTelefono () {
	    return telefono;
	    }
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}		
