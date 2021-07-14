package com.projet.gestionVente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.gestionVente.model.Commande;
import com.projet.gestionVente.repository.CommandeRepository;


@Service
public class CommandeService {
	
private CommandeRepository commandeRepository;
	
	@Autowired
	public CommandeService(CommandeRepository commandeRepository) {
		this.commandeRepository = commandeRepository;
	}
	
	public List<Commande> find(){
		return commandeRepository.findAll();
	}
	
	public void save(Commande commande) {
		commandeRepository.save(commande);
	}
	
	public Commande get(long id) {
		return commandeRepository.findById(id).get();
	}
	
	public void delete(long id) {
		commandeRepository.deleteById(id);
	}

}
