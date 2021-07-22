package com.infinity.GlobalSolutions.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table ( name = "infinity_order" )
public class InfinityOrder {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY  )
	@Column( name = "order_id" )
	private int orderId;
	@Column( name = "product_id" )
	private int productId;
	@Column( name = "customer_id" )
	private int customerId;
	@Column( name = "order_type" )
	private String orderType;
	
	@JsonIgnoreProperties(value = {"infinityOrder"})
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable=false, insertable=false, updatable=false)
	private InfinityCustomer infinityCustomer;
	
	
	@JsonIgnoreProperties(value = {"infinityOrder"})
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy = "infinityOrder",  targetEntity = InfinityPurchasedProduct.class, cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private List<InfinityProduct> purchasedProducts;
	
	
	public InfinityOrder() {
		// TODO Auto-generated constructor stub
	}
	
	public InfinityOrder(int orderId, int productId, int customerId, String orderType) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.customerId = customerId;
		this.orderType = orderType;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public InfinityCustomer getInfinityCustomer() {
		return infinityCustomer;
	}

	public void setInfinityCustomer(InfinityCustomer infinityCustomer) {
		this.infinityCustomer = infinityCustomer;
	}

	public List<InfinityProduct> getPurchasedProducts() {
		return purchasedProducts;
	}

	public void setPurchasedProducts(List<InfinityProduct> purchasedProducts) {
		this.purchasedProducts = purchasedProducts;
	}

	

	
	

}
