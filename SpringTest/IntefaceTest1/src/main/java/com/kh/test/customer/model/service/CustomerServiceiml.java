package com.kh.test.customer.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.test.customer.model.dto.Customer;
import com.kh.test.customer.model.mapper.CustomerMapper;

@Transactional( rollbackFor = Exception.class)
@Service
public class CustomerServiceiml implements CustomerService {

	@Autowired
	private CustomerMapper mapper;
	
	@Override
	public void enrollCustomer(Customer customer) {
		mapper.enrollCustomer(customer);
	}
}
