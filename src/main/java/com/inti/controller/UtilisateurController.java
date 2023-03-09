package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Utilisateur;
import com.inti.service.interfaces.IutilisateurService;

@RestController
@CrossOrigin
public class UtilisateurController {
	@Autowired
	IutilisateurService utilisateurService;
	@Autowired
	//PasswordEncoder passwordEncoder;

	@GetMapping("/utilisateurs")
	public List<Utilisateur> findAll() {
		return utilisateurService.findAll();
	}

	@GetMapping("/utilisateurs/{idUtilisateur}")
	public Utilisateur findOne(@PathVariable("idUtilisateur") Long id) {
		return utilisateurService.findOne(id);
	}
	
	@PostMapping("/utilisateurs")
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.save(utilisateur);
	}

	@DeleteMapping("/utilisateurs/{idUtilisateur}")
	public void deleteUtilisateur(@PathVariable("idUtilisateur") Long id) {
		utilisateurService.delete(id);
	}

	@PutMapping("/utilisateurs/{idUtilisateur}")
	public Utilisateur updateUtilisateurWithPut(@PathVariable("idUtilisateur") Long id,
			@RequestBody Utilisateur utilisateur) {
		Utilisateur currentUser = utilisateurService.findOne(id);
		System.out.println(currentUser.toString());
		currentUser.setNomUtilisateur(utilisateur.getNomUtilisateur());
		currentUser.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
		currentUser.setEmailUtilisateur(utilisateur.getEmailUtilisateur());
		//currentUser.setUsername(utilisateur.getUsername());
		//currentUser.setPassword(utilisateur.getPassword());
		return utilisateurService.save(currentUser);
	}

	@PatchMapping("/utilisateurs/{idUtilisateur}")
	public Utilisateur updateUtilisateurWithPatch(@PathVariable("idUtilisateur") Long id,
			@RequestBody Utilisateur utilisateur) {
		Utilisateur currentUser = utilisateurService.findOne(id);
		//currentUser.setPassword(utilisateur.getPassword());
		return utilisateurService.save(currentUser);
	}
}
