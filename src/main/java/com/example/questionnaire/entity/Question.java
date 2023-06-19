package com.example.questionnaire.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq")
	private int seq;

	@Column(name = "questionnaire_id")
	private int questionnaireId;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "answer")
	private String answer;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int questionnaireId, String name, String type, String answer) {
		super();
		this.questionnaireId = questionnaireId;
		this.name = name;
		this.type = type;
		this.answer = answer;
	}
//----------------------------------------------
	public int getSeq() {
		return seq;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	

	

}
