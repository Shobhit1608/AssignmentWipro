package com.wipro.shobhit.spring.schoolapplication.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.shobhit.spring.schoolapplication.entities.School;
import com.wipro.shobhit.spring.schoolapplication.entities.Teacher;
import com.wipro.shobhit.spring.schoolapplication.repositories.SchoolRepository;
import com.wipro.shobhit.spring.schoolapplication.repositories.TeacherRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public School getSchoolById(Long id) {
        School school = schoolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("School not found with ID: " + id));
        List<Teacher> teachers = teacherRepository.findBySchoolId(school.getId());
        school.setTeachers(teachers);
        return school;
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public Page<School> getAllSchoolsPage(Pageable pageable) {
        return schoolRepository.findAll(pageable);
    }

    @Override
    public void deleteSchool(Long id) {
        if (!schoolRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete. School not found with ID: " + id);
        }
        schoolRepository.deleteById(id);
    }

    @Override
    public School updateSchoolById(Long id, School school) {
        School existing = getSchoolById(id);
        existing.setSchoolName(school.getSchoolName());
        existing.setSchoolAddress(school.getSchoolAddress());
        return schoolRepository.save(existing);
    }

    @Override
    public School patchupdateSchoolById(Long id, School school) {
        School existing = getSchoolById(id);
        if (school.getSchoolName() != null) {
            existing.setSchoolName(school.getSchoolName());
        }
        if (school.getSchoolAddress() != null) {
            existing.setSchoolAddress(school.getSchoolAddress());
        }
        return schoolRepository.save(existing);
    }

    @Override
    public School getSchoolByName(String name) {
        return schoolRepository.findBySchoolName(name);
    }

    @Override
    public List<School> getSchoolByAddress(String address) {
        return schoolRepository.findByAddressNative(address);
    }
}
