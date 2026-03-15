package com.microjpa.product_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microjpa.product_service.entity.Product;
import com.microjpa.product_service.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		
		return repository.save(product);
	}
	
	public List<Product> getProduct(){
		return repository.findAll();
	}
	
	public Product getProductById(Long id) {
	    return repository.findById(id).orElse(null);
	}
	
	public Product reduceQuantity(Long id, int quantity){

	    Product product = repository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Product not found"));

	    if(product.getQuantity() < quantity){
	        throw new RuntimeException("Not enough stock");
	    }

	    product.setQuantity(product.getQuantity() - quantity);

	    return repository.save(product);
	}
}
