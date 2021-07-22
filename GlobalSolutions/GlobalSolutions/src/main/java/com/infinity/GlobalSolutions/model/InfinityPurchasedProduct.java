package com.infinity.GlobalSolutions.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "infinity_purchased_product")
public class InfinityPurchasedProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_id")
	private int purchaseId;

	@Column(name = "order_id")
	private int orderId;

	@Column(name = "product_id")
	private int productId;

	@JsonIgnoreProperties(value = { "infinityPurchasedProduct" })
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id", nullable = false, insertable = false, updatable = false)
	private InfinityOrder infinityOrder;

	public InfinityPurchasedProduct(int purchaseId, int orderId, int productId) {
		super();
		this.purchaseId = purchaseId;
		this.orderId = orderId;
		this.productId = productId;
	}

	public InfinityPurchasedProduct() {

	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
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
	
	public InfinityOrder getInfinityOrder() {
		return infinityOrder;
	}

	public void setInfinityOrder(InfinityOrder infinityOrder) {
		this.infinityOrder = infinityOrder;
	}

}
