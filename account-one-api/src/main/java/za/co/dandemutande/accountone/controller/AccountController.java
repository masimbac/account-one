package za.co.dandemutande.accountone.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import za.co.dandemutande.accountone.model.Account;
import za.co.dandemutande.accountone.model.Customer;
import za.co.dandemutande.accountone.model.Transaction;
import za.co.dandemutande.accountone.model.dto.AccountDTO;
import za.co.dandemutande.accountone.service.AccountService;
import za.co.dandemutande.accountone.service.CustomerService;
import za.co.dandemutande.accountone.service.TransactionService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody AccountDTO account) {
		Account acc = new Account();
		Customer customer = customerService.getCustomer(account.getCustomerId());
		acc.setCustomer(customer);
		acc.setInitialCredit(account.getAmount());
		acc.setBalance(account.getAmount());
		acc = accountService.createAccount(acc);
		if (account.getAmount().compareTo(BigDecimal.ZERO) != 0) {
			Transaction transaction = new Transaction();
			transaction.setAccount(acc);
			transaction.setAmount(acc.getInitialCredit());
			transactionService.createTransaction(transaction);
		}
		return ResponseEntity.ok(acc);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable("id") Long id) {
		Account account = accountService.getAccount(id);
		return ResponseEntity.ok(account);
	}
	
	@GetMapping("/{accountId}/transactions")
	public ResponseEntity<List<Transaction>> getTransactions(@PathVariable("accountId") Long accountId) {
		List<Transaction> transactions = transactionService.getTransactions(accountId);
		return ResponseEntity.ok(transactions);
	}
	
	@GetMapping()
	public ResponseEntity<List<Account>> getAccounts(@RequestParam("customerId") Long customerId) {
		List<Account> accounts = accountService.getAccounts(customerId);
		return ResponseEntity.ok(accounts);
	}

}
