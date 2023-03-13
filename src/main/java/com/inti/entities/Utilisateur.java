package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "UTILISATEURS", schema = "gestion_cabinet_avocat_db")
public class Utilisateur implements Serializable {

	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
	@Column(unique = true)
	private String emailUtilisateur;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private String username;
	private String password;
	private boolean enable=true;

	// Relation entre les classes :
	// ManyToMany Utilisateur <-> Role
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PROFILS", joinColumns = @JoinColumn(name = "id_utilisateur", referencedColumnName = "idUtilisateur"), inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "idRole"))
	private Set<Role> roles = new HashSet<>();

	// OneToMany Utilisateur <-> Tâche
	@OneToMany(mappedBy = "utilisateurFK")
	@Transient
	private List<Tache> taches = new ArrayList<>();

	// Constructeurs
	public Utilisateur() {
	}

	
	public Utilisateur(String emailUtilisateur, String nomUtilisateur, String prenomUtilisateur, String username,
			String password, Set<Role> roles,boolean enable) {
		this.emailUtilisateur = emailUtilisateur;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.username = username;
		this.password = password;
		this.roles= roles;
		this.enable = enable;
	}

	public Utilisateur(String emailUtilisateur, String nomUtilisateur, String prenomUtilisateur, String username,
			String password, boolean enable, Set<Role> roles, List<Tache> taches) {
		this.emailUtilisateur = emailUtilisateur;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.username = username;
		this.password = password;
		this.enable = enable;
		this.roles = roles;
		this.taches = taches;
	}


	// Getters et Setters :
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getEmailUtilisateur() {
		return emailUtilisateur;
	}

	public void setEmailUtilisateur(String emailUtilisateur) {
		this.emailUtilisateur = emailUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", emailUtilisateur=" + emailUtilisateur
				+ ", nomUtilisateur=" + nomUtilisateur + ", prenomUtilisateur=" + prenomUtilisateur + ", username="
				+ username + ", password=" + password + ", enable=" + enable + ", roles=" + roles + ", taches=" + taches
				+ "]";
	}

	// To String


}
