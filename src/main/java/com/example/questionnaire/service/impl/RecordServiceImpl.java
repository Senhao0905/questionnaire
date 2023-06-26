package com.example.questionnaire.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.aspectj.weaver.loadtime.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.questionnaire.constant.RtnCode;
import com.example.questionnaire.entity.Question;
import com.example.questionnaire.entity.Questionnaire;
import com.example.questionnaire.entity.Record;
import com.example.questionnaire.repository.QuestionDao;
import com.example.questionnaire.repository.QuestionnaireDao;
import com.example.questionnaire.repository.RecordDao;
import com.example.questionnaire.service.ifs.QuestionService;
import com.example.questionnaire.service.ifs.RecordService;
import com.example.questionnaire.vo.question.AddQuestionResponse;
import com.example.questionnaire.vo.question.DelQuestionResponse;
import com.example.questionnaire.vo.questioniare.SearchQuestionnaireResponse;
import com.example.questionnaire.vo.record.AddRecordResponse;
import com.example.questionnaire.vo.record.GetAllRecordResponse;
import com.example.questionnaire.vo.record.GetRecordResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordDao recordDao;

	@Autowired
	private QuestionnaireDao questionnaireDao;

	@Override
	public AddRecordResponse addRecord(Record record, Map<String,  List<String>> answers) {

		boolean res = questionnaireDao.existsById(record.getQuestionnaireId());

		if (!res) {
			return new AddRecordResponse(RtnCode.NOT_FOUND.getMessage());
		}

		if (!StringUtils.hasText(record.getName())) {
			return new AddRecordResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		if (!StringUtils.hasText(record.getEmail())) {
			return new AddRecordResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		if (!StringUtils.hasText(record.getPhone())) {
			return new AddRecordResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		if (record.getAge() < 0) {
			return new AddRecordResponse(RtnCode.DATA_ERROR.getMessage());
		}

		for (Entry<String,  List<String>> item : answers.entrySet()) {
			if (!StringUtils.hasText(item.getKey())) {
				return new AddRecordResponse(RtnCode.CANNOT_EMPTY.getMessage());
			}

			if (CollectionUtils.isEmpty(item.getValue())) {
				return new AddRecordResponse(RtnCode.CANNOT_EMPTY.getMessage());
			}
		}

		String answreStr = mapToString(answers);

		record.setAnswer(answreStr);

		return new AddRecordResponse(RtnCode.SUCCESSFUL.getMessage(), recordDao.save(record));

	}

	@Override
	public GetAllRecordResponse getAllRecord(int pageNumber) {
		// 判斷頁數是否超過
		List<Record> total = recordDao.findAll();
		// 目前頁數（從 0 開始）
		int pageSize = 2; // 每頁顯示的項目數量

		int maxPage = total.size() < pageSize ? 0 : (total.size()%pageSize==0) ? (total.size() / pageSize)-1  :total.size() / pageSize ;

		if (pageNumber > maxPage) {
			return new GetAllRecordResponse(RtnCode.ERROR.getMessage());
		}

		Sort sort = Sort.by("seq").ascending();

		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

		Page<Record> page = recordDao.findAll(pageable);

		List<Record> res = page.getContent();
		
		return new GetAllRecordResponse(RtnCode.SUCCESSFUL.getMessage(), page);
	}
	
	@Override
	public GetRecordResponse getRecord(int id) {
		
		List<Record> res = recordDao.findAllByQuestionnaireId(id);
		
		if(CollectionUtils.isEmpty(res)) {
			return new GetRecordResponse(RtnCode.NOT_FOUND.getMessage());
		}
		return new GetRecordResponse(RtnCode.SUCCESSFUL.getMessage(),res);
	}

//	抽方法 
	private String mapToString(Map<String,  List<String>> answers) {

		// change map to string
		ObjectMapper mapper = new ObjectMapper();

		String answersStr = "";

		try {
			answersStr = mapper.writeValueAsString(answers);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return answersStr;
	}

	

}
