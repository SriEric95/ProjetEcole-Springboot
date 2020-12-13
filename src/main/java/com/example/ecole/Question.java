package com.example.ecole;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Question {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id_question;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_questionnaire")
	private Questionnaire questionnaire;
	
	
	private Integer numQuestion;
	
	private String libelleQuestion;

	public Integer getId_question() {
		return id_question;
	}

	public void setId_question(Integer id_question) {
		this.id_question = id_question;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public Integer getNumQuestion() {
		return numQuestion;
	}

	public void setNumQuestion(Integer numQuestion) {
		this.numQuestion = numQuestion;
	}

	public String getLibelleQuestion() {
		return libelleQuestion;
	}

	public void setLibelleQuestion(String libelleQuestion) {
		this.libelleQuestion = libelleQuestion;
	}

}
