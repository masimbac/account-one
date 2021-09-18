package za.co.dandemutande.accountone.service;

import java.util.List;

import za.co.dandemutande.accountone.model.Transaction;

public interface TransactionService {
	
	Transaction createTransaction(Transaction transaction);

	Transaction updateTransaction(Transaction transaction);

	Transaction deleteTransaction(String id);

	Transaction getTransaction(String id);

	List<Transaction> getTransactions(String accountId);

}
