package com.flashmonk.onlinestore.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flashmonk.onlinestore.constants.OnlineStoreConstants;
import com.flashmonk.onlinestore.cutomer.Customer;
import com.flashmonk.onlinestore.cutomer.CustomerService;




/*
 * 
 * @author VIKASH130298@GMAIL.COM
 * 
 * 
 */



@RestController
@RequestMapping("/Customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	private static Logger logger = Logger.getLogger(CustomerController.class.getName());
	
	@PostMapping("/addCustomer")
	ResponseEntity<?> createCustomer(@RequestBody Customer customer)
	{
		
		Customer user = customer;
		Integer id = customerService.saveCustomer(user);
		logger.log(Level.INFO, ()-> "created Id is: " +id);
		return new ResponseEntity <>(OnlineStoreConstants.CUSTOMER_CREATED +": "+id,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getCustomer")
	ResponseEntity<?> getCustomer(@RequestParam("customerId") Integer customerId)
	{
		Integer Id = customerId;
		Customer customer = customerService.getCustomerById(Id);
		
		logger.log(Level.INFO,()->  "Customer with id "+Id+" : "+customer);
		Map<String,String> map = new HashMap<>();
		map.put("Customer Name", customer.getCustomerName());
		
		return new ResponseEntity(map,HttpStatus.OK);
		
	}

	@GetMapping("/allCustomer")
	ResponseEntity<List<Customer>> getCustomer()
	{
		
       List<Customer> allCustomer = new ArrayList<>();
       
		allCustomer = customerService.allCustomerById();
		logger.log(Level.INFO,()-> "All Available Customer is being called");
		
		return new ResponseEntity(allCustomer,HttpStatus.OK);
		
	}
	
	
	
	
	

}
