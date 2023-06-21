package com.example.questionnaire.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.questionnaire.constant.RtnCode;
import com.example.questionnaire.entity.Questionnaire;
import com.example.questionnaire.repository.QuestionnaireDao;
import com.example.questionnaire.service.ifs.QuestionnaireService;
import com.example.questionnaire.vo.questioniare.QuestionnaireResponse;
import com.example.questionnaire.vo.questioniare.SearchQuestionnaireResponse;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

	@Autowired
	private QuestionnaireDao questionnaireDao;

	@Override
	public QuestionnaireResponse addQuestionnaire(Questionnaire questionnaire) {
		if (!StringUtils.hasText(questionnaire.getName())
				|| !StringUtils.hasText(questionnaire.getDescribeText())) {
			return new QuestionnaireResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		LocalDate nowDate = LocalDate.now();

		if (questionnaire.getStart().isBefore(nowDate) || questionnaire.getStart().isAfter(questionnaire.getEnd())) {
			return new QuestionnaireResponse(RtnCode.DATE_ERROR.getMessage());
		}

		return new QuestionnaireResponse(RtnCode.SUCCESSFUL.getMessage(), questionnaireDao.save(questionnaire));
	}

	@Override
	public QuestionnaireResponse delQuestionnaire(int id) {

		boolean res = questionnaireDao.existsById(id);

		if (!res) {
			return new QuestionnaireResponse(RtnCode.NOT_FOUND.getMessage());
		}

		questionnaireDao.deleteById(id);
		return new QuestionnaireResponse(RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public QuestionnaireResponse updateQuestionnaire(Questionnaire questionnaire) {

		boolean res = questionnaireDao.existsById(questionnaire.getId());
		if (!res) {
			return new QuestionnaireResponse(RtnCode.NOT_FOUND.getMessage());
		}
		if (!StringUtils.hasText(questionnaire.getName())
				|| !StringUtils.hasText(questionnaire.getDescribeText())) {
			return new QuestionnaireResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		LocalDate nowDate = LocalDate.now();

		if (questionnaire.getStart().isBefore(nowDate) || questionnaire.getStart().isAfter(questionnaire.getEnd())) {
			return new QuestionnaireResponse(RtnCode.DATE_ERROR.getMessage());
		}

		return new QuestionnaireResponse(RtnCode.SUCCESSFUL.getMessage(), questionnaireDao.save(questionnaire));
	}

	@Override
	public SearchQuestionnaireResponse getAllQuestioniare(int pageNumber) {
		// 判斷頁數是否超過
		List<Questionnaire> total = questionnaireDao.findAll();
		// 目前頁數（從 0 開始）
		int pageSize = 2;  // 每頁顯示的項目數量
		
		int maxPage = total.size() < pageSize ? 0 : (total.size()%pageSize==0) ? (total.size() / pageSize)-1  :total.size() / pageSize ;
		
		if(pageNumber > maxPage) {
			return new SearchQuestionnaireResponse(RtnCode.ERROR.getMessage());
		}
		
		Sort sort = Sort.by("id").descending();  

		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

		Page<Questionnaire> page = questionnaireDao.findAll(pageable);
		
		List<Questionnaire> res = page.getContent();

		if (CollectionUtils.isEmpty(res)) {
			return new SearchQuestionnaireResponse(RtnCode.NOT_FOUND.getMessage());
		}
		
		return new SearchQuestionnaireResponse(RtnCode.SUCCESSFUL.getMessage(), page);
	}

	@Override
	public SearchQuestionnaireResponse searchByNameContaining(String name) {

		if (!StringUtils.hasText(name)) {
			return new SearchQuestionnaireResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		List<Questionnaire> res = questionnaireDao.findByNameContaining(name);

		if (CollectionUtils.isEmpty(res)) {
			return new SearchQuestionnaireResponse(RtnCode.NOT_FOUND.getMessage());
		}

		return new SearchQuestionnaireResponse(RtnCode.SUCCESSFUL.getMessage(), res);
	}

	@Override
	public SearchQuestionnaireResponse searchByDate(LocalDate startDate, LocalDate endDate) {

		LocalDate nowDate = LocalDate.now();

		if (startDate.isBefore(nowDate) || startDate.isAfter(endDate)) {
			return new SearchQuestionnaireResponse(RtnCode.DATE_ERROR.getMessage());
		}
		
		List<Questionnaire> res = questionnaireDao.searchByDate(startDate, endDate);
		
		if(CollectionUtils.isEmpty(res)) {
			return new SearchQuestionnaireResponse(RtnCode.NOT_FOUND.getMessage());
		}
		
		return new SearchQuestionnaireResponse(RtnCode.SUCCESSFUL.getMessage(),res);
	}

}
