package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;


public class DeclaracionsatBean {

/**
 * Clase DeclaracionsatBean.
 * @author PSG.
 *
 */
 
private UUID declaracionsatId; 
private Date inicioejerciciofiscal;
private String tipodeclaracion;
private Date finejerciciofiscal;
private Date declaracionanterior_fechadeclaracionanterior;
private String declaracionanterior_foliodeclaracionanterior;
private String declaracionanterior_mensajesproceso;
private String declaracionanterior_archivo;

public UUID getDeclaracionSatId() {
    return declaracionsatId;  		
   }
public void setDeclaracionSatId(UUID declaracionsatId) {
	this.declaracionsatId = declaracionsatId;
}

public Date getInicioejerciciofiscal() {
    return inicioejerciciofiscal;
}
public void setInicioejerciciofiscal(Date inicioejerciciofiscal) {
	this.inicioejerciciofiscal = inicioejerciciofiscal;
}
public String getTipodeclaracion() {
    return tipodeclaracion;
}
public void setTipodeclaracion(String tipodeclaracion) {
	this.tipodeclaracion = tipodeclaracion;
}
public Date getFinejerciciofiscal() {
    return finejerciciofiscal;
}
public void setFinejerciciofiscal(Date finejerciciofiscal) {
	this.finejerciciofiscal = finejerciciofiscal;
}
public Date getDeclaracionanterior_fechadeclaracionanterior() {
    return declaracionanterior_fechadeclaracionanterior;
}
public void setDeclaracionanterior_fechadeclaracionanterior(Date declaracionanterior_fechadeclaracionanterior) {
	this.declaracionanterior_fechadeclaracionanterior = declaracionanterior_fechadeclaracionanterior;
}
public String getDeclaracionanterior_foliodeclaracionanterior() {
    return declaracionanterior_foliodeclaracionanterior;
}
public void setDeclaracionanterior_foliodeclaracionanterior(String declaracionanterior_foliodeclaracionanterior) {
	this.declaracionanterior_foliodeclaracionanterior = declaracionanterior_foliodeclaracionanterior;
}
public String getDeclaracionanterior_mensajesproceso() {
    return declaracionanterior_mensajesproceso;
}
public void setDeclaracionanterior_mensajesproceso(String declaracionanterior_mensajesproceso) {
	this.declaracionanterior_mensajesproceso = declaracionanterior_mensajesproceso;
}	
public String getDeclaracionanterior_archivo() {
    return declaracionanterior_archivo;
}
public void setDeclaracionanterior_archivo(String declaracionanterior_archivo) {
	this.declaracionanterior_archivo = declaracionanterior_archivo;
}
}
