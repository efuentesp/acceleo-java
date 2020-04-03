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
@Table(name = "cuentaskyc")
public class Cuentaskyc implements Serializable {

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
@Column(name = "cuentaskycId", columnDefinition = "VARBINARY(50)")
@Type(type="uuid-char")
private UUID cuentaskycId;

@Column(name = "tipocuenta")
@JsonProperty("tipocuenta")
private String tipocuenta;
@Column(name = "nocuenta")
@JsonProperty("nocuenta")
private Integer nocuenta;

public UUID getCuentaskycId() {
	return cuentaskycId;
}
	
public void setCuentaskycId(UUID cuentaskycId) {
	this.cuentaskycId = cuentaskycId;
}	

public String getTipocuenta() {
    return tipocuenta;
}
public void setTipocuenta(String tipocuenta) {
this.tipocuenta = tipocuenta;
}
public Integer getNocuenta(){
    return nocuenta;
}
public void setNocuenta(Integer nocuenta) {
	this.nocuenta = nocuenta;
}

}		
