package com.infosys.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entity.Address;
import com.infosys.repository.AddressRepository;
import com.infosys.response.AddressResponse;

@Service
public class AddressService {
	@Autowired
	private AddressRepository arepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public List<Address> get(){
		return (List)arepo.findAll();
	}
	
	public String updateAdd(int id,Address a) {
		Address a1 = arepo.findById(id).get();
		a1.setCity(a.getCity());
		a1.setState(a.getState());
		arepo.save(a1);
		return "Updated Successfully";
		
	}
	
	public AddressResponse getAddressById(int id) {
		Address a1 = arepo.findById(id).get();
		AddressResponse aResponse = modelMapper.map(a1, AddressResponse.class);
		return aResponse;
	}
}
