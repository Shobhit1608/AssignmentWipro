package com.wipro.shobhit.spring.studentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.wipro.shobhit.spring.studentapp.entities.Student;
import com.wipro.shobhit.spring.studentapp.services.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("list", studentService.getAll());
        return "index";
    }

    
    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/";
    }

   
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Student student = studentService.getById(id);
        model.addAttribute("student", student);
        model.addAttribute("list", studentService.getAll());
        return "index";
    }

    
    @GetMapping("/student/{id}")
    public String studentDetails(@PathVariable Long id, Model model) {
        Student student = studentService.getById(id);
        model.addAttribute("student", student);
        model.addAttribute("list", studentService.getAll());
        return "details";
    }

   
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        studentService.delete(id);
        return "redirect:/";
    }
}
