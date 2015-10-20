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
public class Fichiers implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFichier;
	private String titreFichier;
	@Column(name="descriptionFichier")
	@Type(type="text")
	private String descriptionFichier;
	private Date dateDepot;
	private byte[] fichier;

	@ManyToOne
	@JoinColumn(name = "idEspace")
	private EspaceUtilisateur espaceUtilisateur;

	public Fichiers(String titreFichier, String descriptionFichier,
			Date dateDepot, byte[] fichier) {
		super();
		this.titreFichier = titreFichier;
		this.descriptionFichier = descriptionFichier;
		this.dateDepot = dateDepot;
		this.fichier = fichier;
	}

	public Fichiers() {
		super();
	}

	public Long getIdFichier() {
		return idFichier;
	}

	public void setIdFichier(Long idFichier) {
		this.idFichier = idFichier;
	}

	public String getTitreFichier() {
		return titreFichier;
	}

	public void setTitreFichier(String titreFichier) {
		this.titreFichier = titreFichier;
	}

	public String getDescriptionFichier() {
		return descriptionFichier;
	}

	public void setDescriptionFichier(String descriptionFichier) {
		this.descriptionFichier = descriptionFichier;
	}

	public Date getDateDepot() {
		return dateDepot;
	}

	public void setDateDepot(Date dateDepot) {
		this.dateDepot = dateDepot;
	}

	public byte[] getFichier() {
		return fichier;
	}

	public void setFichier(byte[] fichier) {
		this.fichier = fichier;
	}

	public EspaceUtilisateur getEspaceUtilisateur() {
		return espaceUtilisateur;
	}

	public void setEspaceUtilisateur(EspaceUtilisateur espaceUtilisateur) {
		this.espaceUtilisateur = espaceUtilisateur;
	}

}
