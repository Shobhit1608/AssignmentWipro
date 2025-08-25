package com.wipro.shobhit.spring.quizapp.monorepo.entities;

import com.wipro.shobhit.spring.quizapp.monorepo.enums.Category;
import com.wipro.shobhit.spring.quizapp.monorepo.enums.DifficultyLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @NotBlank(message = "Question title is required")
    private String questionTitle;

    private String option1;
    private String option2;
    private String option3;
    private String option4;

    @NotBlank(message = "Correct answer is required")
    private String correctAnswer;

    @NotNull(message = "Category is required")
    private Category category;

    @NotNull(message = "Difficulty level is required")
    private DifficultyLevel level;

	
}
