package za.co.dandemutande.accountone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.dandemutande.accountone.model.Transaction;
import za.co.dandemutande.accountone.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
	public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
		return null;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction) {
		return null;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Transaction> getTransaction(String id) {
		return null;
	}
	
	@GetMapping()
	public ResponseEntity<List<Transaction>> getTransactions() {
		return null;
	}

}
