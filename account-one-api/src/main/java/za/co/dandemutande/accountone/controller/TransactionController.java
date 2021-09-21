package za.co.dandemutande.accountone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import za.co.dandemutande.accountone.model.Account;
import za.co.dandemutande.accountone.model.Transaction;
import za.co.dandemutande.accountone.model.dto.TransactionDTO;
import za.co.dandemutande.accountone.service.AccountService;
import za.co.dandemutande.accountone.service.TransactionService;

@RestController
@RequestMapping("/transactions")
@Api("Contains operations relating to creation and management of customers")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	@Autowired
	private AccountService accountService;

	@PostMapping
	@ApiOperation("Creates a new transaction on the system.")
	public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) {
		try {
			Transaction trans = new Transaction();
			Account account = accountService.getAccount(transaction.getAccountId());
			trans.setAccount(account);
			trans.setAmount(transaction.getAmount());
			trans = transactionService.createTransaction(trans);
			account.setBalance(account.getBalance().add(trans.getAmount()));
			accountService.updateAccount(account);
			return ResponseEntity.ok(trans);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}

	@GetMapping("/{id}")
	@ApiOperation("Finds the transaction identified by a given ID.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Transaction has been found on the system"),
			@ApiResponse(code = 404, message = "Transaction identified by supplied ID not found on the system") })
	public ResponseEntity<Transaction> getTransaction(Long id) {
		Transaction t = transactionService.getTransaction(id);
		return t == null ? new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(t);
	}

}
