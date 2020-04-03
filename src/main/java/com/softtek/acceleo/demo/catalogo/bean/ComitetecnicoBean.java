package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Fideicomiso;

public class ComitetecnicoBean {

/**
 * Clase ComitetecnicoBean.
 * @author PSG.
 *
 */
 
private UUID comitetecnicoId; 
private String dummy;
private UUID generales_fideicomisoId;
private String generales_nombre;
private String generales_integracion;
private String generales_facultades;
private String generales_comentarios;
private Date generales_fechaconstitucion;
private Integer generales_miembrosquorum;
private String generales_estatus;
private String presidente_propietario_nombre;
private String presidente_propietario_propietario;
private String presidente_propietario_propietarionacionalidad;
private String presidente_propietario_propietariosino;
private String presidente_suplente_nombre;
private String presidente_suplente_propietario;
private String presidente_suplente_propietarionacionalidad;
private String presidente_suplente_propietariosino;
private String secretario_propietario_nombre;
private String secretario_propietario_propietario;
private String secretario_propietario_propietarionacionalidad;
private String secretario_propietario_propietariosino;
private String secretario_suplente_nombre;
private String secretario_suplente_propietario;
private String secretario_suplente_propietarionacionalidad;
private String secretario_suplente_propietariosino;
private String vocal_propietario_nombre;
private String vocal_propietario_propietario;
private String vocal_propietario_propietarionacionalidad;
private String vocal_propietario_propietariosino;
private String vocal_suplente_nombre;
private String vocal_suplente_propietario;
private String vocal_suplente_propietarionacionalidad;
private String vocal_suplente_propietariosino;

public UUID getComiteTecnicoId() {
    return comitetecnicoId;  		
   }
public void setComiteTecnicoId(UUID comitetecnicoId) {
	this.comitetecnicoId = comitetecnicoId;
}

public String getDummy() {
    return dummy;
}
public void setDummy(String dummy) {
	this.dummy = dummy;
}
public UUID getGenerales_fideicomisoId() {
    return generales_fideicomisoId;
}
public void setGenerales_fideicomiso(UUID generales_fideicomisoId) {
	this.generales_fideicomisoId = generales_fideicomisoId;
}
public String getGenerales_nombre() {
    return generales_nombre;
}
public void setGenerales_nombre(String generales_nombre) {
	this.generales_nombre = generales_nombre;
}
public String getGenerales_integracion() {
    return generales_integracion;
}
public void setGenerales_integracion(String generales_integracion) {
	this.generales_integracion = generales_integracion;
}	
public String getGenerales_facultades() {
    return generales_facultades;
}
public void setGenerales_facultades(String generales_facultades) {
	this.generales_facultades = generales_facultades;
}	
public String getGenerales_comentarios() {
    return generales_comentarios;
}
public void setGenerales_comentarios(String generales_comentarios) {
	this.generales_comentarios = generales_comentarios;
}	
public Date getGenerales_fechaconstitucion() {
    return generales_fechaconstitucion;
}
public void setGenerales_fechaconstitucion(Date generales_fechaconstitucion) {
	this.generales_fechaconstitucion = generales_fechaconstitucion;
}
public Integer getGenerales_miembrosquorum() {
    return generales_miembrosquorum;
}
public void setGenerales_miembrosquorum(Integer generales_miembrosquorum) {
	this.generales_miembrosquorum = generales_miembrosquorum;
}	
public String getGenerales_estatus() {
    return generales_estatus;
}
public void setGenerales_estatus(String generales_estatus) {
	this.generales_estatus = generales_estatus;
}
public String getPresidente_propietario_nombre() {
    return presidente_propietario_nombre;
}
public void setPresidente_propietario_nombre(String presidente_propietario_nombre) {
	this.presidente_propietario_nombre = presidente_propietario_nombre;
}
public String getPresidente_propietario_propietario() {
    return presidente_propietario_propietario;
}
public void setPresidente_propietario_propietario(String presidente_propietario_propietario) {
	this.presidente_propietario_propietario = presidente_propietario_propietario;
}
public String getPresidente_propietario_propietarionacionalidad() {
    return presidente_propietario_propietarionacionalidad;
}
public void setPresidente_propietario_propietarionacionalidad(String presidente_propietario_propietarionacionalidad) {
	this.presidente_propietario_propietarionacionalidad = presidente_propietario_propietarionacionalidad;
}
public String getPresidente_propietario_propietariosino() {
    return presidente_propietario_propietariosino;
}
public void setPresidente_propietario_propietariosino(String presidente_propietario_propietariosino) {
	this.presidente_propietario_propietariosino = presidente_propietario_propietariosino;
}
public String getPresidente_suplente_nombre() {
    return presidente_suplente_nombre;
}
public void setPresidente_suplente_nombre(String presidente_suplente_nombre) {
	this.presidente_suplente_nombre = presidente_suplente_nombre;
}
public String getPresidente_suplente_propietario() {
    return presidente_suplente_propietario;
}
public void setPresidente_suplente_propietario(String presidente_suplente_propietario) {
	this.presidente_suplente_propietario = presidente_suplente_propietario;
}
public String getPresidente_suplente_propietarionacionalidad() {
    return presidente_suplente_propietarionacionalidad;
}
public void setPresidente_suplente_propietarionacionalidad(String presidente_suplente_propietarionacionalidad) {
	this.presidente_suplente_propietarionacionalidad = presidente_suplente_propietarionacionalidad;
}
public String getPresidente_suplente_propietariosino() {
    return presidente_suplente_propietariosino;
}
public void setPresidente_suplente_propietariosino(String presidente_suplente_propietariosino) {
	this.presidente_suplente_propietariosino = presidente_suplente_propietariosino;
}
public String getSecretario_propietario_nombre() {
    return secretario_propietario_nombre;
}
public void setSecretario_propietario_nombre(String secretario_propietario_nombre) {
	this.secretario_propietario_nombre = secretario_propietario_nombre;
}
public String getSecretario_propietario_propietario() {
    return secretario_propietario_propietario;
}
public void setSecretario_propietario_propietario(String secretario_propietario_propietario) {
	this.secretario_propietario_propietario = secretario_propietario_propietario;
}
public String getSecretario_propietario_propietarionacionalidad() {
    return secretario_propietario_propietarionacionalidad;
}
public void setSecretario_propietario_propietarionacionalidad(String secretario_propietario_propietarionacionalidad) {
	this.secretario_propietario_propietarionacionalidad = secretario_propietario_propietarionacionalidad;
}
public String getSecretario_propietario_propietariosino() {
    return secretario_propietario_propietariosino;
}
public void setSecretario_propietario_propietariosino(String secretario_propietario_propietariosino) {
	this.secretario_propietario_propietariosino = secretario_propietario_propietariosino;
}
public String getSecretario_suplente_nombre() {
    return secretario_suplente_nombre;
}
public void setSecretario_suplente_nombre(String secretario_suplente_nombre) {
	this.secretario_suplente_nombre = secretario_suplente_nombre;
}
public String getSecretario_suplente_propietario() {
    return secretario_suplente_propietario;
}
public void setSecretario_suplente_propietario(String secretario_suplente_propietario) {
	this.secretario_suplente_propietario = secretario_suplente_propietario;
}
public String getSecretario_suplente_propietarionacionalidad() {
    return secretario_suplente_propietarionacionalidad;
}
public void setSecretario_suplente_propietarionacionalidad(String secretario_suplente_propietarionacionalidad) {
	this.secretario_suplente_propietarionacionalidad = secretario_suplente_propietarionacionalidad;
}
public String getSecretario_suplente_propietariosino() {
    return secretario_suplente_propietariosino;
}
public void setSecretario_suplente_propietariosino(String secretario_suplente_propietariosino) {
	this.secretario_suplente_propietariosino = secretario_suplente_propietariosino;
}
public String getVocal_propietario_nombre() {
    return vocal_propietario_nombre;
}
public void setVocal_propietario_nombre(String vocal_propietario_nombre) {
	this.vocal_propietario_nombre = vocal_propietario_nombre;
}
public String getVocal_propietario_propietario() {
    return vocal_propietario_propietario;
}
public void setVocal_propietario_propietario(String vocal_propietario_propietario) {
	this.vocal_propietario_propietario = vocal_propietario_propietario;
}
public String getVocal_propietario_propietarionacionalidad() {
    return vocal_propietario_propietarionacionalidad;
}
public void setVocal_propietario_propietarionacionalidad(String vocal_propietario_propietarionacionalidad) {
	this.vocal_propietario_propietarionacionalidad = vocal_propietario_propietarionacionalidad;
}
public String getVocal_propietario_propietariosino() {
    return vocal_propietario_propietariosino;
}
public void setVocal_propietario_propietariosino(String vocal_propietario_propietariosino) {
	this.vocal_propietario_propietariosino = vocal_propietario_propietariosino;
}
public String getVocal_suplente_nombre() {
    return vocal_suplente_nombre;
}
public void setVocal_suplente_nombre(String vocal_suplente_nombre) {
	this.vocal_suplente_nombre = vocal_suplente_nombre;
}
public String getVocal_suplente_propietario() {
    return vocal_suplente_propietario;
}
public void setVocal_suplente_propietario(String vocal_suplente_propietario) {
	this.vocal_suplente_propietario = vocal_suplente_propietario;
}
public String getVocal_suplente_propietarionacionalidad() {
    return vocal_suplente_propietarionacionalidad;
}
public void setVocal_suplente_propietarionacionalidad(String vocal_suplente_propietarionacionalidad) {
	this.vocal_suplente_propietarionacionalidad = vocal_suplente_propietarionacionalidad;
}
public String getVocal_suplente_propietariosino() {
    return vocal_suplente_propietariosino;
}
public void setVocal_suplente_propietariosino(String vocal_suplente_propietariosino) {
	this.vocal_suplente_propietariosino = vocal_suplente_propietariosino;
}
}
