package com.infosys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entity.Student;
import com.infosys.response.StudentResponse;
import com.infosys.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	


	
	@GetMapping(produces="application/json")
	public ResponseEntity<List> getStudent(@RequestParam("name")String namey,@RequestParam("course") String coursey){
		 List<Student> slist = service.getStudentByNandC(namey, coursey);
		 return new ResponseEntity<List>(slist,HttpStatus.OK);
	}
	

	
	@GetMapping(value="/getAll" ,produces="application/json")
	public List<Student> getAll(){
		return service.getAllS();
	}
	
	@PostMapping(consumes="application/json")
	public String addStudent(@RequestBody Student student) {
		Student student1 = new Student(10,"AAyush","mech",2);
		return service.add(student);
	}
	
	@GetMapping(value="/{id}",produces="application/json")
	public ResponseEntity<StudentResponse> get(@PathVariable("id")int sid) {
		return new ResponseEntity<StudentResponse>(service.getS(sid),HttpStatus.OK);
	}
	

}
