package za.co.dandemutande.accountone.service;

import java.util.List;

import za.co.dandemutande.accountone.model.Transaction;

public interface TransactionService {
	
	Transaction createTransaction(Transaction transaction);

	Transaction getTransaction(Long id);

	List<Transaction> getTransactions(Long accountId);

}
