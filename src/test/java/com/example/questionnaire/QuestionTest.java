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
		answersMap.put("1", "����1");
		answersMap.put("2", "����1");
		answersMap.put("3", "����1");
		answersMap.put("4", "����1");
		questionService.addQuestion(3, "�Ĥ@�D ?", "�h��", answersMap);
	}
	
	
	

}
