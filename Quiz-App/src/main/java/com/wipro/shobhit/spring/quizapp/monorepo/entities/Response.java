package com.wipro.shobhit.spring.quizapp.monorepo.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {
    private final int id; 
    private final String userAnswer; 
}
