package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Contratoinversion;
import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Instruccion;
import com.softtek.acceleo.demo.domain.Fideicomiso;

public class CompradirectoBean {

/**
 * Clase CompradirectoBean.
 * @author PSG.
 *
 */
 
private UUID compradirectoId; 
private UUID instruccionId;
private String fechavalor;
private String titulosgarantia;
private UUID subfisoId;
private String operacionfutura;
private Date fechaoperacion;
private String activos;
private String tipomovimiento;
private String importe;
private String custodio;
private String comision;
private String mercado;
private String instrumento;
private String isr;
private String moneda;
private UUID fideicomisoId;
private UUID contratoinversionId;
private String fechaliquidacion;
private String emisiones;
private String serie;
private String notitulos;
private String precio;
private String desccomplementaria;
private String intereses;
private String pizarra;
private String cupon;

public UUID getCompraDirectoId() {
    return compradirectoId;  		
   }
public void setCompraDirectoId(UUID compradirectoId) {
	this.compradirectoId = compradirectoId;
}

public UUID getInstruccionId() {
    return instruccionId;
}
public void setInstruccion(UUID instruccionId) {
	this.instruccionId = instruccionId;
}
public String getFechavalor() {
    return fechavalor;
}
public void setFechavalor(String fechavalor) {
	this.fechavalor = fechavalor;
}
public String getTitulosgarantia() {
    return titulosgarantia;
}
public void setTitulosgarantia(String titulosgarantia) {
	this.titulosgarantia = titulosgarantia;
}
public UUID getSubfisoId() {
    return subfisoId;
}
public void setSubfiso(UUID subfisoId) {
	this.subfisoId = subfisoId;
}
public String getOperacionfutura() {
    return operacionfutura;
}
public void setOperacionfutura(String operacionfutura) {
	this.operacionfutura = operacionfutura;
}
public Date getFechaoperacion() {
    return fechaoperacion;
}
public void setFechaoperacion(Date fechaoperacion) {
	this.fechaoperacion = fechaoperacion;
}
public String getActivos() {
    return activos;
}
public void setActivos(String activos) {
	this.activos = activos;
}
public String getTipomovimiento() {
    return tipomovimiento;
}
public void setTipomovimiento(String tipomovimiento) {
	this.tipomovimiento = tipomovimiento;
}
public String getImporte() {
    return importe;
}
public void setImporte(String importe) {
	this.importe = importe;
}
public String getCustodio() {
    return custodio;
}
public void setCustodio(String custodio) {
	this.custodio = custodio;
}
public String getComision() {
    return comision;
}
public void setComision(String comision) {
	this.comision = comision;
}
public String getMercado() {
    return mercado;
}
public void setMercado(String mercado) {
	this.mercado = mercado;
}
public String getInstrumento() {
    return instrumento;
}
public void setInstrumento(String instrumento) {
	this.instrumento = instrumento;
}
public String getIsr() {
    return isr;
}
public void setIsr(String isr) {
	this.isr = isr;
}
public String getMoneda() {
    return moneda;
}
public void setMoneda(String moneda) {
	this.moneda = moneda;
}
public UUID getFideicomisoId() {
    return fideicomisoId;
}
public void setFideicomiso(UUID fideicomisoId) {
	this.fideicomisoId = fideicomisoId;
}
public UUID getContratoinversionId() {
    return contratoinversionId;
}
public void setContratoinversion(UUID contratoinversionId) {
	this.contratoinversionId = contratoinversionId;
}
public String getFechaliquidacion() {
    return fechaliquidacion;
}
public void setFechaliquidacion(String fechaliquidacion) {
	this.fechaliquidacion = fechaliquidacion;
}
public String getEmisiones() {
    return emisiones;
}
public void setEmisiones(String emisiones) {
	this.emisiones = emisiones;
}
public String getSerie() {
    return serie;
}
public void setSerie(String serie) {
	this.serie = serie;
}
public String getNotitulos() {
    return notitulos;
}
public void setNotitulos(String notitulos) {
	this.notitulos = notitulos;
}
public String getPrecio() {
    return precio;
}
public void setPrecio(String precio) {
	this.precio = precio;
}
public String getDesccomplementaria() {
    return desccomplementaria;
}
public void setDesccomplementaria(String desccomplementaria) {
	this.desccomplementaria = desccomplementaria;
}
public String getIntereses() {
    return intereses;
}
public void setIntereses(String intereses) {
	this.intereses = intereses;
}
public String getPizarra() {
    return pizarra;
}
public void setPizarra(String pizarra) {
	this.pizarra = pizarra;
}
public String getCupon() {
    return cupon;
}
public void setCupon(String cupon) {
	this.cupon = cupon;
}
}
