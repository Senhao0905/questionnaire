package com.example.questionnaire.vo.record;

import java.util.List;
import java.util.Map;

import com.example.questionnaire.entity.Record;

public class AddRecordRequest {

	
	private Record record ;
	
	private Map<String,  List<String>> answers ;
	
	private int pageNumber ;
	
	private int id ;
	

	public Map<String, List<String>> getAnswers() {
		return answers;
	}

	public void setAnswers(Map<String, List<String>> answers) {
		this.answers = answers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	

	
	
	
}
