package com.example.questionnaire.vo.questioniare;

import java.util.List;

import com.example.questionnaire.entity.Questionnaire;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchQuestionnaireResponse {

	private String message;
	
	private List<Questionnaire> questionnaires;

	public SearchQuestionnaireResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchQuestionnaireResponse(String message) {
		super();
		this.message = message;
	}

	public SearchQuestionnaireResponse(String message, List<Questionnaire> questionnaires) {
		super();
		this.message = message;
		this.questionnaires = questionnaires;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Questionnaire> getQuestionnaires() {
		return questionnaires;
	}

	public void setQuestionnaires(List<Questionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}

}
