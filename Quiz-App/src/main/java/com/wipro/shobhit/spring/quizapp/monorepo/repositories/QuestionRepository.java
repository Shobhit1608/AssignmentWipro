package com.wipro.shobhit.spring.quizapp.monorepo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.shobhit.spring.quizapp.monorepo.entities.Question;
import com.wipro.shobhit.spring.quizapp.monorepo.enums.Category;
import com.wipro.shobhit.spring.quizapp.monorepo.enums.DifficultyLevel;



@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
  
  
	@Query(value = "SELECT * FROM question q WHERE q.category = ?1 AND q.level = ?2 ORDER BY RANDOM() LIMIT 3", nativeQuery = true)
	  List<Question> findRandomByCategoryAndDifficulty(Category category, DifficultyLevel level);
	List<Question> findByCategory(Category category);
	
}

