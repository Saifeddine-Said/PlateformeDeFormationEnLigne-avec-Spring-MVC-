package com.pfe.elearning.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

@Entity
public class Evenement implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvenement;
	private String titreEvenement;
	@Column(name="descriptionEvenement")
	@Type(type="text")
	private String descriptionEvenement;
	private Date dateDebut;
	private Date dateFin;
	private Date dateCreation;
	private String lieuEvenement;

	@ManyToMany(mappedBy = "participationEvenement")
	private Collection<Utilisateur> listeParticipants;

	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateurCreateur;

	@ManyToOne
	@JoinColumn(name = "idFormation")
	private Formation formation;

	public Evenement(String titreEvenement, String descriptionEvenement,
			Date dateDebut, Date dateFin, Date dateCreation,
			String lieuEvenement) {
		super();
		this.titreEvenement = titreEvenement;
		this.descriptionEvenement = descriptionEvenement;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dateCreation = dateCreation;
		this.lieuEvenement = lieuEvenement;
	}

	public Evenement() {
		super();
	}

	public Long getIdEvenement() {
		return idEvenement;
	}

	public void setIdEvenement(Long idEvenement) {
		this.idEvenement = idEvenement;
	}

	public String getTitreEvenement() {
		return titreEvenement;
	}

	public void setTitreEvenement(String titreEvenement) {
		this.titreEvenement = titreEvenement;
	}

	public String getDescriptionEvenement() {
		return descriptionEvenement;
	}

	public void setDescriptionEvenement(String descriptionEvenement) {
		this.descriptionEvenement = descriptionEvenement;
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

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getLieuEvenement() {
		return lieuEvenement;
	}

	public void setLieuEvenement(String lieuEvenement) {
		this.lieuEvenement = lieuEvenement;
	}

	public Utilisateur getUtilisateurCreateur() {
		return utilisateurCreateur;
	}

	public void setUtilisateurCreateur(Utilisateur utilisateurCreateur) {
		this.utilisateurCreateur = utilisateurCreateur;
	}

	public Collection<Utilisateur> getListeParticipants() {
		return listeParticipants;
	}

	public void setListeParticipants(Collection<Utilisateur> listeParticipants) {
		this.listeParticipants = listeParticipants;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}
}
