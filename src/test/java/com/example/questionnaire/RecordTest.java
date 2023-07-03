package com.example.questionnaire;

import java.util.ArrayList;
import java.util.List;
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

		Record record = new Record(5, "³¯³Ó©M", "udn880905", "0986295838", 24, null);
		Map<String, List<String>> answersMap = new TreeMap<>();
		List<String> answerList = new ArrayList<>();
		List<String> noneList = new ArrayList<>();
		answerList.add("1");
		noneList.add("");
		answersMap.put("1", answerList);
		answersMap.put("2", answerList);
		answersMap.put("3", noneList);
		answersMap.put("4", answerList);
		
		recordService.addRecord(record, answersMap);
	}

	
	@Test
	public void recordTest() {
		recordService.getRecordCount(19);
	}
}
