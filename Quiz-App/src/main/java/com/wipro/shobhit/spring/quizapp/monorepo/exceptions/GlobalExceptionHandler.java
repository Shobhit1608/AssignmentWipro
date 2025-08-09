package com.wipro.shobhit.spring.quizapp.monorepo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(QuestionNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleQuestionNotFoundException(QuestionNotFoundException ex) {
        
    	ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), "QuestionNotFoundException");
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
