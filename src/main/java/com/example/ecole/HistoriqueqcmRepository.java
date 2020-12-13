package com.example.ecole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HistoriqueqcmRepository extends  JpaRepository<Historiqueqcm, Integer> { 
	
	Historiqueqcm findByResultat();
	
}
