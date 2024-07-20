package com.infosys.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.infosys.response.AddressResponse;

@FeignClient(name="Address-MSA",url="http://localhost:8081",path="/address-service")
public interface AddressClient {
	@GetMapping("/getAddress/{id}")
	public ResponseEntity<AddressResponse> getAddressByAID(@PathVariable("id")int id);
}
