package com.wipro.shobhit.spring.schoolapplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wipro.shobhit.spring.schoolapplication.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	List<Teacher> findByTeacherName(String name);

	List<Teacher> findByQualification(String qualification);

    List<Teacher> findByTeacherNameIgnoreCase(String name);

    List<Teacher> findByQualificationIgnoreCase(String qualification);

    List<Teacher> findByTeacherNameContainingIgnoreCase(String keyword);
    
    @Query(value = "SELECT * FROM teacher_db WHERE school_id = ?1", nativeQuery = true)
    List<Teacher> findTeachersBySchoolId(Long schoolId);

	List<Teacher> findBySchoolId(Long id);
}
