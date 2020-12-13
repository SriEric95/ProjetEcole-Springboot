package com.example.ecole;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Historiqueqcm {
	

    
	
	private Integer id_histo;   
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_etudiant")
	private User id_etudiant;

	private Date date; 

	private Integer resultat; 

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_questionnaire")
	private Questionnaire id_questionnaire;
	
	public Historiqueqcm(User id_etudiant, Date date, Integer resultat, Questionnaire id_questionnaire) {
        this.id_etudiant = id_etudiant;
        this.date = date;
    	this.resultat = resultat;
    	this.id_questionnaire = id_questionnaire;
        }

	public Integer getId_histo() {
		return id_histo;
	}

	public void setId_histo(Integer id_histo) {
		this.id_histo = id_histo;
	}

	

	public User getId_etudiant() {
		return id_etudiant;
	}

	public void setId_etudiant(User id_etudiant) {
		this.id_etudiant = id_etudiant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getResultat() {
		return resultat;
	}

	public void setResultat(Integer resultat) {
		this.resultat = resultat;
	}

	public Questionnaire getId_questionnaire() {
		return id_questionnaire;
	}

	public void setId_questionnaire(Questionnaire id_questionnaire) {
		this.id_questionnaire = id_questionnaire;
	}

	
}
