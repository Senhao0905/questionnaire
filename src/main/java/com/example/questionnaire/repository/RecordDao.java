package com.example.questionnaire.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.example.questionnaire.entity.Record;


@Repository
public interface RecordDao extends JpaRepository<Record, Integer> {

	
	
}
