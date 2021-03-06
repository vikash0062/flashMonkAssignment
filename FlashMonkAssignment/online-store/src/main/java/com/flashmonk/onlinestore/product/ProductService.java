package com.flashmonk.onlinestore.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/*
 * 
 * @author VIKASH130298@GMAIL.COM 
 * 
 * 
 */


@Service
public class ProductService {

	@Autowired
	ProductDao productDao;
   
	List<Product> allProduct = new ArrayList<>() ;
	
	public Integer saveProduct(Product product) {
		
		Product prod = productDao.save(product);
		return prod.getProductid();
	}
	public Product getByProductId(Integer id)
	{
		
		Product product = productDao.getById(id);
		return product;
	}
	
	public List<Product> getAllProduct()
	{
		
		allProduct = productDao.findAll();
		return allProduct;
		
	}
	public List<Product> getAvailableProduct() {
		
		List<Product> availableProduct = new ArrayList<>();
		allProduct = productDao.findAll();
		
		for(Product product: allProduct)
		{
			if(product.getQuantity()>=1)
				availableProduct.add(product);
		}
		
		
		
		return availableProduct;
	}
}
