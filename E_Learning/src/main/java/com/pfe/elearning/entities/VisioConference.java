package com.pfe.elearning.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class VisioConference implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVisioConference;
	private String titreVisioConference;
	private String descriptionVisionCoference;
	private Date dateVisionCoference;

	@ManyToMany(mappedBy = "participantVisioConf")
	private Collection<Utilisateur> listeParticipants;

	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Tuteur tuteurCreateur;

	public VisioConference(String titreVisioConference,
			String descriptionVisionCoference, Date dateVisionCoference) {
		super();
		this.titreVisioConference = titreVisioConference;
		this.descriptionVisionCoference = descriptionVisionCoference;
		this.dateVisionCoference = dateVisionCoference;
	}

	public VisioConference() {
		super();
	}

	public Long getIdVisioConference() {
		return idVisioConference;
	}

	public void setIdVisioConference(Long idVisioConference) {
		this.idVisioConference = idVisioConference;
	}

	public String getTitreVisioConference() {
		return titreVisioConference;
	}

	public void setTitreVisioConference(String titreVisioConference) {
		this.titreVisioConference = titreVisioConference;
	}

	public String getDescriptionVisionCoference() {
		return descriptionVisionCoference;
	}

	public void setDescriptionVisionCoference(String descriptionVisionCoference) {
		this.descriptionVisionCoference = descriptionVisionCoference;
	}

	public Date getDateVisionCoference() {
		return dateVisionCoference;
	}

	public void setDateVisionCoference(Date dateVisionCoference) {
		this.dateVisionCoference = dateVisionCoference;
	}

	public Tuteur getTuteurCreateur() {
		return tuteurCreateur;
	}

	public void setTuteurCreateur(Tuteur tuteurCreateur) {
		this.tuteurCreateur = tuteurCreateur;
	}

	public Collection<Utilisateur> getListeParticipants() {
		return listeParticipants;
	}

	public void setListeParticipants(Collection<Utilisateur> listeParticipants) {
		this.listeParticipants = listeParticipants;
	}

}
