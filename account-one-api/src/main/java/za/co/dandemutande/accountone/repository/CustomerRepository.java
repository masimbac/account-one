package za.co.dandemutande.accountone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.dandemutande.accountone.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
