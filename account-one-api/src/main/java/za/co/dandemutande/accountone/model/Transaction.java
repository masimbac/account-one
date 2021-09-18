package za.co.dandemutande.accountone.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {
	
	@Id
	@Column
	private String id;
	@ManyToOne
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private Account account;
	@Column
	private BigDecimal amount;

}
