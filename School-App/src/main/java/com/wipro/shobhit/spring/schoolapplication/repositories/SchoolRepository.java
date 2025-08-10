package com.wipro.shobhit.spring.schoolapplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wipro.shobhit.spring.schoolapplication.entities.School;

public interface SchoolRepository extends JpaRepository<School, Long> {

	School findBySchoolName(String name);

	@Query(value = "SELECT * FROM school_db WHERE school_address = :address", nativeQuery = true)
	List<School> findByAddressNative(@Param("address") String address);
	
}
