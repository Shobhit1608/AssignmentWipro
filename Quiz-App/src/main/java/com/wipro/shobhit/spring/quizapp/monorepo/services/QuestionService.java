package com.wipro.shobhit.spring.quizapp.monorepo.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.shobhit.spring.quizapp.monorepo.entities.Question;

import jakarta.validation.Valid;

public interface QuestionService {

	Question saveQuestion(@Valid Question question);

	Question getQuestionById(Long id);

	Page<Question> findAllQuestions(Pageable pageable);

	void deleteQuestionById(Long id);

	Question updateQuestionById(Long id, Question question);


}
