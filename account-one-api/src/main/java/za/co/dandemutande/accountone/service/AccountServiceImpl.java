package za.co.dandemutande.accountone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import za.co.dandemutande.accountone.model.Account;
import za.co.dandemutande.accountone.repository.AccountRepository;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) {
		return null;
	}

	@Override
	public Account updateAccount(Account account) {
		return null;
	}

	@Override
	public Account deleteAccount(String id) {
		return null;
	}

	@Override
	public Account getAccount(String id) {
		return null;
	}

	@Override
	public List<Account> getAccounts(String customerId) {
		return null;
	}
	

}
