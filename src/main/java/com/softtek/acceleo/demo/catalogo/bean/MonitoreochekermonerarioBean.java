package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Fideicomiso;

public class MonitoreochekermonerarioBean {

/**
 * Clase MonitoreochekermonerarioBean.
 * @author PSG.
 *
 */
 
private UUID monitoreochekermonerarioId; 
private UUID fideicomisoId;
private UUID subfisoId;
private String foliooperacion;
private String importe;
private String fechaoperacion;
private String totalpagos;
private Integer liquidados;
private Integer contabilizados;
private Integer pendientes;
private Integer error;
private String estatus;

public UUID getMonitoreoChekerMonerarioId() {
    return monitoreochekermonerarioId;  		
   }
public void setMonitoreoChekerMonerarioId(UUID monitoreochekermonerarioId) {
	this.monitoreochekermonerarioId = monitoreochekermonerarioId;
}

public UUID getFideicomisoId() {
    return fideicomisoId;
}
public void setFideicomiso(UUID fideicomisoId) {
	this.fideicomisoId = fideicomisoId;
}
public UUID getSubfisoId() {
    return subfisoId;
}
public void setSubfiso(UUID subfisoId) {
	this.subfisoId = subfisoId;
}
public String getFoliooperacion() {
    return foliooperacion;
}
public void setFoliooperacion(String foliooperacion) {
	this.foliooperacion = foliooperacion;
}
public String getImporte() {
    return importe;
}
public void setImporte(String importe) {
	this.importe = importe;
}
public String getFechaoperacion() {
    return fechaoperacion;
}
public void setFechaoperacion(String fechaoperacion) {
	this.fechaoperacion = fechaoperacion;
}
public String getTotalpagos() {
    return totalpagos;
}
public void setTotalpagos(String totalpagos) {
	this.totalpagos = totalpagos;
}
public Integer getLiquidados() {
    return liquidados;
}
public void setLiquidados(Integer liquidados) {
	this.liquidados = liquidados;
}	
public Integer getContabilizados() {
    return contabilizados;
}
public void setContabilizados(Integer contabilizados) {
	this.contabilizados = contabilizados;
}	
public Integer getPendientes() {
    return pendientes;
}
public void setPendientes(Integer pendientes) {
	this.pendientes = pendientes;
}	
public Integer getError() {
    return error;
}
public void setError(Integer error) {
	this.error = error;
}	
public String getEstatus() {
    return estatus;
}
public void setEstatus(String estatus) {
	this.estatus = estatus;
}
}
