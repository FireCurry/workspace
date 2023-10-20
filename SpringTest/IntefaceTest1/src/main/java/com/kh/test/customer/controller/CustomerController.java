package com.kh.test.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.test.customer.model.dto.Customer;
import com.kh.test.customer.model.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@PostMapping("enrollCustomer")
	public String enrollCustomer(Customer customer, Model model) {
		
		service.enrollCustomer(customer);
		model.addAttribute("customerName", customer.getCustomerName());
		return "result";
	}
}
