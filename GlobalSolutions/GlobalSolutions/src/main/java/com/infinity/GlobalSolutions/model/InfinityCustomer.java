package com.infinity.GlobalSolutions.model;

import java.util.List;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "infinity_customer")
public class InfinityCustomer {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY  )
	@Column( name = "customer_id" )
	private int customerId;
	@Column( name = "Name" )
	private String name;
	@Column( name = "Address" )
	private String address;
	@Column( name = "Email" )
	private String email;
	@Column( name = "Contact" )
	private String contact;
	
	@JsonIgnoreProperties(value = {"infinityCustomer"})
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "infinityCustomer",  targetEntity = InfinityOrder.class, cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private List<InfinityOrder> orders;
	
	
	public InfinityCustomer(int customerId, String name, String address, String email, String contact,
			List<InfinityOrder> orders) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.email = email;
		this.contact = contact;
		this.orders = orders;
	}

	public InfinityCustomer() {
		// TODO Auto-generated constructor stub
	}
	
	public InfinityCustomer(int customerId, String name, String address, String email, String contact) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.email = email;
		this.contact = contact;
	}

	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public List<InfinityOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<InfinityOrder> orders) {
		this.orders = orders;
	}

	
}
