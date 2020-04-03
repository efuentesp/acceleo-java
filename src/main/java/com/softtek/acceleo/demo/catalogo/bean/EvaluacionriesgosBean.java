package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Fideicomiso;

public class EvaluacionriesgosBean {

/**
 * Clase EvaluacionriesgosBean.
 * @author PSG.
 *
 */
 
private UUID evaluacionriesgosId; 
private String campo;
private UUID fideicomisoId;
private String cliente;
private String estructura;
private String resultadofinal;

public UUID getEvaluacionRiesgosId() {
    return evaluacionriesgosId;  		
   }
public void setEvaluacionRiesgosId(UUID evaluacionriesgosId) {
	this.evaluacionriesgosId = evaluacionriesgosId;
}

public String getCampo() {
    return campo;
}
public void setCampo(String campo) {
	this.campo = campo;
}
public UUID getFideicomisoId() {
    return fideicomisoId;
}
public void setFideicomiso(UUID fideicomisoId) {
	this.fideicomisoId = fideicomisoId;
}
public String getCliente() {
    return cliente;
}
public void setCliente(String cliente) {
	this.cliente = cliente;
}
public String getEstructura() {
    return estructura;
}
public void setEstructura(String estructura) {
	this.estructura = estructura;
}
public String getResultadofinal() {
    return resultadofinal;
}
public void setResultadofinal(String resultadofinal) {
	this.resultadofinal = resultadofinal;
}
}
