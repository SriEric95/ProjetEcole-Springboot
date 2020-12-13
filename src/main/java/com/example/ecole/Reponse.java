package com.example.ecole;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity // This tells Hibernate to make a table out of this class
public class Reponse {
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Integer id_reponse;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_question")
	private Question question;
	
	private String libelle;
	
	private Boolean valeur;
	
	public Reponse() {}
	 
	 public Reponse(String libelle,Boolean valeur,Question question) 
	 {
	     this.libelle = libelle;  
	     this.valeur = valeur;
	     this.question=question;
	 }

	public Integer getId_reponse() {
		return id_reponse;
	}

	public void setId_reponse(Integer id_reponse) {
		this.id_reponse = id_reponse;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Boolean getValeur() {
		return valeur;
	}

	public void setValeur(Boolean valeur) {
		this.valeur = valeur;
	}
	 
	 
	
	

}
