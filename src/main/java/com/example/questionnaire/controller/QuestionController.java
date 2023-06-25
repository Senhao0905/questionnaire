package com.example.questionnaire.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnaire.service.ifs.QuestionService;
import com.example.questionnaire.vo.question.AddQuestionRequest;
import com.example.questionnaire.vo.question.AddQuestionResponse;
import com.example.questionnaire.vo.question.DelQuestionRequest;
import com.example.questionnaire.vo.question.DelQuestionResponse;
import com.example.questionnaire.vo.question.QuestionniareResRequest;
import com.example.questionnaire.vo.question.QuestionniareResponse;

@CrossOrigin
@RestController
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@PostMapping(value = "add_question")
	public AddQuestionResponse addQuestion(@RequestBody AddQuestionRequest request) {
		return questionService.addQuestion(request.getQuestionnaireId()
				, request.getName(), request.getType(), request.getAnswers());
	}
	
	@PostMapping(value = "del_question")
	public DelQuestionResponse delQuestion(@RequestBody DelQuestionRequest request) {
		return questionService.delQuestion(request.getSeq());
	}
	
	@PostMapping(value = "update_question")
	public AddQuestionResponse updateQuestion(@RequestBody AddQuestionRequest request) {
		return questionService.updateQuestion(request.getSeq(), request.getQuestionnaireId()
				, request.getName(), request.getType(), request.getAnswers());
	}
	
	
	@PostMapping(value = "questionniare_res")
	public QuestionniareResponse questionniareRes(@RequestBody QuestionniareResRequest request ) {
		return questionService.questionniareRes(request.getId());
	}
}
