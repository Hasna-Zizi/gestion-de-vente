package com.projet.gestionVente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.gestionVente.model.Commande;
import com.projet.gestionVente.model.User;
import com.projet.gestionVente.service.CommandeService;


@RestController
@RequestMapping("/commandes")
public class CommandeController {
	
private CommandeService commandeService;
	
	@Autowired
	public CommandeController(CommandeService commandeService) {
		this.commandeService = commandeService;
	}
	
	@GetMapping
	public List<Commande> findAllCommandes(){
		return commandeService.find();
	}
	
	@PostMapping
	public String save(@RequestBody Commande commande) {
		commandeService.save(commande);
		return "hi your commande saved successfully completed";
	}
	
	@GetMapping("/get/{id}")
	public Commande findCommande(@PathVariable long id){
		return commandeService.get(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public List<Commande> delete(@PathVariable long id){
		commandeService.delete(id);
		return commandeService.find();
	}
	
	@PatchMapping ("/edit/{id}")
	 public void update(@PathVariable("id") long id, @RequestBody Commande commande) {
		  
		Commande commandeToUpdate = commandeService.get(id);
		  
		commandeToUpdate.setDateCmd(commande.getDateCmd());
		commandeToUpdate.setQteCmd(commande.getQteCmd());
		
		  commandeService.save(commandeToUpdate);
		  System.out.println(commande);

	}



}
