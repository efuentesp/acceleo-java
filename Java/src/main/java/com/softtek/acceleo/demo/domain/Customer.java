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
@Table(name = "customer")
public class Customer implements Serializable {

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
	@Column(name = "customerId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  customerId;		

	@NotNull
	@Column(name = "number")
	private Double number;
	
	@NotNull
	@Column(name = "name")
	@Size(min = 3, max = 100)
	private String name;
	
	@NotNull
	private String customertype;
	@NotNull
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Column(name = "photologo")
	private String photologo;
	
	@NotNull
	@Column(name = "charterdocument")
	private String charterdocument;
	
	@NotNull
	@Column(name = "dateregistered")
	private Date dateregistered;
	
	@NotNull
	@Column(name = "comments")
	@Size(max = 200) 
	private String comments;
	

	public UUID getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UUID customerId) {
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
