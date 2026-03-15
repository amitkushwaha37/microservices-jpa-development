package com.microjpa.order_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microjpa.order_service.entity.Order;
import com.microjpa.order_service.repository.OrderRepository;
import com.microjpa.order_service.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;
    
    @Autowired
    private OrderRepository repository;

    @PostMapping
    public Order createOrder(@RequestBody Order order){
        return service.createOrder(order);
    }
    
    @GetMapping
    public List<Order> getOrders(){
        return repository.findAll();
    }

}
