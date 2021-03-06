package com.flashmonk.onlinestore.order;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.flashmonk.onlinestore.cutomer.Customer;
import com.flashmonk.onlinestore.product.Product;


/*
 * 
 * @author VIKASH130298@GMAIL.COM 
 * 
 * 
 */


@Entity
@Table(name = "order_item")
public class Order {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="created_date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="productid")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	private int quantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order() {
		super();
	}

}
