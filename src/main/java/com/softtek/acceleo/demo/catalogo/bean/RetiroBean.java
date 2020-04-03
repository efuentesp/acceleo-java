package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;


public class RetiroBean {

/**
 * Clase RetiroBean.
 * @author PSG.
 *
 */
 
private UUID retiroId; 
private String usuario;
private String fechahora;
private String archivo;

public UUID getRetiroId() {
    return retiroId;  		
   }
public void setRetiroId(UUID retiroId) {
	this.retiroId = retiroId;
}

public String getUsuario() {
    return usuario;
}
public void setUsuario(String usuario) {
	this.usuario = usuario;
}
public String getFechahora() {
    return fechahora;
}
public void setFechahora(String fechahora) {
	this.fechahora = fechahora;
}
public String getArchivo() {
    return archivo;
}
public void setArchivo(String archivo) {
	this.archivo = archivo;
}
}
