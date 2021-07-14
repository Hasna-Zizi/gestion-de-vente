package com.projet.gestionVente.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="produits_prix")
public class Produit_Prix implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codePdt")
	private Long codeP;
	
	@Column(name="nomPdt")
	private String nomP;
	
	@Column(name="descPdt")
	private String descP;
	
	@Column(name="prixPdt")
	private int prixP;
	
	@OneToMany(mappedBy="produitsPrix", fetch=FetchType.EAGER)
	private List<Commande> commandes = new ArrayList<Commande>();
    
	// Constructeur :
	
	public Produit_Prix() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produit_Prix(Long codeP, String nomP, String descP, int prixP) {
		super();
		this.codeP = codeP;
		this.nomP = nomP;
		this.descP = descP;
		this.prixP = prixP;
	}

	public Produit_Prix(Long codeP, String nomP, String descP, int prixP, List<Commande> commandes) {
		super();
		this.codeP = codeP;
		this.nomP = nomP;
		this.descP = descP;
		this.prixP = prixP;
		this.commandes = commandes;
	}
    
	// Getters & Setters :
	
	public Long getCodeP() {
		return codeP;
	}

	public void setCodeP(Long codeP) {
		this.codeP = codeP;
	}

	public String getNomP() {
		return nomP;
	}

	public void setNomP(String nomP) {
		this.nomP = nomP;
	}

	public String getDescP() {
		return descP;
	}

	public void setDescP(String descP) {
		this.descP = descP;
	}

	public int getPrixP() {
		return prixP;
	}

	public void setPrixP(int prixP) {
		this.prixP = prixP;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
    // ToString 
	
	@Override
	public String toString() {
		return "Produit_Prix [codeP=" + codeP + ", nomP=" + nomP + ", descP=" + descP + ", prixP=" + prixP + "]";
	}
	
	
	
	

}
