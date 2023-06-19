package com.example.questionnaire.vo.question;

import com.example.questionnaire.entity.Question;

public class AddQuestionResponse {

	private String message;
	
	private Question question;

	public AddQuestionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddQuestionResponse(String message) {
		super();
		this.message = message;
	}

	public AddQuestionResponse(String message, Question question) {
		super();
		this.message = message;
		this.question = question;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
}
