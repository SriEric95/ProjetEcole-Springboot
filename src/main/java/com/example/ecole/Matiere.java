package com.example.ecole;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class

public class Matiere{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private Integer id_matiere;

	private String libelle;
    
    public Matiere(){}
    
    public Matiere(String libelle) {
        
    	this.libelle = libelle;
        
    }

    public Integer getId_matiere() {
		return id_matiere;
	}

	public void setId_matiere(Integer id_matiere) {
		this.id_matiere = id_matiere;
	}
	
    public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
