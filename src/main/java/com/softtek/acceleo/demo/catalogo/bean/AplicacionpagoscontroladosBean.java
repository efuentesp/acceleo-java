package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Fideicomiso;

public class AplicacionpagoscontroladosBean {

/**
 * Clase AplicacionpagoscontroladosBean.
 * @author PSG.
 *
 */
 
private UUID aplicacionpagoscontroladosId; 
private UUID fideicomisoId;
private UUID subfisoId;
private String importe;
private String importepago;
private String formapago;
private String tipocomision;
private String iva;
private String moneda;

public UUID getAplicacionPagosControladosId() {
    return aplicacionpagoscontroladosId;  		
   }
public void setAplicacionPagosControladosId(UUID aplicacionpagoscontroladosId) {
	this.aplicacionpagoscontroladosId = aplicacionpagoscontroladosId;
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
public String getImporte() {
    return importe;
}
public void setImporte(String importe) {
	this.importe = importe;
}
public String getImportepago() {
    return importepago;
}
public void setImportepago(String importepago) {
	this.importepago = importepago;
}
public String getFormapago() {
    return formapago;
}
public void setFormapago(String formapago) {
	this.formapago = formapago;
}
public String getTipocomision() {
    return tipocomision;
}
public void setTipocomision(String tipocomision) {
	this.tipocomision = tipocomision;
}
public String getIva() {
    return iva;
}
public void setIva(String iva) {
	this.iva = iva;
}
public String getMoneda() {
    return moneda;
}
public void setMoneda(String moneda) {
	this.moneda = moneda;
}
}
