package za.co.dandemutande.accountone.service;

import java.util.List;

import za.co.dandemutande.accountone.model.Customer;

public interface CustomerService {

	Customer createCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	Customer deleteCustomer(String id);

	Customer getCustomer(Long id);

	List<Customer> getCustomers();

}
