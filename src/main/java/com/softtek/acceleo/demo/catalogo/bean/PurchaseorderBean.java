package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;

public class PurchaseorderBean {

/**
 * Clase PurchaseorderBean.
 * @author PSG.
 *
 */
 
private Integer purchaseorderId; 
private UUID customerId;
private String number;
private String postatus;
private Double totalamount;	
private Double totalweight;	
private Integer totalitems;	

	public Integer getPurchaseorderId () {
	    return purchaseorderId;  		
    }
	public void setPurchaseorderId (Integer purchaseorderId) {
		this.purchaseorderId = purchaseorderId;
	}

public UUID getCustomerId () {
    return customerId;
    }
public void setCustomer(UUID customerId) {
	this.customerId = customerId;
}
public String getNumber () {
    return number;
    }
public void setNumber(String number) {
	this.number = number;
}
public String getPostatus () {
    return postatus;
    }
public void setPostatus(String postatus) {
	this.postatus = postatus;
}
public Double getTotalamount () {
    return totalamount;
    }
public void setTotalamount(Double totalamount) {
	this.totalamount = totalamount;
}
public Double getTotalweight () {
    return totalweight;
    }
public void setTotalweight(Double totalweight) {
	this.totalweight = totalweight;
}	
public Integer getTotalitems () {
    return totalitems;
    }
public void setTotalitems(Integer totalitems) {
	this.totalitems = totalitems;
}	
}
