package com.pfe.elearning.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;
@Entity
public class Notification implements Serializable{
	@Id
	private Long idNotification;
	private String titre;
	@Column(name="description")
	@Type(type="text")
	private String description;
	private Date dateCreation;
	private Boolean lu;
	
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	private Utilisateur utilisateur;
	
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notification(Long idNotification, String titre, String description,
			Date dateCreation, Boolean lu) {
		super();
		this.idNotification = idNotification;
		this.titre = titre;
		this.description = description;
		this.dateCreation = dateCreation;
		this.lu = lu;
	}

	public Long getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(Long idNotification) {
		this.idNotification = idNotification;
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

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Boolean getLu() {
		return lu;
	}

	public void setLu(Boolean lu) {
		this.lu = lu;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	

}
