package za.co.dandemutande.accountone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class Customer {
	
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	@NotNull(message = "Firstname is required")
	private String firstname;
	@Column
	@NotNull(message = "Lastname is required")
	private String lastname;

}
