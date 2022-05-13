package com.flashmonk.onlinestore.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flashmonk.onlinestore.cutomer.Customer;

/*
 * 
 * @author VIKASH130298@GMAIL.COM 
 * 
 * 
 */


public interface OrderDao extends JpaRepository<Order,Integer>{
	List<Order> findAllByCustomerOrderByDateDesc(Customer customer);

}
