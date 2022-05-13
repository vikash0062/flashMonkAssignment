package com.flashmonk.onlinestore.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/*
 * 
 * @author VIKASH130298@GMAIL.COM 
 * 
 * 
 */


@Entity
@Table( name="Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productid;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name="price")
	private Integer price;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="quantity")
	private Integer quantity;

	public Integer getProductid() {
		return productid;
	}

	public Product() {
		super();
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	

}
