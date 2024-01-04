package com.example.demo.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.form.Message;
import com.example.demo.form.ProductForm;
import com.example.demo.repository.ProductRepository;


@RestController
@RequestMapping("/api/customer")
public class RestAPIController {
	
	@Autowired
	ProductRepository productRepository;
	
    
    @PostMapping("/create")
    public ResponseEntity<Message> addNewCustomer(@RequestBody ProductForm productForm) {
    	try {
    		Product returnedCustomer = productRepository.save1(productForm);
    		
    		return new ResponseEntity<Message>(new Message("Upload Successfully!", 
    										Arrays.asList(returnedCustomer), ""), HttpStatus.OK);
    	}catch(Exception e) {
    		return new ResponseEntity<Message>(new Message("Fail to post a new Customer!", 
    										null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);			
    	}
    }
    
}
