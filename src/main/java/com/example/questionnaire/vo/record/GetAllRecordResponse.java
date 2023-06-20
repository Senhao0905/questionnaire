package com.example.questionnaire.vo.record;

import org.springframework.data.domain.Page;

import com.example.questionnaire.entity.Questionnaire;
import com.example.questionnaire.entity.Record;

public class GetAllRecordResponse {

	private String message;

	private Page<Record> page;

	public GetAllRecordResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetAllRecordResponse(String message) {
		super();
		this.message = message;
	}

	public GetAllRecordResponse(String message, Page<Record> page) {
		super();
		this.message = message;
		this.page = page;
	}

	// ----------------------------------
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Page<Record> getPage() {
		return page;
	}

	public void setPage(Page<Record> page) {
		this.page = page;
	}

}
