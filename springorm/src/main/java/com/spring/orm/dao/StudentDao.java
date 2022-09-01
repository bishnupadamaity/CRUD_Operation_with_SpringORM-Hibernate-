package com.spring.orm.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplates;
	
//	********************************************************************************************
	// save student
	@Transactional
	public int insert(Student student) {
		
		Integer i =(Integer) this.hibernateTemplates.save(student);
		
		return i;
	}

	// get the single data object
	public Student getStudent(int studentId) {
		
		
		Student student = this.hibernateTemplates.get(Student.class, studentId);
		
		return student;
	}
	
	// get all student;
	
	public List<Student> getAllStudents(){
		
		List<Student> students = this.hibernateTemplates.loadAll(Student.class);
		
		return students;
	}
	
	// delete rows
	@Transactional
	public void deleteStudent(int studentId) {
		
		Student student = this.hibernateTemplates.get(Student.class,studentId);
		
		this.hibernateTemplates.delete(student);
		
	}
	
	// updating data
	@Transactional
	public void updateStudent(Student student) {
		
		this.hibernateTemplates.update(student);
	}
	
	
	
//	************************************************************
	
	

	public HibernateTemplate getHibernateTemplates() {
		return hibernateTemplates;
	}


	public void setHibernateTemplates(HibernateTemplate hibernateTemplates) {
		this.hibernateTemplates = hibernateTemplates;
	}
	
	// 
	

}
