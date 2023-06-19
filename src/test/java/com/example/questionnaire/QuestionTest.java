package com.example.questionnaire;



import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.questionnaire.repository.QuestionDao;

import com.example.questionnaire.service.ifs.QuestionService;




@SpringBootTest(classes = QuestionnaireApplication.class)
class QuestionTest {

	
	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuestionDao questionDao;
	
	
	@Test
	public void addQuestionTest() {
		Map<String, String> answersMap = new TreeMap<>();
		answersMap.put("1", "答案1");
		answersMap.put("2", "答案1");
		answersMap.put("3", "答案1");
		answersMap.put("4", "答案1");
		questionService.addQuestion(3, "第一題 ?", "多選", answersMap);
	}
	
	
	

}
