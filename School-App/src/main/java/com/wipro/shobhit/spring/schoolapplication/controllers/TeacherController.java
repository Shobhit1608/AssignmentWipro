package com.wipro.shobhit.spring.schoolapplication.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.wipro.shobhit.spring.schoolapplication.entities.Teacher;
import com.wipro.shobhit.spring.schoolapplication.services.TeacherService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/addNewTeacher")
    public Teacher addTeacher(@Valid @RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher);
    }

    @GetMapping("/getTeacherById/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/getAllTeachers")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/getAllTeachersPage")
    public Page<Teacher> getAllTeachersPage(Pageable pageable) {
        return teacherService.getAllTeachersPage(pageable);
    }

    @DeleteMapping("/deleteTeacherById/{id}")
    public void deleteTeacherById(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
    }

    @PutMapping("/updateTeacherById/{id}")
    public Teacher updateTeacherById(@PathVariable Long id, @RequestBody Teacher teacher) {
        return teacherService.updateTeacherById(id, teacher);
    }

    @PatchMapping("/patchUpdateTeacherById/{id}")
    public Teacher patchUpdateTeacherById(@PathVariable Long id, @RequestBody Teacher teacher) {
        return teacherService.patchUpdateTeacherById(id, teacher);
    }

    @GetMapping("/checkTeachersByName/{name}")
    public List<Teacher> checkTeachersByName(@PathVariable String name) {
        return teacherService.findTeachersByName(name);
    }

    @GetMapping("/checkTeachersByQualification/{qualification}")
    public List<Teacher> checkTeachersByQualification(@PathVariable String qualification) {
        return teacherService.findByQualification(qualification);
    }
}
