package com.example.questionnaire.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.questionnaire.entity.Questionnaire;

@Repository
public interface QuestionnaireDao extends JpaRepository<Questionnaire, Integer> {

	
	public Page<Questionnaire> findByNameContaining(String name ,Pageable pageable);
	
	
	@Query(value = "SELECT * FROM questionnaire WHERE start >= :startDate and end <= :endDate",nativeQuery = true)
	public Page<Questionnaire> searchByDate(
			@Param("startDate")LocalDate startDate,
			@Param("endDate")LocalDate endDate,
			Pageable pageable);
}
