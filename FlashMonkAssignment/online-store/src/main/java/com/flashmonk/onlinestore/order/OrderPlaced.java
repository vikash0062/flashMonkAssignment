package com.flashmonk.onlinestore.order;


/*
 * 
 * @author VIKASH130298@GMAIL.COM 
 * 
 * 
 */


public class OrderPlaced {

	private Integer id;
	
	private Integer product_id;
	
	private Integer quantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public OrderPlaced() {
		
	}
	
	
}
