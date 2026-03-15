package com.microjpa.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="PRODUCT-SERVICE")
//“This interface will call another microservice named PRODUCT-SERVICE.”
public interface ProductClient {

	@GetMapping("/products/{id}")
    Object getProduct(@PathVariable Long id);
	
	 @PutMapping("/products/reduce/{id}")
	    Object reduceQuantity(@PathVariable Long id,
	                          @RequestParam int quantity);

}
