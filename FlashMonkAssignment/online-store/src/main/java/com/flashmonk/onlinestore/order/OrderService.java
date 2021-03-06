package com.flashmonk.onlinestore.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashmonk.onlinestore.constants.OnlineStoreConstants;
import com.flashmonk.onlinestore.cutomer.Customer;
import com.flashmonk.onlinestore.cutomer.CustomerDao;
import com.flashmonk.onlinestore.cutomer.CustomerService;
import com.flashmonk.onlinestore.exception.OnlineStoreException;
import com.flashmonk.onlinestore.product.Product;
import com.flashmonk.onlinestore.product.ProductService;


/*
 * 
 * @author VIKASH130298@GMAIL.COM 
 * 
 * 
 */



@Service
public class OrderService {
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	ProductService  productService;
	
	@Autowired
	CustomerService customerService;
	
	
	public  void orderPlaced(OrderPlaced orderPlaced , Integer customerId) throws OnlineStoreException {
		
		Customer customer = customerService.getCustomerById(customerId);
		
		Integer product_id = orderPlaced.getProduct_id();
		
		Product product = productService.getByProductId(product_id);
		
		if(orderPlaced.getQuantity()> product.getQuantity())
			throw new OnlineStoreException (OnlineStoreConstants.ERR_PRODUCT_OUTOFSTOCk);
		
		Integer newQuantity = product.getQuantity()-orderPlaced.getQuantity();
		product.setQuantity(newQuantity);
		Order order = new Order();
		order.setCustomer(customer);
		order.setDate(new Date());
		order.setProduct(product);
		order.setQuantity(orderPlaced.getQuantity());
		
		orderDao.save(order);
		return;
	}


	public OrderDto listOrder(Integer customer_id) {
		
		Customer customer = customerService.getCustomerById(customer_id);
		
		
		Integer price =0;
		List<OrderItem>list= new ArrayList<>();
		List<Order> orderList = orderDao.findAllByCustomerOrderByDateDesc(customer);
		for(Order order:orderList) {
			OrderItem orderItem = new OrderItem(order);
			list.add(orderItem);
			Product product = order.getProduct();
			Integer cost = product.getPrice()*orderItem.getQuantity();
			price+=cost;
			
		}
		OrderDto orderDto = new OrderDto();
		orderDto.setList(list);
		orderDto.setTotalPrice(price);
		return orderDto;
		
	}


	public void cancelOrder(Integer orderId, Integer customerId) throws OnlineStoreException {
		
		Customer customer = customerService.getCustomerById(customerId);
		Order order = orderDao.getById(orderId);
		Product product = order.getProduct();
				
        if(order.getCustomer()== customer)
        {
			
			Integer newQuantity = order.getQuantity()+product.getQuantity();
			product.setQuantity(newQuantity);
		        orderDao.deleteById(orderId);
			
        }
			
		else
			throw new OnlineStoreException(OnlineStoreConstants.ERR_ORDER_NOT_FOUND);
		return;
		
	}


	


	
	
	
	

}
