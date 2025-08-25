package com.wipro.shobhit.spring.schoolapplication.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.shobhit.spring.schoolapplication.entities.Teacher;
import com.wipro.shobhit.spring.schoolapplication.repositories.TeacherRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found with id: " + id));
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Page<Teacher> getAllTeachersPage(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }

    @Override
    public void deleteTeacherById(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new EntityNotFoundException("Cannot delete, teacher not found with id: " + id);
        }
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher updateTeacherById(Long id, Teacher updatedTeacher) {
        Teacher existing = getTeacherById(id);
        existing.setTeacherName(updatedTeacher.getTeacherName());
        existing.setTeacherAddress(updatedTeacher.getTeacherAddress());
        existing.setQualification(updatedTeacher.getQualification());
        existing.setAge(updatedTeacher.getAge());
        existing.setDob(updatedTeacher.getDob());
        existing.setExperience(updatedTeacher.getExperience());
        existing.setSchoolId(updatedTeacher.getSchoolId());
        return teacherRepository.save(existing);
    }

    @Override
    public Teacher patchUpdateTeacherById(Long id, Teacher updatedTeacher) {
        Teacher existing = getTeacherById(id);
        if (updatedTeacher.getTeacherName() != null)
            existing.setTeacherName(updatedTeacher.getTeacherName());
        if (updatedTeacher.getTeacherAddress() != null)
            existing.setTeacherAddress(updatedTeacher.getTeacherAddress());
        if (updatedTeacher.getQualification() != null)
            existing.setQualification(updatedTeacher.getQualification());
        if (updatedTeacher.getAge() != 0)
            existing.setAge(updatedTeacher.getAge());
        if (updatedTeacher.getDob() != null)
            existing.setDob(updatedTeacher.getDob());
        if (updatedTeacher.getExperience() != 0)
            existing.setExperience(updatedTeacher.getExperience());
        if (updatedTeacher.getSchoolId() != null)
            existing.setSchoolId(updatedTeacher.getSchoolId());
        return teacherRepository.save(existing);
    }

    @Override
    public List<Teacher> findTeachersByName(String name) {
        return teacherRepository.findByTeacherName(name);
    }

    @Override
    public List<Teacher> findByQualification(String qualification) {
        return teacherRepository.findByQualification(qualification);
    }
}
