package com.wipro.shobhit.spring.studentapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.shobhit.spring.studentapp.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
