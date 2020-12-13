package com.example.ecole;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatiereRepository extends CrudRepository<Matiere, Integer> { 
	Matiere findByLibelle(String libelle);

}
