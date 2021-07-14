package com.projet.gestionVente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.gestionVente.model.Produit_Prix;
import com.projet.gestionVente.model.Produit_Stock;
import com.projet.gestionVente.model.User;
import com.projet.gestionVente.repository.Produit_PrixRepository;
import com.projet.gestionVente.repository.Produit_StockRepository;
import com.projet.gestionVente.repository.UserRepository;

@Service
public class ProduitSService {
	
private Produit_StockRepository produit_StockRepository;
	
	@Autowired
	public ProduitSService(Produit_StockRepository produit_StockRepository) {
		this.produit_StockRepository = produit_StockRepository;
	}
	
	public List<Produit_Stock> find(){
		return produit_StockRepository.findAll();
	}
	
	public void save(Produit_Stock produit_Stock) {
		produit_StockRepository.save(produit_Stock);
	}
	
	public Produit_Stock get(long id) {
		return produit_StockRepository.findById(id).get();
	}
	
	public void delete(long id) {
		produit_StockRepository.deleteById(id);
	}

}
