package com.wipro.shobhit.spring.quizapp.monorepo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect 
@Component 
@Slf4j
public class QuizAppAspect {

    // This will run before addQuestion() method in QuestionController
    @Before("execution(* com.wipro.shobhit.spring.quizapp.monorepo.controllers.QuestionController.addQuestion(..))")
    public void logBeforeAddQuestion(JoinPoint joinPoint) {
        log.warn("Logging before calling addNewQuestion endpoint");
        log.info("Method being called: {}", joinPoint.getSignature().getName());
    }
   
    @Before("execution(* com.wipro.shobhit.spring.quizapp.monorepo.controllers.QuestionController.deleteQuestionById(..))")
    public void logBeforeDeleteQuestion(JoinPoint joinPoint) {
        log.warn("Logging before calling deleteQuestionById endpoint");
        log.info("Method being called: {}", joinPoint.getSignature().getName());
    }
}