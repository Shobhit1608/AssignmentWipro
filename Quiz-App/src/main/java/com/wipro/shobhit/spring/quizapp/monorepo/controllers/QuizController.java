package com.wipro.shobhit.spring.quizapp.monorepo.controllers;

import com.wipro.shobhit.spring.quizapp.monorepo.entities.QuestionWrapper;
import com.wipro.shobhit.spring.quizapp.monorepo.entities.Quiz;
import com.wipro.shobhit.spring.quizapp.monorepo.entities.Response;
import com.wipro.shobhit.spring.quizapp.monorepo.services.QuizService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/quiz")
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/create")
    public Quiz createQuiz(
            @RequestParam String category,
            @RequestParam String level,
            @RequestParam String title) {
        return quizService.createQuiz(category, level, title);
    }

    @GetMapping("/getQuizByID/{id}")
    public List<QuestionWrapper> getQuizQuestions(@PathVariable Long id) {
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/submitQuiz/{id}")
    public Integer submitQuiz(
            @PathVariable Long id,
            @RequestBody List<Response> responses) {
        return quizService.calculateResult(id, responses);
    }
}
