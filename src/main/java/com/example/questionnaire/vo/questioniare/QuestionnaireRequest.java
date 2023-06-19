package com.example.questionnaire.vo.questioniare;

import com.example.questionnaire.entity.Questionnaire;

public class QuestionnaireRequest {

	
	private Questionnaire questionnaire;
	
	private int id ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	
	
	
	
}
