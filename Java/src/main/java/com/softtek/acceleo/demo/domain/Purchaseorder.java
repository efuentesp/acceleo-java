package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.WhereJoinTable;

@Entity
@Table(name = "purchaseorder")
public class Purchaseorder implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			          name = "UUID", 
	                  strategy = "org.hibernate.id.UUIDGenerator", 
	                  parameters = {
	                		@Parameter( 
	                				name = "uuid_gen_strategy_class", 
	                				value = "org.hibernate.id.uuid.CustomVersionOneStrategy" 
	                		) 
					  } 
					 )		
	@Column(name = "purchaseorderId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  purchaseorderId;		

	@NotNull
	private UUID customerId;
	@NotNull
	@Column(name = "number")
	@Size(min = 5, max = 8)
	private String number;
	
	@NotNull
	private String postatus;
	@NotNull
	@Column(name = "totalamount")
	private Double totalamount;
	
	@NotNull
	@Column(name = "totalweight")
	private Double totalweight;
	
	@NotNull
	@Column(name = "totalitems")
	private Integer totalitems;
	
	@NotNull

	public UUID getPurchaseorderId() {
		return purchaseorderId;
	}

	public void setPurchaseorderId(UUID purchaseorderId) {
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
