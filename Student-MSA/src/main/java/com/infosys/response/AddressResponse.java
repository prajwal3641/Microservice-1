package com.infosys.response;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
	private Integer id;
	private String city;
	private String state;
}
