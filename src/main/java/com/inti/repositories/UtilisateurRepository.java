package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	List<Utilisateur >findByNomUtilisateur(String nomUtilisateur);
	
	Utilisateur findByUsername(String username);
}
