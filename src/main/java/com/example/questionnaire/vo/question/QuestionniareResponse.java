package com.example.questionnaire.vo.question;

import java.util.List;
import java.util.Map;

import com.example.questionnaire.entity.Question;
import com.example.questionnaire.entity.Questionnaire;

public class QuestionniareResponse {

	private String message;

	private Questionnaire questionnaire;

	private Map<Integer, Map<String, Map<String, Map<String, String>>>> resMap;

	public QuestionniareResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionniareResponse(String message) {
		super();
		this.message = message;
	}

	public QuestionniareResponse(String message, Questionnaire questionnaire,
			Map<Integer, Map<String, Map<String, Map<String, String>>>> resMap) {
		super();
		this.message = message;
		this.questionnaire = questionnaire;
		this.resMap = resMap;
	}

	// -----------------------------------------
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

	public Map<Integer, Map<String, Map<String, Map<String, String>>>> getResMap() {
		return resMap;
	}

	public void setResMap(Map<Integer, Map<String, Map<String, Map<String, String>>>> resMap) {
		this.resMap = resMap;
	}

}
