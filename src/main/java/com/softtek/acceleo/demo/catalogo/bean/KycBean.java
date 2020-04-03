package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Fideicomiso;

public class KycBean {

/**
 * Clase KycBean.
 * @author PSG.
 *
 */
 
private UUID kycId; 
private UUID fideicomisoId;
private String nombre;
private String numregistro;
private String oficina;
private String conceptoimpresion;
private String crbanca;
private String folio;

public UUID getKycId() {
    return kycId;  		
   }
public void setKycId(UUID kycId) {
	this.kycId = kycId;
}

public UUID getFideicomisoId() {
    return fideicomisoId;
}
public void setFideicomiso(UUID fideicomisoId) {
	this.fideicomisoId = fideicomisoId;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getNumregistro() {
    return numregistro;
}
public void setNumregistro(String numregistro) {
	this.numregistro = numregistro;
}
public String getOficina() {
    return oficina;
}
public void setOficina(String oficina) {
	this.oficina = oficina;
}
public String getConceptoimpresion() {
    return conceptoimpresion;
}
public void setConceptoimpresion(String conceptoimpresion) {
	this.conceptoimpresion = conceptoimpresion;
}
public String getCrbanca() {
    return crbanca;
}
public void setCrbanca(String crbanca) {
	this.crbanca = crbanca;
}
public String getFolio() {
    return folio;
}
public void setFolio(String folio) {
	this.folio = folio;
}
}
