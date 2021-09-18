package za.co.dandemutande.accountone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class Customer {
	
	@Column
	@Id
	private String id;
	@Column
	private String firstname;
	@Column
	private String lastname;

}
