package com.projet.gestionVente.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produits_stock")
public class Produit_Stock implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long codePdt;
	
	@Column
	private String nomPdt;
	
	@Column
	private int qtePdt;
	
	@Column
	private String descPdt;
	
	@Column
	private int prixPdt;
    
	// Constructeur 
	
	public Produit_Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produit_Stock(Long codePdt, String nomPdt, int qtePdt, String descPdt, int prixPdt) {
		super();
		this.codePdt = codePdt;
		this.nomPdt = nomPdt;
		this.qtePdt = qtePdt;
		this.descPdt = descPdt;
		this.prixPdt = prixPdt;
	}

	// Getters & Setters : 

	public Long getCodePdt() {
		return codePdt;
	}

	public void setCodePdt(Long codePdt) {
		this.codePdt = codePdt;
	}

	public String getNomPdt() {
		return nomPdt;
	}

	public void setNomPdt(String nomPdt) {
		this.nomPdt = nomPdt;
	}

	public int getQtePdt() {
		return qtePdt;
	}

	public void setQtePdt(int qtePdt) {
		this.qtePdt = qtePdt;
	}

	public String getDescPdt() {
		return descPdt;
	}

	public void setDescPdt(String descPdt) {
		this.descPdt = descPdt;
	}

	public int getPrixPdt() {
		return prixPdt;
	}

	public void setPrixPdt(int prixPdt) {
		this.prixPdt = prixPdt;
	}
    
	// ToString 
	
	@Override
	public String toString() {
		return "Produit_Stock [codePdt=" + codePdt + ", nomPdt=" + nomPdt + ", qtePdt=" + qtePdt + ", descPdt="
				+ descPdt + ", prixPdt=" + prixPdt + "]";
	}
	
	
		
	
	
	
	

}
