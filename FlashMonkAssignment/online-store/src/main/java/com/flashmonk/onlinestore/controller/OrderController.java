package com.flashmonk.onlinestore.controller;



import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flashmonk.onlinestore.order.OrderPlaced;
import com.flashmonk.onlinestore.exception.OnlineStoreException;
import com.flashmonk.onlinestore.order.OrderDto;
import com.flashmonk.onlinestore.order.OrderService;

/*
 * 
 * @author VIKASH130298@GMAIL.COM
 * 
 */


@RestController
@RequestMapping("/Order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	Logger logger = Logger.getLogger(OrderController.class.getName());
	
	@PostMapping("/addToCart")
	ResponseEntity<?> orderPlaced(@RequestBody OrderPlaced orderPlaced, @RequestParam Integer customerId) throws OnlineStoreException
	{
		orderService.orderPlaced(orderPlaced,customerId);
		logger.log(Level.INFO,()->" Added To Cartfor CustomerId"+ customerId);
		return new ResponseEntity("added to cart",HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/cancelOrder/{orderId}")
	ResponseEntity<?> cancelToCart(@PathVariable("orderId") Integer orderId, @RequestParam Integer customerId) throws OnlineStoreException
	{
		orderService.cancelOrder(orderId,customerId);
		return new ResponseEntity("order get cancel ",HttpStatus.OK);
	}
	
	@GetMapping("/getOrder")
	ResponseEntity<OrderDto> getOrderByUser(@RequestParam("customerId") Integer customerId)
	{
		Integer user_id = customerId;
		
		OrderDto orderDto = orderService.listOrder(user_id);
		return new ResponseEntity(orderDto,HttpStatus.OK);
		
	}
	

}
