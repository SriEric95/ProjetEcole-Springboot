package com.example.ecole;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.example.ecole.*;

@Entity // This tells Hibernate to make a table out of this class
public class Etablissement {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String libelle;

    private String code_postal;
    
    private String adresse;

    private String ville;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "etablissement")
    private List<User> users;
    
    public Etablissement(){}
    
    public Etablissement(String libelle, String code_postal, String adresse, String ville) {
        
    	this.libelle = libelle;
        this.code_postal = code_postal;
        this.adresse = adresse;
        this.ville = ville;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
