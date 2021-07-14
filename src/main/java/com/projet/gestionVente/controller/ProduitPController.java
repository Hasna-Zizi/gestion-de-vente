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
import com.projet.gestionVente.model.Produit_Prix;
import com.projet.gestionVente.model.Produit_Stock;
import com.projet.gestionVente.service.ProduitPService;
import com.projet.gestionVente.service.ProduitSService;


@RestController
@RequestMapping("/produitsP")
public class ProduitPController {
	

private ProduitPService produitPService;
private ProduitSService produitSservice; 
private List<Produit_Prix> allProdP;
private List<Produit_Stock> allProdS;
	
	@Autowired
	public ProduitPController(ProduitPService produitPService) {
		this.produitPService = produitPService;
	}
	
	@GetMapping
	public List<Produit_Prix> findAllProduitPs(){
		return produitPService.find();
	}
	@GetMapping
	public List<Produit_Prix> ProduitAafficher(){
		allProdP = produitPService.find();
		allProdS = produitSservice.find();
		
		for(Produit_Stock ps : allProdS ) {
			for(Produit_Prix pp : allProdP )
			{
				if(ps.getNomPdt().equals(pp.getNomP()))
				{  
			   if(ps.getQtePdt() == 0 )
				{
					allProdP.remove(produitPService.get(pp.getCodeP()));
					return allProdP;
				}
					
				
				
				}
				
			}
		}
		return allProdP;
		
	}
	@PostMapping
	public String save(@RequestBody Produit_Prix produitp) {
		produitPService.save(produitp);
		return "hi "+ produitp.getNomP()+" your registration process successfully completed";
	}
	
	@GetMapping("/get/{id}")
	public Produit_Prix findProduit(@PathVariable long id){
		return produitPService.get(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public List<Produit_Prix> delete(@PathVariable long id){
		produitPService.delete(id);
		return produitPService.find();
	}
	
	@PutMapping ("/edit/{id}")
	 public void update(@PathVariable("id") long id, @RequestBody Produit_Prix produitp) {
		  
		Produit_Prix produitpToUpdate = produitPService.get(id);
		  
		  produitpToUpdate.setNomP(produitp.getNomP());
		  produitpToUpdate.setDescP(produitp.getDescP());
		  produitpToUpdate.setPrixP(produitp.getPrixP());
		
		  produitPService.save(produitpToUpdate);
		  System.out.println(produitp);

	}
}
