package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Fideicomiso;

public class SaldoscuentaBean {

/**
 * Clase SaldoscuentaBean.
 * @author PSG.
 *
 */
 
private UUID saldoscuentaId; 
private UUID fideicomisoId;
private UUID subfisoId;
private String cuenta;
private String sct;
private String ssct;
private String sssct;
private String ssssct;
private String moneda;
private String auxiliar1;
private String auxiliar2;
private String auxiliar3;
private String saldoinicial;
private String cargos;
private String abonos;
private String saldoactual;

public UUID getSaldosCuentaId() {
    return saldoscuentaId;  		
   }
public void setSaldosCuentaId(UUID saldoscuentaId) {
	this.saldoscuentaId = saldoscuentaId;
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
public String getMoneda() {
    return moneda;
}
public void setMoneda(String moneda) {
	this.moneda = moneda;
}
public String getAuxiliar1() {
    return auxiliar1;
}
public void setAuxiliar1(String auxiliar1) {
	this.auxiliar1 = auxiliar1;
}
public String getAuxiliar2() {
    return auxiliar2;
}
public void setAuxiliar2(String auxiliar2) {
	this.auxiliar2 = auxiliar2;
}
public String getAuxiliar3() {
    return auxiliar3;
}
public void setAuxiliar3(String auxiliar3) {
	this.auxiliar3 = auxiliar3;
}
public String getSaldoinicial() {
    return saldoinicial;
}
public void setSaldoinicial(String saldoinicial) {
	this.saldoinicial = saldoinicial;
}
public String getCargos() {
    return cargos;
}
public void setCargos(String cargos) {
	this.cargos = cargos;
}
public String getAbonos() {
    return abonos;
}
public void setAbonos(String abonos) {
	this.abonos = abonos;
}
public String getSaldoactual() {
    return saldoactual;
}
public void setSaldoactual(String saldoactual) {
	this.saldoactual = saldoactual;
}
}
