package com.projet.gestionVente.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="commandes")
public class Commande implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long codeCmd;
	
	@Column
	private int qteCmd;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateCmd;
	
	@ManyToOne
	@JoinColumn(name = "codePdt")
	private Produit_Prix produitsPrix;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "client", referencedColumnName = "login")
	private User user;
    
	//Constructeur
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(Long codeCmd, int qteCmd, Date dateCmd) {
		super();
		this.codeCmd = codeCmd;
		this.qteCmd = qteCmd;
		this.dateCmd = dateCmd;
	}

	public Commande(Long codeCmd, int qteCmd, Date dateCmd, Produit_Prix produitsPrix, User user) {
		super();
		this.codeCmd = codeCmd;
		this.qteCmd = qteCmd;
		this.dateCmd = dateCmd;
		this.produitsPrix = produitsPrix;
		this.user = user;
	}
   
	// Getter & Setters
	
	public Long getCodeCmd() {
		return codeCmd;
	}

	public void setCodeCmd(Long codeCmd) {
		this.codeCmd = codeCmd;
	}

	public int getQteCmd() {
		return qteCmd;
	}

	public void setQteCmd(int qteCmd) {
		this.qteCmd = qteCmd;
	}

	public Date getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

	public Produit_Prix getProduitsPrix() {
		return produitsPrix;
	}

	public void setProduitsPrix(Produit_Prix produitsPrix) {
		this.produitsPrix = produitsPrix;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	 // ToString 
	@Override
	public String toString() {
		return "Commande [codeCmd=" + codeCmd + ", qteCmd=" + qteCmd + ", dateCmd=" + dateCmd + "]";
	}
	

	
	
	
	
	
	
	


}
