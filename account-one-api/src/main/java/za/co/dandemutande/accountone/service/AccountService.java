package za.co.dandemutande.accountone.service;

import java.util.List;

import za.co.dandemutande.accountone.model.Account;

public interface AccountService {
	
	Account createAccount(Account account);
	
	Account updateAccount(Account account);
	
	Account deleteAccount(Long id);
	
	Account getAccount(Long id);
	
	List<Account> getAccounts(Long customerId);

}
