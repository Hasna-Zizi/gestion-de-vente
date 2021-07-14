package com.projet.gestionVente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.gestionVente.model.Produit_Prix;
import com.projet.gestionVente.model.User;
import com.projet.gestionVente.repository.Produit_PrixRepository;
import com.projet.gestionVente.repository.UserRepository;

@Service
public class ProduitPService {
	
private Produit_PrixRepository produit_PrixRepository;
	
	@Autowired
	public ProduitPService(Produit_PrixRepository produit_PrixRepository) {
		this.produit_PrixRepository = produit_PrixRepository;
	}
	
	public List<Produit_Prix> find(){
		return produit_PrixRepository.findAll();
	}
	
	public void save(Produit_Prix produit_Prix) {
		produit_PrixRepository.save(produit_Prix);
	}
	
	public Produit_Prix get(long id) {
		return produit_PrixRepository.findById(id).get();
	}
	
	public void delete(long id) {
		produit_PrixRepository.deleteById(id);
	}

}
