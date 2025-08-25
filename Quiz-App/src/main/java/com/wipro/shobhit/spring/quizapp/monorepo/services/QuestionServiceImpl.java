package com.wipro.shobhit.spring.quizapp.monorepo.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.shobhit.spring.quizapp.monorepo.entities.Question;
import com.wipro.shobhit.spring.quizapp.monorepo.exceptions.QuestionNotFoundException;
import com.wipro.shobhit.spring.quizapp.monorepo.repositories.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService{
	
    private final QuestionRepository questionRepository;

	@Override
	public Question saveQuestion(Question question) {
		 return questionRepository.save(question);
	}

	@Override
	public Question getQuestionById(Long id) {
		return questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found with ID: " + id));
	}

	@Override
	public Page<Question> findAllQuestions(Pageable pageable) {
		return questionRepository.findAll(pageable);
	}

	@Override
	public void deleteQuestionById(Long id) {
		Question existing = getQuestionById(id);
        questionRepository.delete(existing);
		
	}

	@Override
	public Question updateQuestionById(Long id, Question question) {
	    Question existingQuestion = questionRepository.findById(id)
	            .orElseThrow(() -> new QuestionNotFoundException("Question with that ID is not present: " + id));

	    if (question.getQuestionTitle() != null) {
	        existingQuestion.setQuestionTitle(question.getQuestionTitle());
	    }
	    if (question.getOption1() != null) {
	        existingQuestion.setOption1(question.getOption1());
	    }
	    if (question.getOption2() != null) {
	        existingQuestion.setOption2(question.getOption2());
	    }
	    if (question.getOption3() != null) {
	        existingQuestion.setOption3(question.getOption3());
	    }
	    if (question.getOption4() != null) {
	        existingQuestion.setOption4(question.getOption4());
	    }
	    if (question.getCorrectAnswer() != null) {
	        existingQuestion.setCorrectAnswer(question.getCorrectAnswer());
	    }
	    if (question.getCategory() != null) {
	        existingQuestion.setCategory(question.getCategory());
	    }
	    if (question.getLevel() != null) {
	        existingQuestion.setLevel(question.getLevel());
	    }

	    return questionRepository.save(existingQuestion);
	}


	
	
}
