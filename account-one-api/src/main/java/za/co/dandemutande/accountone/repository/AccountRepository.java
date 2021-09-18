package za.co.dandemutande.accountone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.dandemutande.accountone.model.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
