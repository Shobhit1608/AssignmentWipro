package com.wipro.shobhit.spring.schoolapplication.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teacher_db")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Teacher name is required!")
    private String teacherName;

    @NotNull(message = "Teacher address is required!")
    private String teacherAddress;

    @NotNull(message = "Qualification is required!")
    private String qualification;

    @NotNull(message = "Age is required!")
    private int age;

    
    private LocalDate dob;

    @NotNull(message = "Experience is required!")
    private int experience;

    @NotNull(message = "School ID is required!")
    private Long schoolId;
}
