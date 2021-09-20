package za.co.dandemutande.accountone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import za.co.dandemutande.accountone.model.Transaction;
import za.co.dandemutande.accountone.repository.TransactionRepository;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Transaction createTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public Transaction getTransaction(Long id) {
		return transactionRepository.getById(id);
	}

	@Override
	public List<Transaction> getTransactions(Long accountId) {
		return transactionRepository.findByAccountId(accountId);
	}

}
