package com.example.questionnaire.service.ifs;

import java.util.Map;

import com.example.questionnaire.entity.Record;
import com.example.questionnaire.vo.record.AddRecordResponse;
import com.example.questionnaire.vo.record.GetAllRecordResponse;

public interface RecordService {
	
	
	public AddRecordResponse addRecord(Record record,Map<String , String> answers);
	
	public GetAllRecordResponse getAllRecord(int pageNumber);
}
