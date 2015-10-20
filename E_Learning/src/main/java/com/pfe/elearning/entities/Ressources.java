package com.pfe.elearning.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
public class Ressources implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRessource;
	private String titreRessource;
	@Column(name="descriptionRessource")
	@Type(type="text")
	private String descriptionRessource;
	private byte[] ressource;
	private String lienRessource;
	private Date dateCreation;
	private Date dateDerinerModification;

	@ManyToOne
	@JoinColumn(name = "idContenuChapitre")
	private ContenuChapitre contenuChapitre;

	public Ressources() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ressources(String titreRessource, String descriptionRessource, byte[] ressource, String lienRessource, Date dateCreation, Date dateDerinerModification) {
		super();
		this.titreRessource = titreRessource;
		this.descriptionRessource = descriptionRessource;
		this.ressource = ressource;
		this.lienRessource = lienRessource;
		this.dateCreation = dateCreation;
		this.dateDerinerModification = dateDerinerModification;
	}

	public Long getIdRessource() {
		return idRessource;
	}

	public void setIdRessource(Long idRessource) {
		this.idRessource = idRessource;
	}

	public String getTitreRessource() {
		return titreRessource;
	}

	public void setTitreRessource(String titreRessource) {
		this.titreRessource = titreRessource;
	}

	public String getDescriptionRessource() {
		return descriptionRessource;
	}

	public void setDescriptionRessource(String descriptionRessource) {
		this.descriptionRessource = descriptionRessource;
	}

	public byte[] getRessource() {
		return ressource;
	}

	public void setRessource(byte[] ressource) {
		this.ressource = ressource;
	}

	public String getLienRessource() {
		return lienRessource;
	}

	public void setLienRessource(String lienRessource) {
		this.lienRessource = lienRessource;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateDerinerModification() {
		return dateDerinerModification;
	}

	public void setDateDerinerModification(Date dateDerinerModification) {
		this.dateDerinerModification = dateDerinerModification;
	}

	public ContenuChapitre getContenuChapitre() {
		return contenuChapitre;
	}

	public void setContenuChapitre(ContenuChapitre contenuChapitre) {
		this.contenuChapitre = contenuChapitre;
	}

}
