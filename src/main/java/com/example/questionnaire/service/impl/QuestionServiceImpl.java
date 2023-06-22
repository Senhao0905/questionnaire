package com.example.questionnaire.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;

import com.example.questionnaire.constant.RtnCode;
import com.example.questionnaire.entity.Question;
import com.example.questionnaire.entity.Questionnaire;
import com.example.questionnaire.repository.QuestionDao;
import com.example.questionnaire.repository.QuestionnaireDao;
import com.example.questionnaire.service.ifs.QuestionService;

import com.example.questionnaire.vo.question.AddQuestionResponse;
import com.example.questionnaire.vo.question.DelQuestionResponse;
import com.example.questionnaire.vo.question.QuestionniareResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao questionDao;

	@Autowired
	private QuestionnaireDao questionnaireDao;

	@Override
	public AddQuestionResponse addQuestion(int questionnaireId, String name, String type, Map<String, String> answers) {

		boolean res = questionnaireDao.existsById(questionnaireId);

		if (!res) {
			return new AddQuestionResponse(RtnCode.NOT_FOUND.getMessage());
		}

		if (!StringUtils.hasText(name)) {
			return new AddQuestionResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		if (!StringUtils.hasText(type)) {
			return new AddQuestionResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		for (Entry<String, String> item : answers.entrySet()) {
			if (!StringUtils.hasText(item.getKey())) {
				return new AddQuestionResponse(RtnCode.CANNOT_EMPTY.getMessage());
			}

			if (!StringUtils.hasText(item.getValue())) {
				return new AddQuestionResponse(RtnCode.CANNOT_EMPTY.getMessage());
			}
		}

		String answerStr = mapToString(answers);

		Question resQuestion = new Question(questionnaireId, name, type, answerStr);

		return new AddQuestionResponse(RtnCode.SUCCESSFUL.getMessage(), questionDao.save(resQuestion));
	}

	@Override
	public DelQuestionResponse delQuestion(int seq) {
		boolean res = questionDao.existsById(seq);

		if (!res) {
			return new DelQuestionResponse(RtnCode.NOT_FOUND.getMessage());
		}

		questionDao.deleteById(seq);

		return new DelQuestionResponse(RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public AddQuestionResponse updateQuestion(int seq, int questionnaireId, String name, String type,
			Map<String, String> answers) {

		if (!questionDao.existsById(seq)) {
			return new AddQuestionResponse(RtnCode.NOT_FOUND.getMessage());
		}

		if (!questionnaireDao.existsById(questionnaireId)) {
			return new AddQuestionResponse(RtnCode.NOT_FOUND.getMessage());
		}

		if (!StringUtils.hasText(name)) {
			return new AddQuestionResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		if (!StringUtils.hasText(type)) {
			return new AddQuestionResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		for (Entry<String, String> item : answers.entrySet()) {
			if (!StringUtils.hasText(item.getKey())) {
				return new AddQuestionResponse(RtnCode.CANNOT_EMPTY.getMessage());
			}

			if (!StringUtils.hasText(item.getValue())) {
				return new AddQuestionResponse(RtnCode.CANNOT_EMPTY.getMessage());
			}
		}

		String answerStr = mapToString(answers);

		Question resQuestion = new Question(seq, questionnaireId, name, type, answerStr);

		return new AddQuestionResponse(RtnCode.SUCCESSFUL.getMessage(), questionDao.save(resQuestion));

	}

	@Override
	public QuestionniareResponse questionniareRes(int id) {

		Optional<Questionnaire> op = questionnaireDao.findById(id);
		Questionnaire qusetionniare = op.get();

		List<Question> res = questionDao.findByQuestionnaireId(id);
		
		Map<Integer,Map<String,Map<String, Map<String, String>>>> realMap= new TreeMap<>();
		int index = 1 ;
		for(Question item : res) {
			Map<String, Map<String, String>> resMap = new TreeMap<>();
			Map<String,Map<String, Map<String, String>>> finalMap = new TreeMap<>();
			Map<String, String> toMap = stringToMap(item.getAnswer());
			resMap.put(item.getType(),toMap);
			finalMap.put(item.getName(), resMap);
			realMap.put(index, finalMap);
			index++;
		}
		

		return new QuestionniareResponse(RtnCode.SUCCESSFUL.getMessage(), qusetionniare, realMap);

	}

//	���k 
	private String mapToString(Map<String, String> answers) {

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

	private Map<String, String> stringToMap(String mapStr) {

		ObjectMapper mapper = new ObjectMapper();

		Map<String, String> resmap = new HashMap();
		try {
			resmap = mapper.readValue(mapStr, Map.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resmap;
	}

}
