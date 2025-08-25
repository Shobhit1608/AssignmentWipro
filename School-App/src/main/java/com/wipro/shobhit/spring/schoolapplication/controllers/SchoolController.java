package com.wipro.shobhit.spring.schoolapplication.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.shobhit.spring.schoolapplication.entities.School;
import com.wipro.shobhit.spring.schoolapplication.services.SchoolService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SchoolController {

	private final SchoolService schoolService;
		
	@PostMapping("/addNewSchool")
    public School addSchool(@Valid @RequestBody School school) {
        return schoolService.saveSchool(school);
    }
	
	 @GetMapping("/getSchoolById/{id}")
	    public School getSchoolById(@PathVariable Long id) {
	        return schoolService.getSchoolById(id);
	    }
	 
	 @GetMapping("/getAllSchools")
	    public List<School> getAllSchools() {
	        return schoolService.getAllSchools();
	    }
	 
	  @GetMapping("/getAllSchoolsPage")
	    public Page<School> getAllSchoolsPage(Pageable pageable) {
	        return schoolService.getAllSchoolsPage(pageable);
	    }
	  
	  @DeleteMapping("/deleteSchoolById/{id}")
	    public void deleteSchool(@PathVariable Long id) {
	        schoolService.deleteSchool(id);
	    }
	  
	  @PutMapping("/updateSchoolById/{id}")
	    public School updateSchoolById(@PathVariable Long id, @RequestBody School school) {
	        return schoolService.updateSchoolById(id, school);
	    }
	  
	  @PatchMapping("/patchUpdateSchoolById/{id}")
	    public School patchUpdateSchoolById(@PathVariable Long id, @RequestBody School school) {
	        return schoolService.patchupdateSchoolById(id, school);
	    }

	    @GetMapping("/checkSchoolByName/{name}")
	    public School getSchoolByName(@PathVariable String name) {
	        return schoolService.getSchoolByName(name);
	    }

	    @GetMapping("/checkSchoolsByAddress/{address}")
	    public List<School> getSchoolsByAddress(@PathVariable String address) {
	        return schoolService.getSchoolByAddress(address);
	    }
}
	