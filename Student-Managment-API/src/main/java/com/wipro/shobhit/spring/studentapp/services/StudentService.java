package com.wipro.shobhit.spring.studentapp.services;

import java.util.List;

import com.wipro.shobhit.spring.studentapp.entities.Student;

public interface StudentService {

	    List<Student> getAll();

	    void save(Student student);

	    Student getById(Long id);

	    void delete(Long id);

}
