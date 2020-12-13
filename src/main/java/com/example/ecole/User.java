package com.example.ecole;

import java.util.Collection;
import java.util.Collections;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    //private Integer id_etablissement;
    
    private String prenom;
    
    private String nom;

    private String email;
    
    private String login;
    
    @JsonProperty("role")
    private String role;
    
    private String password;
    
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_etablissement")
    private Etablissement etablissement;
    
    @OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_classe")
	private Classe classe;
       
    
    public User() {

    }

    public User(String nom, String prenom, String email, String login, String role, String password) {
    	//Integer id_etablissement, 
    	//this.id_etablissement = id_etablissement;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    	this.login = login;
    	this.role = role;
    	this.password = password;
        }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	 public String getNom() {
			return nom;
	}

	public void setNom(String nom) {
			this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
			return role;
	}

	public void setRole(String role) {
			this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}
	
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

}
