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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "TACHES", schema = "gestion_cabinet_avocat_db")
public class Tache implements Serializable {
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTache;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private String titreTache;
	private String descriptionTache;
	private boolean statutAudience;

	// Relation entre classes
	// ManyToOne utilisateur <-> Tache
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateurFK;

	// ManyToOne Affaire <-> Tache
	@ManyToOne
	@JoinColumn(name = "affaire_id")
	private Affaire affaireFK2;

	// ManyToOne Tribunal <-> Tache
	@ManyToOne
	@JoinColumn(name = "tribunal_id")
	private Tribunal tribunalFK;

	// OneToMany Phase <-> Tache
	@OneToMany(mappedBy = "tache_fk")
	@Transient
	private List<Phase> phases = new ArrayList<>();

	// Constructeurs :

	public Tache() {
	}

	public Tache(Date dateCreation, String titreTache, String descriptionTache, boolean statutAudience,
			Utilisateur utilisateurFK, Affaire affaireFK2, Tribunal tribunalFK, List<Phase> phases) {
		this.dateCreation = dateCreation;
		this.titreTache = titreTache;
		this.descriptionTache = descriptionTache;
		this.statutAudience = statutAudience;
		this.utilisateurFK = utilisateurFK;
		this.affaireFK2 = affaireFK2;
		this.tribunalFK = tribunalFK;
		this.phases = phases;
	}

	// Getters et Setters :
	public Long getIdTache() {
		return idTache;
	}

	public void setIdTache(Long idTache) {
		this.idTache = idTache;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getTitreTache() {
		return titreTache;
	}

	public void setTitreTache(String titreTache) {
		this.titreTache = titreTache;
	}

	public String getDescriptionTache() {
		return descriptionTache;
	}

	public void setDescriptionTache(String descriptionTache) {
		this.descriptionTache = descriptionTache;
	}

	public boolean isStatutAudience() {
		return statutAudience;
	}

	public void setStatutAudience(boolean statutAudience) {
		this.statutAudience = statutAudience;
	}

	public Utilisateur getUtilisateurFK() {
		return utilisateurFK;
	}

	public void setUtilisateurFK(Utilisateur utilisateurFK) {
		this.utilisateurFK = utilisateurFK;
	}

	public Affaire getAffaireFK2() {
		return affaireFK2;
	}

	public void setAffaireFK2(Affaire affaireFK2) {
		this.affaireFK2 = affaireFK2;
	}

	public Tribunal getTribunalFK() {
		return tribunalFK;
	}

	public void setTribunalFK(Tribunal tribunalFK) {
		this.tribunalFK = tribunalFK;
	}

	public List<Phase> getPhases() {
		return phases;
	}

	public void setPhases(List<Phase> phases) {
		this.phases = phases;
	}

	// To String :
	@Override
	public String toString() {
		return "Tache [idTache=" + idTache + ", dateCreation=" + dateCreation + ", titreTache=" + titreTache
				+ ", descriptionTache=" + descriptionTache + ", statutAudience=" + statutAudience + ", utilisateurFK="
				+ utilisateurFK + ", affaireFK2=" + affaireFK2 + ", tribunalFK=" + tribunalFK + ", phases=" + phases
				+ "]";
	}

}
