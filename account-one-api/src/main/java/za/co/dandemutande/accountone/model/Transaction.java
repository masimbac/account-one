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
@Table(name = "transactions")
@Data
public class Transaction {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	@NotNull(message = "Account is required")
	private Account account;
	@Column
	@NotNull(message = "Amount is required")
	private BigDecimal amount;

}
