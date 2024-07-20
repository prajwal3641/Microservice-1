package com.infosys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
	
	@Query(value="select *from student s where s.name=? or s.course=?",nativeQuery=true)
	public List<Student> getStudent(String name,String course);
}
