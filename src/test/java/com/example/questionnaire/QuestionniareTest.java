package com.example.questionnaire;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.questionnaire.entity.Questionnaire;
import com.example.questionnaire.repository.QuestionnaireDao;
import com.example.questionnaire.service.ifs.QuestionnaireService;



@SpringBootTest(classes = QuestionnaireApplication.class)
class QuestionniareTest {

	
	@Autowired
	private QuestionnaireService questionnaireService;

	@Autowired
	private QuestionnaireDao questionnaireDao;
	
	
	@Test
	public void addQuestionniareTest() {
		String name = "測試問卷";
		String describe = "測試問卷";
		LocalDate startDate = LocalDate.of(2023, 6, 19);
		LocalDate endDate = LocalDate.of(2023, 6, 30);
		Questionnaire questionnaire = new Questionnaire(name,describe, startDate, endDate);
		questionnaireService.addQuestionnaire(questionnaire);
	}
	
	@Test
	public void delQuestioniareTest() {
		int id = 3;
		questionnaireService.delQuestionnaire(id);
	}
	
	@Test
	public void searchByNameTest() {
		String name = "";
		LocalDate start = LocalDate.of(2023, 6, 30);
		LocalDate end = LocalDate.of(2023, 7, 02);
		questionnaireService.searchByDateOrName(name,start,end,0);
	}
	
	
	@Test
	public void searchByDateTest() {
		LocalDate startDate = LocalDate.of(2023, 6, 19);
		LocalDate endDate = LocalDate.of(2023, 6, 23);
//		List<Questionnaire> res = questionnaireDao.searchByDate(startDate, endDate);
		System.out.println();
	}
	

}
