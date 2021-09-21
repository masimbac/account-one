package za.co.dandemutande.accountone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import za.co.dandemutande.accountone.model.Customer;
import za.co.dandemutande.accountone.service.CustomerService;

@RestController
@RequestMapping("/customers")
@Api("Contains operations relating to creation and management of customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	@ApiOperation("Creates a new customer.")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		try {
			customer = customerService.createCustomer(customer);
			return ResponseEntity.status(HttpStatus.CREATED).body(customer);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}

	@PutMapping("/{id}")
	@ApiOperation("Updates details for a customer.")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		try {
			customer = customerService.updateCustomer(customer);
			return ResponseEntity.ok(customer);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}

	@GetMapping("/{id}")
	@ApiOperation("Finds the customer identified by a given ID.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Customer has been found on the system"),
			@ApiResponse(code = 404, message = "Customer identified by supplied ID not found on the system") })
	public ResponseEntity<Customer> getCustomer(Long id) {
		Customer customer = customerService.getCustomer(id);
		return customer == null ? new ResponseEntity<Customer>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(customer);
	}

	@GetMapping()
	@ApiOperation("Lists customers on the system.")
	public ResponseEntity<List<Customer>> getCustomers() {
		List<Customer> customers = customerService.getCustomers();
		return ResponseEntity.ok(customers);
	}

}
