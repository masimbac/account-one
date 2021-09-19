package za.co.dandemutande.accountone.model.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class AccountDTO {
	
	private Long customerId;
	private BigDecimal amount;

}
