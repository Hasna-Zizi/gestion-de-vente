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
@Table(name="user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long codeUser;
	
	@Column
	private String login;
	
	@Column
	private String pass;
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<Commande> commandes=new ArrayList<Commande>();
   
	//Constructeur :
	
	public User() {
		super();
		
	}
	public User(String login, String pass) {
		super();
		this.login = login;
		this.pass = pass;
	}
	public User(Long codeUser, String login, String pass) {
		super();
		this.codeUser = codeUser;
		this.login = login;
		this.pass = pass;
	}

	public User(Long codeUser, String login, String pass, List<Commande> commandes) {
		super();
		this.codeUser = codeUser;
		this.login = login;
		this.pass = pass;
		this.commandes = commandes;
	}
	
	// Getters & Setters :
	
	public Long getCodeUser() {
		return codeUser;
	}

	public void setCodeUser(Long codeUser) {
		this.codeUser = codeUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

  
	// ToString :
	
	@Override
	public String toString() {
		return "User [codeUser=" + codeUser + ", login=" + login + ", pass=" + pass + "]";
	}
	
	
  
}
