package com.example.questionnaire.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnaire.service.ifs.QuestionService;
import com.example.questionnaire.vo.question.AddQuestionRequest;
import com.example.questionnaire.vo.question.AddQuestionResponse;

@RestController
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@PostMapping(value = "add_question")
	public AddQuestionResponse addQuestion(@RequestBody AddQuestionRequest request) {
		return questionService.addQuestion(request.getQuestionnaireId()
				, request.getName(), request.getType(), request.getAnswers());
	}
}
