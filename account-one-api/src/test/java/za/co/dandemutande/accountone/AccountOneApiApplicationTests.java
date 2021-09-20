package za.co.dandemutande.accountone;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import za.co.dandemutande.accountone.model.Customer;

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
	public void shouldFindExistingCustomer() throws Exception {
		final String baseUrl = String.format("http://localhost:%s/customers", randomServerPort);
		URI uri = new URI(baseUrl);
		ResponseEntity<Customer[]> result = this.restTemplate.getForEntity(uri, Customer[].class);
		assertEquals(200, result.getStatusCodeValue());
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
	public void shouldAddAccountWithTransaction() {

	}

	@Test
	public void shouldAddAccountWithoutValidTransaction() {

	}

}
