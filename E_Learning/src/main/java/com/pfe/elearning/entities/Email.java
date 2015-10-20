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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

@Entity
public class Email implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmail;
	private String objetEmail;
	@Column(name="sujetEmail")
	@Type(type="text")
	private String sujetEmail;
	private boolean lu;
	private Date dateEnvoi;


	@OneToMany(mappedBy = "email")
	private Collection<PieceJointeEmail> piecesJointes;

	@ManyToOne
	@JoinColumn(name = "idUtilisateurExp")
	private Utilisateur utilisateurExpeditreur;

	@ManyToOne
	@JoinColumn(name = "idUtilisateurDest")
	private Utilisateur utilisateurDestinataire;

	public Email(String objetEmail, String sujetEmail, boolean lu,
			Date dateEnvoi) {
		super();
		this.objetEmail = objetEmail;
		this.sujetEmail = sujetEmail;
		this.lu = lu;
		this.dateEnvoi = dateEnvoi;
	}

	public Email() {
		super();
	}

	public Long getIdEmail() {
		return idEmail;
	}

	public void setIdEmail(Long idEmail) {
		this.idEmail = idEmail;
	}

	public String getObjetEmail() {
		return objetEmail;
	}

	public void setObjetEmail(String objetEmail) {
		this.objetEmail = objetEmail;
	}

	public String getSujetEmail() {
		return sujetEmail;
	}

	public void setSujetEmail(String sujetEmail) {
		this.sujetEmail = sujetEmail;
	}

	public boolean isLu() {
		return lu;
	}

	public void setLu(boolean lu) {
		this.lu = lu;
	}

	public Collection<PieceJointeEmail> getPiecesJointes() {
		return piecesJointes;
	}

	public void setPiecesJointes(Collection<PieceJointeEmail> piecesJointes) {
		this.piecesJointes = piecesJointes;
	}

	public Utilisateur getUtilisateurExpeditreur() {
		return utilisateurExpeditreur;
	}

	public void setUtilisateurExpeditreur(Utilisateur utilisateurExpeditreur) {
		this.utilisateurExpeditreur = utilisateurExpeditreur;
	}

	public Utilisateur getUtilisateurDestinataire() {
		return utilisateurDestinataire;
	}

	public void setUtilisateurDestinataire(Utilisateur utilisateurDestinataire) {
		this.utilisateurDestinataire = utilisateurDestinataire;
	}

	public Date getDateEnvoi() {
		return dateEnvoi;
	}
	
	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}
}
