package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Fideicomiso;

public class FideicomisospendientesliberarBean {

/**
 * Clase FideicomisospendientesliberarBean.
 * @author PSG.
 *
 */
 
private UUID fideicomisospendientesliberarId; 
private UUID fideicomisoId;
private String nombrefiso;
private String tiponegocio;
private String clasifproducto;
private String manejo;
private String tipopersona;
private String estatus;

public UUID getFideicomisosPendientesLiberarId() {
    return fideicomisospendientesliberarId;  		
   }
public void setFideicomisosPendientesLiberarId(UUID fideicomisospendientesliberarId) {
	this.fideicomisospendientesliberarId = fideicomisospendientesliberarId;
}

public UUID getFideicomisoId() {
    return fideicomisoId;
}
public void setFideicomiso(UUID fideicomisoId) {
	this.fideicomisoId = fideicomisoId;
}
public String getNombrefiso() {
    return nombrefiso;
}
public void setNombrefiso(String nombrefiso) {
	this.nombrefiso = nombrefiso;
}
public String getTiponegocio() {
    return tiponegocio;
}
public void setTiponegocio(String tiponegocio) {
	this.tiponegocio = tiponegocio;
}
public String getClasifproducto() {
    return clasifproducto;
}
public void setClasifproducto(String clasifproducto) {
	this.clasifproducto = clasifproducto;
}
public String getManejo() {
    return manejo;
}
public void setManejo(String manejo) {
	this.manejo = manejo;
}
public String getTipopersona() {
    return tipopersona;
}
public void setTipopersona(String tipopersona) {
	this.tipopersona = tipopersona;
}
public String getEstatus() {
    return estatus;
}
public void setEstatus(String estatus) {
	this.estatus = estatus;
}
}
