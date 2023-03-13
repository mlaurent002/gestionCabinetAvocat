package com.inti.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "DOCUMENTS", schema = "gestion_cabinet_avocat_db")
public class Document implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDocument;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private String nom;
	private String description;
	@Lob
	private byte[] documentFile;

	@ManyToOne
	@JoinColumn(name = "id_affaire")
	private Affaire affaireFK;

	public Document() {
	}

	public Document(Date dateCreation, String nom, String description, byte[] documentFile) {
		this.dateCreation = dateCreation;
		this.nom = nom;
		this.description = description;
		this.documentFile = documentFile;
	}

	public Document(Date dateCreation, String nom, String description, byte[] documentFile, Affaire affaireFK) {
		this.dateCreation = dateCreation;
		this.nom = nom;
		this.description = description;
		this.documentFile = documentFile;
		this.affaireFK = affaireFK;
	}

	public Long getIdDocument() {
		return idDocument;
	}

	public byte[] getDocumentFile() {
		return documentFile;
	}

	public void setDocumentFile(byte[] documentFile) {
		this.documentFile = documentFile;
	}

	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Affaire getAffaireFK() {
		return affaireFK;
	}

	public void setAffaireFK(Affaire affaireFK) {
		this.affaireFK = affaireFK;
	}

	@Override
	public String toString() {
		return "Document [idDocument=" + idDocument + ", dateCreation=" + dateCreation + ", nom=" + nom
				+ ", description=" + description + ", documentFile=" + Arrays.toString(documentFile) + ", affaireFK="
				+ affaireFK + "]";
	}

}
