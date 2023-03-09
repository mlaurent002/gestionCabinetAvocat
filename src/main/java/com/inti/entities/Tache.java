package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Tache implements Serializable {
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTache;
	private Date dateCreation;
	private String titreTache; 
	private String descriptionTache; 
	private boolean statutAudience; 
	
	//Relation entre classes 
		//ManyToOne utilisateur <-> Tache
	 @ManyToOne
	  @JoinColumn(name = "utilisateur_id")
	  private Utilisateur utilisateurFK;
	 
	 /*
		//ManyToOne Affaire <-> Tache
		 @ManyToOne
		  @JoinColumn(name = "affaire_id")
		  private Affaire affaireFK;
		 
		//ManyToOne Tribunal <-> Tache
		 @ManyToOne
		  @JoinColumn(name = "tribunal_id")
		  private Tribunal tribunalFK;
	 
		//OneToMany Phase <-> Tache
			@OneToMany(mappedBy = "phaseFK")
			@Transient
			private List<Phase> phases = new ArrayList<>();
	
	*/
	 
}
