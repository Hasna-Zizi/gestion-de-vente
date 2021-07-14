package com.projet.gestionVente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.gestionVente.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande,Long>{

}
