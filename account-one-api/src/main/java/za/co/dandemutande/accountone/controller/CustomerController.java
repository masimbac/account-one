package za.co.dandemutande.accountone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.dandemutande.accountone.model.Customer;
import za.co.dandemutande.accountone.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		customer = customerService.createCustomer(customer);
		return ResponseEntity.ok(customer);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		customer = customerService.updateCustomer(customer);
		return ResponseEntity.ok(customer);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomer(Long id) {
		Customer customer = customerService.getCustomer(id);
		return ResponseEntity.ok(customer);
	}
	
	@GetMapping()
	public ResponseEntity<List<Customer>> getCustomers() {
		List<Customer> customers = customerService.getCustomers();
		return ResponseEntity.ok(customers);
	}

}
