package com.inti.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name ="AFFAIRES", schema ="gestion_cabinet_avocat_db")
public class Affaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAffaire;
	@Column(unique = true)
	private String reference;
	private String titre;
	private String description;
	private int statut;
	
	@OneToMany(mappedBy = "affaireFK")
	@Transient
	private List<Document> documents = new ArrayList<>();
	
	@OneToMany(mappedBy = "affaireFK2")
	@Transient
	private List<Tache> taches = new ArrayList<>();
	
	public Affaire() {
	}

	public Affaire(String reference, String titre, String description, int statut) {
		this.reference = reference;
		this.titre = titre;
		this.description = description;
		this.statut = statut;
	}

	public Affaire(String reference, String titre, String description, int statut, List<Document> documents) {
		this.reference = reference;
		this.titre = titre;
		this.description = description;
		this.statut = statut;
		this.documents = documents;
	}

	public Long getIdAffaire() {
		return idAffaire;
	}

	public void setIdAffaire(Long idAffaire) {
		this.idAffaire = idAffaire;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	@Override
	public String toString() {
		return "Affaire [idAffaire=" + idAffaire + ", reference=" + reference + ", titre=" + titre + ", description="
				+ description + ", statut=" + statut + "]";
	}
	
}
