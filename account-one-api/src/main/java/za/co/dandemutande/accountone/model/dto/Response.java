package za.co.dandemutande.accountone.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
	
	private T entity;
	private List<String> errors = new ArrayList<>();
	private boolean success;

}
