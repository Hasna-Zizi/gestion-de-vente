package com.projet.gestionVente.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.gestionVente.model.User;
import com.projet.gestionVente.repository.UserRepository;

@Service
public class UserService {
   
	private UserRepository userRepository;
	
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> find(){
		return userRepository.findAll();
	}
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public User get(long id) {
		return userRepository.findById(id).get();
	}
	
	public void delete(long id) {
		userRepository.deleteById(id);
	}
	
   public String login(String login , String pass) {
	   System.out.println(login);
	   List<User> allUsers = userRepository.findAll();
	   for(User u : allUsers)
	   {
		   if(u.getLogin() == login && u.getPass() == pass)
		   
			   return "ok";
		   
		   }
	    
	return "no"+login;
	  }
   
public String registrer(String login ,  String pass) {
	System.out.println(login);
	   List<User> allUsers = userRepository.findAll();
	   for(User u : allUsers) {
		   if(u.getLogin() == login && u.getPass() == pass)
		   { System.out.println(u.getPass());
			   return "existe";
		   }
		   
	   }
	   userRepository.save(new User(login,pass));
     return "registre";
   }
   
   
}
