package com.example.questionnaire.vo.question;

import com.example.questionnaire.entity.Question;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class DelQuestionResponse {

	private String message;

	private Question question;

	public DelQuestionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DelQuestionResponse(String message) {
		super();
		this.message = message;
	}

	public DelQuestionResponse(String message, Question question) {
		super();
		this.message = message;
		this.question = question;
	}

	// --------------------------------------
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
