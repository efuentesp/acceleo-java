package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Transaccion;

public class AsientoscontablesBean {

/**
 * Clase AsientoscontablesBean.
 * @author PSG.
 *
 */
 
private UUID asientoscontablesId; 
private String folio;
private String operacion;
private String fechaalta;
private UUID transaccionId;
private String fechacontable;
private String cuenta;
private String sct;
private String ssct;
private String sssct;
private String ssssct;
private String descripcioncta;
private String moneda;
private String aux1;
private String aux2;
private String aux3;
private String cargoabono;
private String importe;
private String descripcion;

public UUID getAsientosContablesId() {
    return asientoscontablesId;  		
   }
public void setAsientosContablesId(UUID asientoscontablesId) {
	this.asientoscontablesId = asientoscontablesId;
}

public String getFolio() {
    return folio;
}
public void setFolio(String folio) {
	this.folio = folio;
}
public String getOperacion() {
    return operacion;
}
public void setOperacion(String operacion) {
	this.operacion = operacion;
}
public String getFechaalta() {
    return fechaalta;
}
public void setFechaalta(String fechaalta) {
	this.fechaalta = fechaalta;
}
public UUID getTransaccionId() {
    return transaccionId;
}
public void setTransaccion(UUID transaccionId) {
	this.transaccionId = transaccionId;
}
public String getFechacontable() {
    return fechacontable;
}
public void setFechacontable(String fechacontable) {
	this.fechacontable = fechacontable;
}
public String getCuenta() {
    return cuenta;
}
public void setCuenta(String cuenta) {
	this.cuenta = cuenta;
}
public String getSct() {
    return sct;
}
public void setSct(String sct) {
	this.sct = sct;
}
public String getSsct() {
    return ssct;
}
public void setSsct(String ssct) {
	this.ssct = ssct;
}
public String getSssct() {
    return sssct;
}
public void setSssct(String sssct) {
	this.sssct = sssct;
}
public String getSsssct() {
    return ssssct;
}
public void setSsssct(String ssssct) {
	this.ssssct = ssssct;
}
public String getDescripcioncta() {
    return descripcioncta;
}
public void setDescripcioncta(String descripcioncta) {
	this.descripcioncta = descripcioncta;
}
public String getMoneda() {
    return moneda;
}
public void setMoneda(String moneda) {
	this.moneda = moneda;
}
public String getAux1() {
    return aux1;
}
public void setAux1(String aux1) {
	this.aux1 = aux1;
}
public String getAux2() {
    return aux2;
}
public void setAux2(String aux2) {
	this.aux2 = aux2;
}
public String getAux3() {
    return aux3;
}
public void setAux3(String aux3) {
	this.aux3 = aux3;
}
public String getCargoabono() {
    return cargoabono;
}
public void setCargoabono(String cargoabono) {
	this.cargoabono = cargoabono;
}
public String getImporte() {
    return importe;
}
public void setImporte(String importe) {
	this.importe = importe;
}
public String getDescripcion() {
    return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}	
}
