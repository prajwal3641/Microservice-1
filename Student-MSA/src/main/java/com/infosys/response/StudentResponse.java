package com.infosys.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
	private Integer id;
	private String name;
	private String course;
	private Integer addressId;
	private AddressResponse addressResponse;
}
