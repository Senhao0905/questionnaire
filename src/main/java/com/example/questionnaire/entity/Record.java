package com.example.questionnaire.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "record")
public class Record {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq")
	private int seq;

	@Column(name = "questionnaire_id")
	private int questionnaireId;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "age")
	private int age;

	@Column(name = "answer")
	private String answer;

	@Column(name = "date")
	private LocalDateTime localDateTime = LocalDateTime.now();

	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Record(int questionnaireId, String name, String email, String phone, int age, String answer) {
		super();
		this.questionnaireId = questionnaireId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.answer = answer;
	}

	public Record(int seq, int questionnaireId, String name, String email, String phone, int age, String answer,
			LocalDateTime localDateTime) {
		super();
		this.seq = seq;
		this.questionnaireId = questionnaireId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.answer = answer;
		this.localDateTime = localDateTime;
	}

	public Record(int seq, int questionnaireId, String name, String email, String phone, int age, String answer) {
		super();
		this.seq = seq;
		this.questionnaireId = questionnaireId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.answer = answer;
	}

	// ---------------------------------------
	
	public int getSeq() {
		return seq;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(int questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
