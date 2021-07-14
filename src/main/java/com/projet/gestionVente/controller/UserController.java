package com.projet.gestionVente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.gestionVente.model.User;
import com.projet.gestionVente.service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {
	
private UserService userService;


	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<User> findAllUsers(){
		return userService.find();
	}
	
//	@PostMapping
//	public String save(@RequestBody User user) {
//		System.out.println(user.getLogin()+" "+user.getPass());
//		userService.save(user);
//		return "hi "+ user.getLogin()+" your registration process successfully completed";
//	}
	
	@GetMapping("/get/{id}")
	public User findUser(@PathVariable long id){
		return userService.get(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public List<User> delete(@PathVariable long id){
		userService.delete(id);
		return userService.find();
	}
	
	@PutMapping ("/edit/{id}")
	 public void update(@PathVariable("id") long id, @RequestBody User user) {
		  
		  User userToUpdate = userService.get(id);
		  
		  userToUpdate.setLogin(user.getLogin());
		  userToUpdate.setPass(user.getPass());
		
		  userService.save(userToUpdate);
		  System.out.println(user);

	}
	@PostMapping("/log")
	 public String login(@RequestBody User  user) {
		System.out.println(user.getLogin()+" "+user.getPass());
		   if(userService.login(user.getLogin(), user.getPass()) == "ok")
		      {return "Access"+ user.getLogin()+" your Authentification process successfully completed" ;}
		   else
		return "refuse";
		  
		   
	   } 
	@PostMapping("/registrer")
	public String registrer(@RequestBody User  user) {
		   
		   if(userService.registrer(user.getLogin(),user.getPass())!="existe")
		   { 
			userService.save(user);
			return "hi "+ user.getLogin()+" your registration process successfully completed";}
		   else 
			   return "deja existe";	   
	   }
}
