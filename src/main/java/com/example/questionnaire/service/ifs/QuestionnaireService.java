package com.example.questionnaire.service.ifs;

import java.time.LocalDate;

import com.example.questionnaire.entity.Questionnaire;
import com.example.questionnaire.vo.questioniare.QuestionnaireResponse;
import com.example.questionnaire.vo.questioniare.SearchQuestionnaireResponse;

public interface QuestionnaireService {

	public QuestionnaireResponse addQuestionnaire(Questionnaire questionnaire);

	public QuestionnaireResponse delQuestionnaire(int id);

	public QuestionnaireResponse updateQuestionnaire(Questionnaire questionnaire);
	
	public SearchQuestionnaireResponse getAllQuestioniare(int pageNumber);
	
	public SearchQuestionnaireResponse searchByNameContaining(String name);
	
	public SearchQuestionnaireResponse searchByDate(LocalDate startDate , LocalDate endDate);
		
}
