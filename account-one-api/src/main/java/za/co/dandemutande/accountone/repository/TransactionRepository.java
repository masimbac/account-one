package za.co.dandemutande.accountone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import za.co.dandemutande.accountone.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	@Query("SELECT t FROM Transaction AS t WHERE t.account.id = :accountId")
	List<Transaction> findByAccountId(@Param("accountId") Long accountId);
}
