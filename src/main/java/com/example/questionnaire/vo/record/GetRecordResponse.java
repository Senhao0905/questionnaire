package com.example.questionnaire.vo.record;

import java.util.List;

import com.example.questionnaire.entity.Record;

public class GetRecordResponse {

	private String message;

	private List<Record> records;

	public GetRecordResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetRecordResponse(String message) {
		super();
		this.message = message;
	}

	public GetRecordResponse(String message, List<Record> records) {
		super();
		this.message = message;
		this.records = records;
	}

	// ----------------------------------------
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

}
