package com.example.questionnaire.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questionnaire")
public class Questionnaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "describe_text")
	private String describeText;

	@Column(name = "start")
	private LocalDate start;

	@Column(name = "end")
	private LocalDate end;

	public Questionnaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Questionnaire(String name, String describeText, LocalDate start, LocalDate end) {
		super();
		this.name = name;
		this.describeText = describeText;
		this.start = start;
		this.end = end;
	}

	public Questionnaire(int id, String name, String describeText, LocalDate start, LocalDate end) {
		super();
		this.id = id;
		this.name = name;
		this.describeText = describeText;
		this.start = start;
		this.end = end;
	}

//	 * Get / Set

	public int getId() {
		return id;
	}

	public String getDescribeText() {
		return describeText;
	}

	public void setDescribeText(String describeText) {
		this.describeText = describeText;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

}
