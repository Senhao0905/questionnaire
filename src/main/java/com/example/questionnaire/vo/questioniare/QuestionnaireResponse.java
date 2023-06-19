package com.example.questionnaire.vo.questioniare;

import com.example.questionnaire.entity.Questionnaire;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionnaireResponse {

	
	private String message;
	
	private Questionnaire questionnaire;

	public QuestionnaireResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionnaireResponse(String message) {
		super();
		this.message = message;
	}

	public QuestionnaireResponse(String message, Questionnaire questionnaire) {
		super();
		this.message = message;
		this.questionnaire = questionnaire;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	
	
}
