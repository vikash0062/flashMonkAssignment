package com.flashmonk.onlinestore.cutomer;

import java.util.HashMap;
import java.util.List;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 
 * @author VIKASH130298@GMAIL.COM 
 * 
 * 
 */


@Service
public class CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	
	public Integer saveCustomer(Customer customer)
	{
		Customer user = customer;
		Customer createdCustomer = customerDao.save(user);
		return createdCustomer.getCustomerId();
	}
	
	public Customer getCustomerById (Integer id)
	{
		
		Customer customer = customerDao.getById(id);
		return customer;
		
	}

	public List<Customer> allCustomerById() {
		List<Customer> customerList;
		customerList = customerDao.findAll();
		return customerList;
	}

}
