package za.co.dandemutande.accountone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import za.co.dandemutande.accountone.model.Account;
import za.co.dandemutande.accountone.model.Customer;
import za.co.dandemutande.accountone.model.Transaction;
import za.co.dandemutande.accountone.model.dto.AccountDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AccountOneApiApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	int randomServerPort;

	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldFindExistingCustomers() throws Exception {
		final String baseUrl = String.format("http://localhost:%s/customers", randomServerPort);
		URI uri = new URI(baseUrl);
		ResponseEntity<Customer[]> result = this.restTemplate.getForEntity(uri, Customer[].class);
		assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
	public void shouldFindExistingCustomerById() throws Exception {
		final String baseUrl = String.format("http://localhost:%s/customers/1", randomServerPort);
		URI uri = new URI(baseUrl);
		ResponseEntity<Customer> result = this.restTemplate.getForEntity(uri, Customer.class);
		assertEquals(200, result.getStatusCodeValue());
		assertNotNull(result.getBody());
	}
	
	@Test
	public void shouldNotFindNonExistingCustomerById() throws Exception {
		final String baseUrl = String.format("http://localhost:%s/customers/10000", randomServerPort);
		URI uri = new URI(baseUrl);
		ResponseEntity<Customer> result = this.restTemplate.getForEntity(uri, Customer.class);
		assertEquals(404, result.getStatusCodeValue());
	}

	@Test
	public void shouldAddCustomer() throws Exception {
		final String baseUrl = String.format("http://localhost:%s/customers", randomServerPort);
		URI uri = new URI(baseUrl);
		Customer customer = new Customer();
		customer.setFirstname("Random");
		customer.setLastname("Stranger");
		HttpEntity<Customer> request = new HttpEntity<>(customer);
		ResponseEntity<Customer> result = this.restTemplate.postForEntity(uri, request, Customer.class);
		// Verify request succeed
		assertEquals(201, result.getStatusCodeValue());
	}

	@Test
	public void shouldAddAccountWithTransaction() throws Exception {
		final String baseUrl = String.format("http://localhost:%s", randomServerPort);
		URI uri = new URI(baseUrl + "/accounts");
		AccountDTO dto = new AccountDTO();
		dto.setCustomerId(2L);
		dto.setAmount(BigDecimal.valueOf(100.00));
		HttpEntity<AccountDTO> request = new HttpEntity<>(dto);
		ResponseEntity<Account> result = this.restTemplate.postForEntity(uri, request, Account.class);
		assertEquals(200, result.getStatusCodeValue());
		assertNotNull(result.getBody());
		assertTrue(result.getBody().getId() > 0);
		// Verify transaction was created
		uri = new URI(baseUrl + "/accounts/" + result.getBody().getId() + "/transactions");
		ResponseEntity<Transaction[]> result2 = this.restTemplate.getForEntity(uri, Transaction[].class);
		assertEquals(200, result.getStatusCodeValue());
		assertNotNull(result.getBody());
		assertTrue(result2.getBody().length > 0);
		
	}

	@Test
	public void shouldAddAccountWithoutTransaction() throws Exception {
		final String baseUrl = String.format("http://localhost:%s", randomServerPort);
		URI uri = new URI(baseUrl + "/accounts");
		AccountDTO dto = new AccountDTO();
		dto.setCustomerId(1L);
		dto.setAmount(BigDecimal.ZERO);
		HttpEntity<AccountDTO> request = new HttpEntity<>(dto);
		ResponseEntity<Account> result = this.restTemplate.postForEntity(uri, request, Account.class);
		assertEquals(200, result.getStatusCodeValue());
		assertNotNull(result.getBody());
		assertTrue(result.getBody().getId() > 0);
		// Verify transaction was created
		uri = new URI(baseUrl + "/accounts/" + result.getBody().getId() + "/transactions");
		ResponseEntity<Transaction[]> result2 = this.restTemplate.getForEntity(uri, Transaction[].class);
		assertEquals(200, result.getStatusCodeValue());
		assertNotNull(result.getBody());
		assertTrue(result2.getBody().length == 0);
	}

}
