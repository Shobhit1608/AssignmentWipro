package com.wipro.shobhit.spring.quizapp.monorepo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.shobhit.spring.quizapp.monorepo.entities.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long> {

	

}
