package com.example.questionnaire.vo.record;

import com.example.questionnaire.entity.Record;

public class AddRecordResponse {

	private String message;

	private Record record;

	public AddRecordResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddRecordResponse(String message) {
		super();
		this.message = message;
	}

	public AddRecordResponse(String message, Record record) {
		super();
		this.message = message;
		this.record = record;
	}

	// ---------------------------------
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

}
