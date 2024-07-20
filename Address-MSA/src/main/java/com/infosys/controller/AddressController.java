package com.infosys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entity.Address;
import com.infosys.response.AddressResponse;
import com.infosys.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@GetMapping(produces="application/json")
	public List<Address> getAll(){
		return service.get();
	}
	
	@PutMapping(value="/{id}",consumes="application/json")
	public String update(@PathVariable("id")int aid,@RequestBody Address address) {
		return service.updateAdd(aid,address);
	}
	
	@GetMapping(value="/getAddress/{id}",produces="application/json")
	public ResponseEntity<AddressResponse> getAddressByAID(@PathVariable("id")int id){
		return new ResponseEntity<AddressResponse>(service.getAddressById(id),HttpStatus.OK);
	}
}
