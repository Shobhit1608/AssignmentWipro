package com.wipro.shobhit.spring.quizapp.monorepo.controllers;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.shobhit.spring.quizapp.monorepo.entities.Question;
import com.wipro.shobhit.spring.quizapp.monorepo.services.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/question")
public class QuestionController {

	private final QuestionService questionService;
	
	//Create
	
    @PostMapping("/addNewQuestion")
    public Question addQuestion(@Valid @RequestBody Question question) {
        log.info("This question is coming from Postman: {}", question);
        return questionService.saveQuestion(question);
    }
	
    //Read
    
    @GetMapping("/getQuestionById/{id}")
    public Question getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }
    
    //Retrive
    
    @GetMapping("/getAllQuestionsPage")
    public Page<Question> getAllQuestionsPage(Pageable pageable) {
        return questionService.findAllQuestions(pageable);
    }
    
    //Delete
    
    @DeleteMapping("/deleteQuestionById/{id}")
    public void deleteQuestionById(@PathVariable Long id) {
        questionService.deleteQuestionById(id);
    }
    
    //Update
    
    @PatchMapping("/updateQuestionById/{id}")
    public Question updateQuestionById(@PathVariable Long id, @RequestBody Question question) {
        return questionService.updateQuestionById(id, question);
    }
    
}
