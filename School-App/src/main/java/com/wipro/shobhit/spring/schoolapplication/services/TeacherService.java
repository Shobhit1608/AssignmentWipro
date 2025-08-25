package com.wipro.shobhit.spring.schoolapplication.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.shobhit.spring.schoolapplication.entities.Teacher;

import jakarta.validation.Valid;

public interface TeacherService {

	Teacher saveTeacher(@Valid Teacher teacher);

	Teacher getTeacherById(Long id);

	List<Teacher> getAllTeachers();

	Page<Teacher> getAllTeachersPage(Pageable pageable);

	void deleteTeacherById(Long id);

	Teacher updateTeacherById(Long id, Teacher teacher);

	Teacher patchUpdateTeacherById(Long id, Teacher teacher);

	List<Teacher> findTeachersByName(String name);

	List<Teacher> findByQualification(String qualification);
	
	

}
