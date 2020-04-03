package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Fideicomiso;

public class ParametroscomisionesBean {

/**
 * Clase ParametroscomisionesBean.
 * @author PSG.
 *
 */
 
private UUID parametroscomisionesId; 
private UUID fideicomisoId;
private String tipocalculo;
private String aquiensecobra;
private Double montoaceptacion;
private String importeanualizado;
private String periodicidad;
private String calculoaldiaprimero;
private String reevaluacion;
private Date fechaconstitucion;
private Date fechapivote;
private Date fechaproxcalculo;
private String metodopago;
private String aquienfactura;
private String nombre;
private String comentario;
private String estatus;
private String penasconvencionales;
private String moneda;
private String interes;
private String tipoiva;
private Integer diacorte;
private Date fechaprimercalculo;
private Date fechaultimocalculo;
private String cuentapago;
private String numero;
private String situacionmorosidad;

public UUID getParametrosComisionesId() {
    return parametroscomisionesId;  		
   }
public void setParametrosComisionesId(UUID parametroscomisionesId) {
	this.parametroscomisionesId = parametroscomisionesId;
}

public UUID getFideicomisoId() {
    return fideicomisoId;
}
public void setFideicomiso(UUID fideicomisoId) {
	this.fideicomisoId = fideicomisoId;
}
public String getTipocalculo() {
    return tipocalculo;
}
public void setTipocalculo(String tipocalculo) {
	this.tipocalculo = tipocalculo;
}
public String getAquiensecobra() {
    return aquiensecobra;
}
public void setAquiensecobra(String aquiensecobra) {
	this.aquiensecobra = aquiensecobra;
}
public Double getMontoaceptacion() {
    return montoaceptacion;
}
public void setMontoaceptacion(Double montoaceptacion) {
	this.montoaceptacion = montoaceptacion;
}
public String getImporteanualizado() {
    return importeanualizado;
}
public void setImporteanualizado(String importeanualizado) {
	this.importeanualizado = importeanualizado;
}
public String getPeriodicidad() {
    return periodicidad;
}
public void setPeriodicidad(String periodicidad) {
	this.periodicidad = periodicidad;
}
public String getCalculoaldiaprimero() {
    return calculoaldiaprimero;
}
public void setCalculoaldiaprimero(String calculoaldiaprimero) {
	this.calculoaldiaprimero = calculoaldiaprimero;
}
public String getReevaluacion() {
    return reevaluacion;
}
public void setReevaluacion(String reevaluacion) {
	this.reevaluacion = reevaluacion;
}
public Date getFechaconstitucion() {
    return fechaconstitucion;
}
public void setFechaconstitucion(Date fechaconstitucion) {
	this.fechaconstitucion = fechaconstitucion;
}
public Date getFechapivote() {
    return fechapivote;
}
public void setFechapivote(Date fechapivote) {
	this.fechapivote = fechapivote;
}
public Date getFechaproxcalculo() {
    return fechaproxcalculo;
}
public void setFechaproxcalculo(Date fechaproxcalculo) {
	this.fechaproxcalculo = fechaproxcalculo;
}
public String getMetodopago() {
    return metodopago;
}
public void setMetodopago(String metodopago) {
	this.metodopago = metodopago;
}
public String getAquienfactura() {
    return aquienfactura;
}
public void setAquienfactura(String aquienfactura) {
	this.aquienfactura = aquienfactura;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getComentario() {
    return comentario;
}
public void setComentario(String comentario) {
	this.comentario = comentario;
}	
public String getEstatus() {
    return estatus;
}
public void setEstatus(String estatus) {
	this.estatus = estatus;
}
public String getPenasconvencionales() {
    return penasconvencionales;
}
public void setPenasconvencionales(String penasconvencionales) {
	this.penasconvencionales = penasconvencionales;
}
public String getMoneda() {
    return moneda;
}
public void setMoneda(String moneda) {
	this.moneda = moneda;
}
public String getInteres() {
    return interes;
}
public void setInteres(String interes) {
	this.interes = interes;
}
public String getTipoiva() {
    return tipoiva;
}
public void setTipoiva(String tipoiva) {
	this.tipoiva = tipoiva;
}
public Integer getDiacorte() {
    return diacorte;
}
public void setDiacorte(Integer diacorte) {
	this.diacorte = diacorte;
}	
public Date getFechaprimercalculo() {
    return fechaprimercalculo;
}
public void setFechaprimercalculo(Date fechaprimercalculo) {
	this.fechaprimercalculo = fechaprimercalculo;
}
public Date getFechaultimocalculo() {
    return fechaultimocalculo;
}
public void setFechaultimocalculo(Date fechaultimocalculo) {
	this.fechaultimocalculo = fechaultimocalculo;
}
public String getCuentapago() {
    return cuentapago;
}
public void setCuentapago(String cuentapago) {
	this.cuentapago = cuentapago;
}
public String getNumero() {
    return numero;
}
public void setNumero(String numero) {
	this.numero = numero;
}
public String getSituacionmorosidad() {
    return situacionmorosidad;
}
public void setSituacionmorosidad(String situacionmorosidad) {
	this.situacionmorosidad = situacionmorosidad;
}
}
