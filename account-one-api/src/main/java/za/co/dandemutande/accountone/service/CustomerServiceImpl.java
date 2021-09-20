package za.co.dandemutande.accountone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import za.co.dandemutande.accountone.model.Customer;
import za.co.dandemutande.accountone.repository.CustomerRepository;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}


	@Override
	public Customer getCustomer(Long id) {
		return customerRepository.findById(id).orElse(null);
	}

	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

}
