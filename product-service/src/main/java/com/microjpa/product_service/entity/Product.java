package com.microjpa.product_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity is a JPA annotation used to mark a Java class as a database table.
@Entity   // tells JPA this class is a table  
@Table(name="products")

@Data
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// tells JPA that the ID value will be generated automatically
	//It means the database generates the id using AUTO_INCREMENT.
	private long id;
	private String name;
	private double price;
	private int quantity;
	
}
