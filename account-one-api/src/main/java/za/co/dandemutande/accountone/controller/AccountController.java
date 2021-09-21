package za.co.dandemutande.accountone.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import za.co.dandemutande.accountone.model.Account;
import za.co.dandemutande.accountone.model.Customer;
import za.co.dandemutande.accountone.model.Transaction;
import za.co.dandemutande.accountone.model.dto.AccountDTO;
import za.co.dandemutande.accountone.service.AccountService;
import za.co.dandemutande.accountone.service.CustomerService;
import za.co.dandemutande.accountone.service.TransactionService;

@RestController
@RequestMapping("/accounts")
@Api(value = "Accounts Controller", description = "Operations pertaining to creating and managing accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private TransactionService transactionService;

	@PostMapping
	@ApiOperation("Creates a new account given a customer id and the initial credit amount")
	public ResponseEntity<Account> createAccount(@RequestBody AccountDTO account) {
		try {
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
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}

	@GetMapping("/{id}")
	@ApiOperation("Finds the account identified by a given ID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Account has been found on the system"),
			@ApiResponse(code = 404, message = "Account identified by supplied ID not found on the system") })
	public ResponseEntity<Account> getAccount(@PathVariable(value = "id", required = true) Long id) {
		Account account = accountService.getAccount(id);
		return account == null ? new ResponseEntity<Account>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(account);
	}

	@GetMapping("/{accountId}/transactions")
	@ApiOperation("Searches for the transactions belonging to a given account.")
	public ResponseEntity<List<Transaction>> getTransactions(
			@PathVariable(value = "accountId", required = true) Long accountId) {
		List<Transaction> transactions = transactionService.getTransactions(accountId);
		return ResponseEntity.ok(transactions);
	}

	@GetMapping()
	@ApiOperation("Searches for the accounts belonging to a given customer.")
	public ResponseEntity<List<Account>> getAccounts(
			@RequestParam(value = "customerId", required = true) Long customerId) {
		List<Account> accounts = accountService.getAccounts(customerId);
		return ResponseEntity.ok(accounts);
	}

}
