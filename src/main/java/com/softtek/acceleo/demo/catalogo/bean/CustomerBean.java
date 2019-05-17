package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;

public class CustomerBean {

/**
 * Clase CustomerBean.
 * @author PSG.
 *
 */
 
private Integer customerId; 
private Double number;	
private String name;
private String customertype;
private String email;	
private String photologo;
private String charterdocument;	
private Date dateregistered;	
private String comments;	

	public Integer getCustomerId () {
	    return customerId;  		
    }
	public void setCustomerId (Integer customerId) {
		this.customerId = customerId;
	}

public Double getNumber () {
    return number;
    }
public void setNumber(Double number) {
	this.number = number;
}	
public String getName () {
    return name;
    }
public void setName(String name) {
	this.name = name;
}
public String getCustomertype () {
    return customertype;
    }
public void setCustomertype(String customertype) {
	this.customertype = customertype;
}
public String getEmail () {
    return email;
    }
public void setEmail(String email) {
	this.email = email;
}
public String getPhotologo () {
    return photologo;
    }
public void setPhotologo(String photologo) {
	this.photologo = photologo;
}
public String getCharterdocument () {
    return charterdocument;
    }
public void setCharterdocument(String charterdocument) {
	this.charterdocument = charterdocument;
}
public Date getDateregistered () {
    return dateregistered;
    }
public void setDateregistered(Date dateregistered) {
	this.dateregistered = dateregistered;
}
public String getComments () {
    return comments;
    }
public void setComments(String comments) {
	this.comments = comments;
}	
}
