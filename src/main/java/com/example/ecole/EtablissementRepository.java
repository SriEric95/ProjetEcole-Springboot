package com.example.ecole;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EtablissementRepository extends CrudRepository<Etablissement, Integer> { 
	Etablissement findByLibelle(String libelle);

}
