package com.example.questionnaire;

import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.questionnaire.entity.Record;
import com.example.questionnaire.repository.RecordDao;

import com.example.questionnaire.service.ifs.RecordService;

@SpringBootTest(classes = QuestionnaireApplication.class)
class RecordTest {

	@Autowired
	private RecordService recordService;

	@Autowired
	private RecordDao recordDao;

	@Test
	public void addRecordTest() {

		Record record = new Record(5, "陳勝和", "udn880905", "0986295838", 24, null);
		Map<String, String> answersMap = new TreeMap<>();
		answersMap.put("1", "答案1");
		answersMap.put("2", "答案1");
		answersMap.put("3", "答案1");
		answersMap.put("4", "答案1");
		
		recordService.addRecord(record, answersMap);
	}

}
