package com.infinity.GlobalSolutions.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name = "infinity_product" )
public class InfinityProduct {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "product_id")
	private int productId; 
	
	@Column( name = "product_name")
	private String productName;
	
	@Column( name = "product_descr")
	private String productDescr;
	
	@Column( name = "amount")
	private int amount;
	
	public InfinityProduct() {
		// TODO Auto-generated constructor stub
	}
	public InfinityProduct(int productId, String productName, String productDescr, int 	amount) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescr = productDescr;
		this.amount = amount;
	}

	

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescr() {
		return productDescr;
	}
	public void setProductDescr(String productDescr) {
		this.productDescr = productDescr;
	}
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	

}
