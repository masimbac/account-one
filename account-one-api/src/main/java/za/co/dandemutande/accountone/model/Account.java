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
	private Customer customer;
	@Column(name = "initial_credit")
	private BigDecimal initialCredit;
	@Column(name = "balance")
	private BigDecimal balance;

}
