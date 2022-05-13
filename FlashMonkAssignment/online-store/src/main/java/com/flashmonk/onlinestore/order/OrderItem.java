package com.flashmonk.onlinestore.order;

import com.flashmonk.onlinestore.product.Product;

/*
 * 
 * @author VIKASH130298@GMAIL.COM 
 * 
 * 
 */


public class OrderItem {
	
	private Integer id;
	
	private Product product;
	
	private Integer quantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public OrderItem() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public OrderItem(Order order) {
		this.id = order.getId();
		this.product = order.getProduct();
		this.quantity = order.getQuantity();
	}
	

}
