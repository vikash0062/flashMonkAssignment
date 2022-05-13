package com.flashmonk.onlinestore.controller;

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

import com.flashmonk.onlinestore.product.Product;
import com.flashmonk.onlinestore.product.ProductService;


/*
 * 
 * @author VIKASH130298@GMAIL.COM
 * 
 */


@RestController
@RequestMapping("/Product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	public static Logger logger = Logger.getLogger(ProductController.class.getName());
	
	@PostMapping("/addProduct")
	ResponseEntity<?> addProduct(@RequestBody Product product)
	{
		
		Product item = product;
		Integer id = productService.saveProduct(item);
		logger.log(Level.INFO,()-> "product created with Id" +id);
		
		return new ResponseEntity <>("product created: "+id,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/allProduct")
	ResponseEntity<List<Product>> allProduct()
	{
		List<Product> allProduct = productService.getAllProduct();
		
		logger.log(Level.INFO,()-> "all Product is listed");
		
		return new ResponseEntity(allProduct,HttpStatus.OK);
	}
	
	@GetMapping("/availableProduct")
	ResponseEntity<List<Product>> availableProduct()
	{
		List<Product> allProduct = productService.getAvailableProduct();
		
		logger.log(Level.INFO,()-> "Available product is being called");
		
		return new ResponseEntity(allProduct,HttpStatus.OK);
	}
	
	@GetMapping("/getProduct")
	ResponseEntity<?> getProduct(@RequestParam("productId") Integer ProductID)
	{
		Product product = productService.getByProductId(ProductID);
		Map<String , String> map = new HashMap<>();
		map.put("Product Name", product.getProductName());
		map.put("Price", product.getPrice().toString());
		map.put("Brand", product.getBrand());
		map.put("Quantity", product.getQuantity().toString());
		
		return new ResponseEntity(map,HttpStatus.ACCEPTED);
		
		
	}
	
}
