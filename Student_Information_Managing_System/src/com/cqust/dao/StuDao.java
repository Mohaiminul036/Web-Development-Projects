package com.cqust.dao;



import java.util.List;

import com.cqust.domain.Student;

public interface StuDao {
	/**
	 * get all student information
	 * @return  List<Student>
	 */
	List<Student> findAll();


	boolean addStudent(String name,int age,String address,String gender);
	
}
