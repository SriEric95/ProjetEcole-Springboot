package com.example.ecole;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.ecole.*;

@Entity 
public class Classe {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Integer id_classe;

	 private String libelle;
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "classe")
	 private List<User> users;
	 
	 public Classe() {}
	 
	 public Classe(String libelle) 
	 {
	     this.libelle = libelle;     
	 }

	public Integer getId_classe() {
		return id_classe;
	}

	public void setId_classe(Integer id_classe) {
		this.id_classe = id_classe;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}	 

}