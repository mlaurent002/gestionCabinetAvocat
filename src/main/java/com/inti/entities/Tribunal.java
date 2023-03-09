package com.inti.entities;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TRIBUNAUX", schema = "gestion_avocat")
public class Tribunal implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTribunal;
	private String adresse;
	private Double fax;
	private Double tel;
	private String region;
	@OneToMany(mappedBy="tache_fk")
	@Transient
	private List<Tache> taches = new ArrayList<>();
	
	
	//geters et seters
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Double getFax() {
		return fax;
	}
	public void setFax(Double fax) {
		this.fax = fax;
	}
	public Double getTel() {
		return tel;
	}
	public void setTel(Double tel) {
		this.tel = tel;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public List<Tache> getTaches() {
		return taches;
	}
	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}
	
	
	
	public Long getIdTribunal() {
		return idTribunal;
	}
	public void setIdTribunal(Long idTribunal) {
		this.idTribunal = idTribunal;
	}
	// constructeurs
	public Tribunal(String adresse, Double fax, Double tel, String region, List<Tache> taches) {
		
		this.adresse = adresse;
		this.fax = fax;
		this.tel = tel;
		this.region = region;
		this.taches = taches;
	}
	
	public Tribunal() {
		
	}
	@Override
	public String toString() {
		return "Tribunal [idTribunal=" + idTribunal + ", adresse=" + adresse + ", fax=" + fax + ", tel=" + tel
				+ ", region=" + region + "]";
	}
	
	//ToString
	
	
	
	
	
	
	
	
	
	
	
	

}
