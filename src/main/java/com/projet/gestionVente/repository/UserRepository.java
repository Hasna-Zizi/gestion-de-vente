package com.projet.gestionVente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projet.gestionVente.model.User;



public interface UserRepository extends JpaRepository<User, Long> {
	
	// Methode de login :
//	@Query(value="From User where login = :login and pass = :pass ")
//	User login(String login , String pass);
//    
	
	
	
}
