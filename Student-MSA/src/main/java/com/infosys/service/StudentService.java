package com.infosys.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infosys.entity.Student;
import com.infosys.feignclient.AddressClient;
import com.infosys.repository.StudentRepository;
import com.infosys.response.AddressResponse;
import com.infosys.response.StudentResponse;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository srepo;
	
	@Autowired
	private AddressClient aClient;
	
	@Autowired
	private ModelMapper mapper;
	
	public String add(Student student) {
		srepo.save(student);
		return "inserted";
	}
	
	public List<Student> getStudentByNandC(String name,String course){
		 
		return  srepo.getStudent(name,course);
	}
	
	public StudentResponse getS(int id) {
		Student s = srepo.findById(id).get();
		int aid = s.getAddressId();
		ResponseEntity<AddressResponse> a = aClient.getAddressByAID(aid);
		StudentResponse sr = mapper.map(s, StudentResponse.class);
		sr.setAddressResponse(a.getBody());
		return sr;
	}
	
	public List<Student> getAllS(){
		return srepo.findAll();
	}
}
