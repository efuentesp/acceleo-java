package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;


public class AccionistaBean {

/**
 * Clase AccionistaBean.
 * @author PSG.
 *
 */
 
private UUID accionistaId; 
private String accionistade;
private String nombre;
private String rfc;
private String porcentajeparticipacionaccionaria;
private String tipopersona;
private String nacionalidad;
private String pep;

public UUID getAccionistaId() {
    return accionistaId;  		
   }
public void setAccionistaId(UUID accionistaId) {
	this.accionistaId = accionistaId;
}

public String getAccionistade() {
    return accionistade;
}
public void setAccionistade(String accionistade) {
	this.accionistade = accionistade;
}	
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getRfc() {
    return rfc;
}
public void setRfc(String rfc) {
	this.rfc = rfc;
}
public String getPorcentajeparticipacionaccionaria() {
    return porcentajeparticipacionaccionaria;
}
public void setPorcentajeparticipacionaccionaria(String porcentajeparticipacionaccionaria) {
	this.porcentajeparticipacionaccionaria = porcentajeparticipacionaccionaria;
}
public String getTipopersona() {
    return tipopersona;
}
public void setTipopersona(String tipopersona) {
	this.tipopersona = tipopersona;
}
public String getNacionalidad() {
    return nacionalidad;
}
public void setNacionalidad(String nacionalidad) {
	this.nacionalidad = nacionalidad;
}
public String getPep() {
    return pep;
}
public void setPep(String pep) {
	this.pep = pep;
}
}
