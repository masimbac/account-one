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
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return null;
	}

	@Override
	public Customer deleteCustomer(String id) {
		return null;
	}

	@Override
	public Customer getCustomer(String id) {
		return null;
	}

	@Override
	public List<Customer> getCustomers() {
		return null;
	}

}
