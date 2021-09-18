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

import za.co.dandemutande.accountone.model.Account;
import za.co.dandemutande.accountone.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		return null;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
		return null;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccount(String id) {
		return null;
	}
	
	@GetMapping()
	public ResponseEntity<List<Account>> getAccounts() {
		return null;
	}

}
