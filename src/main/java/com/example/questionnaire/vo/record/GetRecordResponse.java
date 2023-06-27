package com.example.questionnaire.vo.record;

import java.util.List;
import java.util.Map;

import com.example.questionnaire.entity.Record;

public class GetRecordResponse {

	private String message;

	private List<Record> records;
	
	private Record record ;
	
	private Map<String,  List<String>> answers;

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

	
	public GetRecordResponse(String message, Record record) {
		super();
		this.message = message;
		this.record = record;
	}

	
	
	public GetRecordResponse(String message, Record record, Map<String, List<String>> answers) {
		super();
		this.message = message;
		this.record = record;
		this.answers = answers;
	}

	// ----------------------------------------
	
	
	

	public String getMessage() {
		return message;
	}

	public Map<String, List<String>> getAnswers() {
		return answers;
	}

	public void setAnswers(Map<String, List<String>> answers) {
		this.answers = answers;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
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
