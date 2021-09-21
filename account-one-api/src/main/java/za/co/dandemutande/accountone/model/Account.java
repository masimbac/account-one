package za.co.dandemutande.accountone.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "account")
@Data
public class Account {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	@NotNull(message = "Customer is required")
	private Customer customer;
	@Column(name = "initial_credit")
	@NotNull(message = "Initial credit is required")
	private BigDecimal initialCredit;
	@Column(name = "balance")
	@NotNull(message = "Balance is required")
	private BigDecimal balance;

}
