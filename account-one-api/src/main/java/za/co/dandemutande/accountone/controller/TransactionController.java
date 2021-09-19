package za.co.dandemutande.accountone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.dandemutande.accountone.model.Transaction;
import za.co.dandemutande.accountone.model.dto.TransactionDTO;
import za.co.dandemutande.accountone.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
	public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) {
		return null;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Transaction> getTransaction(Long id) {
		return null;
	}

}
