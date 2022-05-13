package com.flashmonk.onlinestore.order;

import java.util.List;


/*
 * 
 * @author VIKASH130298@GMAIL.COM 
 * 
 * 
 */


public class OrderDto {

	private List<OrderItem> list;
	
	private Integer totalPrice;

	public List<OrderItem> getList() {
		return list;
	}

	public void setList(List<OrderItem> list) {
		this.list = list;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public OrderDto() {
		
	}
	
}
