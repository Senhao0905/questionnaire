package com.example.questionnaire.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnaire.entity.Questionnaire;
import com.example.questionnaire.service.ifs.QuestionnaireService;
import com.example.questionnaire.vo.questioniare.QuestionnaireRequest;
import com.example.questionnaire.vo.questioniare.QuestionnaireResponse;
import com.example.questionnaire.vo.questioniare.SearchQuestioniareRequest;
import com.example.questionnaire.vo.questioniare.SearchQuestionnaireResponse;

@RestController
public class QuestionnaireController {

	@Autowired
	private QuestionnaireService questionnaireService;

	@PostMapping(value = "add_questionnaire")
	public QuestionnaireResponse addQuestionnaire(@RequestBody QuestionnaireRequest request) {
		return questionnaireService.addQuestionnaire(request.getQuestionnaire());

	}

	@PostMapping(value = "del_questionnaire")
	public QuestionnaireResponse delQuestionnaire(@RequestBody QuestionnaireRequest request) {
		return questionnaireService.delQuestionnaire(request.getId());
	}

	@PostMapping(value = "update_questionnaire")
	public QuestionnaireResponse updateQuestionnaire(@RequestBody QuestionnaireRequest request) {
		return questionnaireService.updateQuestionnaire(request.getQuestionnaire());
	}
	
	@GetMapping(value = "get_all_questioniare")
	public SearchQuestionnaireResponse getAllQuestioniare() {
		return questionnaireService.getAllQuestioniare();
	}
	
	@PostMapping(value = "search_by_name_containing")
	public SearchQuestionnaireResponse searchByNameContaining(@RequestBody SearchQuestioniareRequest request) {
		return questionnaireService.searchByNameContaining(request.getName());
	}
	
	@PostMapping(value = "search_by_data")
	public SearchQuestionnaireResponse searchByDate(@RequestBody SearchQuestioniareRequest request) {
		return questionnaireService.searchByDate(request.getStartDate(), request.getEndDate());
	}
}
