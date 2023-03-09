package com.inti.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "PHASES", schema = "gestion_avocat")
public class Phase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPhase;
	private String nom;
	private Date dateDebut;
	private Date dateFin;
	@ManyToOne
	@JoinColumn(name="id_tache")
	private Tache tache_fk;
	
	
	
	//constructeurs
	public Phase(String nom, Date dateDebut, Date dateFin,Tache tache) {
		
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.tache_fk=tache;
		
	}


	public Phase() {
		
	}
	//geter et seter

	public Long getIdPhase() {
		return idPhase;
	}


	public void setIdPhase(Long idPhase) {
		this.idPhase = idPhase;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public Tache getTache_fk() {
		return tache_fk;
	}


	public void setTache_fk(Tache tache_fk) {
		this.tache_fk = tache_fk;
	}


	@Override
	public String toString() {
		return "Phase [idPhase=" + idPhase + ", nom=" + nom + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}
	


	

}
