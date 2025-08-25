package com.wipro.shobhit.spring.quizapp.monorepo.services;

import java.util.List;

import com.wipro.shobhit.spring.quizapp.monorepo.entities.QuestionWrapper;
import com.wipro.shobhit.spring.quizapp.monorepo.entities.Quiz;
import com.wipro.shobhit.spring.quizapp.monorepo.entities.Response;

public interface QuizService {

	Quiz createQuiz(String category, String level, String title);

	List<QuestionWrapper> getQuizQuestions(Long id);
	Integer calculateResult(Long id, List<Response> responses);

}
