package com.example.demo.form;

import java.util.ArrayList;

import java.util.List;

import com.example.demo.entity.Product;

public class Message {
	
	private String message = "";
	private List<Product> products = new ArrayList<Product>();
	private String error = "";
	
	public Message(String message, List<Product> products, String error) {
		this.message = message;
		this.products = products;
		this.error = error;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<Product> getCustomers(){
		return this.products;
	}
	
	public void setCustomers(ArrayList<Product> products) {
		this.products = products;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public String getError() {
		return this.error;
	}
}