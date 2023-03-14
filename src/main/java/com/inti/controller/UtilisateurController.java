package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

import com.inti.entities.Affaire;
import com.inti.entities.Utilisateur;
import com.inti.service.interfaces.IUtilisateurService;

@RestController
@CrossOrigin
public class UtilisateurController {
	@Autowired
	IUtilisateurService utilisateurService;
	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/utilisateurs")
	public List<Utilisateur> findAll() {
		return utilisateurService.findAll();
	}

	@GetMapping("/utilisateurs/{idUtilisateur}")
	public Utilisateur findOne(@PathVariable("idUtilisateur") Long id) {
		return utilisateurService.findOne(id);
	}
	
	/*@GetMapping("/utilisateurs/{nomUtilisateur}")
    public List<Utilisateur>  findByNomUtilisateur(@PathVariable("nomUtilisateur") String nomUtilisateur) {
        return utilisateurService.findByNomUtilisateur(nomUtilisateur);
    }*/
	
	@PostMapping("/utilisateurs")
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		Utilisateur currentUtilisateur=new Utilisateur(
				utilisateur.getEmailUtilisateur(),
				utilisateur.getNomUtilisateur(),
				utilisateur.getPrenomUtilisateur(),
				utilisateur.getUsername(),
				passwordEncoder.encode(utilisateur.getPassword()),
				utilisateur.getRoles(),
				utilisateur.isEnable());
				
		return utilisateurService.save(currentUtilisateur);
	}

	@DeleteMapping("/utilisateurs/{idUtilisateur}")
	public void deleteUtilisateur(@PathVariable("idUtilisateur") Long id) {
		utilisateurService.delete(id);
	}

	@PutMapping("/utilisateurs/{idUtilisateur}")
	public Utilisateur updateUtilisateurWithPut(@PathVariable("idUtilisateur") Long id,
			@RequestBody Utilisateur utilisateur) {
		Utilisateur currentUtilisateur = utilisateurService.findOne(id);
		System.out.println(currentUtilisateur.toString());
		currentUtilisateur.setNomUtilisateur(utilisateur.getNomUtilisateur());
		currentUtilisateur.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
		currentUtilisateur.setEmailUtilisateur(utilisateur.getEmailUtilisateur());
		currentUtilisateur.setUsername(utilisateur.getUsername());
		currentUtilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		currentUtilisateur.setRoles(utilisateur.getRoles());
		currentUtilisateur.setEnable(utilisateur.isEnable());
		return utilisateurService.save(currentUtilisateur);
	}

	@PatchMapping("/utilisateurs/{idUtilisateur}")
	public Utilisateur updateUtilisateurWithPatch(@PathVariable("idUtilisateur") Long id,
			@RequestBody Utilisateur utilisateur) {
		Utilisateur currentUtilisateur = utilisateurService.findOne(id);
		currentUtilisateur.setIdUtilisateur(utilisateur.getIdUtilisateur());
		currentUtilisateur.setEmailUtilisateur(utilisateur.getEmailUtilisateur());
		currentUtilisateur.setNomUtilisateur(utilisateur.getNomUtilisateur());
		currentUtilisateur.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
		currentUtilisateur.setUsername(utilisateur.getUsername());
		currentUtilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		currentUtilisateur.setRoles(utilisateur.getRoles());
		return utilisateurService.save(currentUtilisateur);
	}
}
