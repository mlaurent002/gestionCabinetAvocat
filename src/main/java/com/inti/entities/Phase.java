package com.inti.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "PHASES", schema = "gestion_cabinet_avocat_db")
public class Phase implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPhase;
	private String nom;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	@ManyToOne
	@JoinColumn(name="id_tache")
	private Tache tache_fk;
	
	//constructeurs
	public Phase() {
	}
	
	public Phase(String nom, Date dateDebut, Date dateFin,Tache tache) {
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.tache_fk=tache;
		
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
