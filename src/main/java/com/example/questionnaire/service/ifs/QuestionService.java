package com.example.questionnaire.service.ifs;


import java.util.Map;


import com.example.questionnaire.vo.question.AddQuestionResponse;
import com.example.questionnaire.vo.question.DelQuestionResponse;
import com.example.questionnaire.vo.question.QuestionniareResponse;

public interface QuestionService {
	
	public AddQuestionResponse addQuestion(int questionnaireId
			,String name ,String type , Map<String, String> answers);
	
	public DelQuestionResponse delQuestion(int seq);
	
	
	public AddQuestionResponse updateQuestion(int seq ,int questionnaireId
			,String name ,String type , Map<String, String> answers);
	
	public QuestionniareResponse questionniareRes(int id );
}
