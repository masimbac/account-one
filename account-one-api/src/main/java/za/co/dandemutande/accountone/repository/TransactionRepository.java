package za.co.dandemutande.accountone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.dandemutande.accountone.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

}
