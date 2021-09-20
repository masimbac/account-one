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
		return accountRepository.save(account);
	}

	@Override
	public Account updateAccount(Account account) {
		return accountRepository.save(account);
	}


	@Override
	public Account getAccount(Long id) {
		return accountRepository.getById(id);
	}

	@Override
	public List<Account> getAccounts(Long customerId) {
		return accountRepository.findByCustomerId(customerId);
	}
	

}
