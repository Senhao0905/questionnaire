package com.example.questionnaire.service.ifs;

import java.util.List;
import java.util.Map;

import com.example.questionnaire.entity.Question;
import com.example.questionnaire.vo.question.AddQuestionResponse;

public interface QuestionService {
	
	public AddQuestionResponse addQuestion(int questionnaireId
			,String name ,String type , Map<String, String> answers);
	
	
		
}
