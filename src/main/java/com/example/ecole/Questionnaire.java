package com.example.ecole;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Questionnaire {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id_questionnaire;
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="id_matiere")
	private Matiere matiere;
    
    @OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_classe")
    private Classe classe;

	private String libelle;
	
	private Integer nb_questions;

	public Integer getId_questionnaire() {
		return id_questionnaire;
	}

	public void setId_questionnaire(Integer id_questionnaire) {
		this.id_questionnaire = id_questionnaire;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Integer getNb_questions() {
		return nb_questions;
	}

	public void setNb_questions(Integer nb_questions) {
		this.nb_questions = nb_questions;
	}
}
