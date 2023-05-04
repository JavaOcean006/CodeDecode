package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customers;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/getCustomer")
	public ResponseEntity<Map<Long, List<Customers>>> getCustomer() {

		log.info("Request from getCustomer method at CustomerController::");
		Map<Long, List<Customers>> cust = customerService.getCustomer();

		return new ResponseEntity<>(cust, HttpStatus.OK);

	}

	@PostMapping("/saveCustomers")
	public ResponseEntity<Customers> saveCustomer(@RequestBody Customers customer) {

		log.info("Request from saveCustomer method at CustomerController::" + customer);
		if (customer != null) {
			log.info("Request------>>>>" + customer);
			customerService.saveCustomer(customer);
			log.info("Create Customer process is completed");
		} else {
			log.info("Request is Empty");

		}
		return new ResponseEntity<>(customer, HttpStatus.CREATED);

	}
}
