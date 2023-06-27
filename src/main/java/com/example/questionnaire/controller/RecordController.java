package com.example.questionnaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnaire.service.ifs.RecordService;
import com.example.questionnaire.vo.record.AddRecordRequest;
import com.example.questionnaire.vo.record.AddRecordResponse;
import com.example.questionnaire.vo.record.GetAllRecordResponse;
import com.example.questionnaire.vo.record.GetRecordCountResponse;
import com.example.questionnaire.vo.record.GetRecordResponse;

@CrossOrigin
@RestController
public class RecordController {

	@Autowired
	private RecordService recordService;

	@PostMapping(value = "add_record")
	public AddRecordResponse addRecord(@RequestBody AddRecordRequest request) {
		return recordService.addRecord(request.getRecord(), request.getAnswers());
	}
	
	@PostMapping(value = "get_all_record")
	public GetAllRecordResponse getAllRecord(@RequestBody AddRecordRequest request) {
		return recordService.getAllRecord(request.getPageNumber());
	}
	
	@PostMapping(value = "get_record")
	public GetRecordResponse getRecord(@RequestBody AddRecordRequest request) {
		return recordService.getRecord(request.getId());
	}
	
	@PostMapping(value = "get_record_info")
	public GetRecordResponse getRecordInfo(@RequestBody AddRecordRequest request) {
		return recordService.getRecordInfo(request.getSeq());
	}
	
	@PostMapping(value = "get_record_count")
	public GetRecordCountResponse getRecordCount(@RequestBody AddRecordRequest request) {
		return recordService.getRecordCount(request.getSeq());
	}
	

}
