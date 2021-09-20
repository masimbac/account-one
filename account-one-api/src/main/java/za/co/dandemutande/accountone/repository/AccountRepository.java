package za.co.dandemutande.accountone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import za.co.dandemutande.accountone.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	@Query("SELECT account FROM Account AS account WHERE account.customer.id = :customerId")
	List<Account> findByCustomerId(@Param("customerId") Long customerId);

}
