package com.example.ecole;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends  JpaRepository<User, Integer> {
 User findBynom (String nom);
 User findByprenom (String prenom);
 User findByemail (String email);
 //User findByRole(String role);
 User findByEtablissement(Etablissement etab);
 
 @Query("select u from User u where u.role = ?1")
 List<User> findByRole(String role);
 
}
