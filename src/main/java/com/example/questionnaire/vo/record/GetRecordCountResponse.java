package com.example.questionnaire.vo.record;

import java.util.Map;

import com.mysql.cj.protocol.Message;

public class GetRecordCountResponse {

	private String message; 
	
	private Map<String, Map<String, Integer>> resMap ;

	public GetRecordCountResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetRecordCountResponse(String message) {
		super();
		this.message = message;
	}

	public GetRecordCountResponse(String message, Map<String, Map<String, Integer>> resMap) {
		super();
		this.message = message;
		this.resMap = resMap;
	}
//----------------------------------------------
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Map<String, Integer>> getResMap() {
		return resMap;
	}

	public void setResMap(Map<String, Map<String, Integer>> resMap) {
		this.resMap = resMap;
	}
	
	
}
