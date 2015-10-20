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
public class SujetForum implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSujet;
	private String titreSujet;
	@Column(name = "sujet")
	@Type(type = "text")
	private String sujet;
	private Date datePublication;

	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateur;

	@OneToMany(mappedBy = "sujetForum")
	private Collection<MessagesForum> messagesForums;

	@ManyToOne
	@JoinColumn(name = "idModule")
	private Module module;

	public SujetForum(String titreSujet, String sujet, Date datePublication) {
		super();
		this.titreSujet = titreSujet;
		this.sujet = sujet;
		this.datePublication = datePublication;
	}

	public SujetForum() {
		super();
	}

	public Long getIdSujet() {
		return idSujet;
	}

	public void setIdSujet(Long idSujet) {
		this.idSujet = idSujet;
	}

	public String getTitreSujet() {
		return titreSujet;
	}

	public void setTitreSujet(String titreSujet) {
		this.titreSujet = titreSujet;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Collection<MessagesForum> getMessagesForums() {
		return messagesForums;
	}

	public void setMessagesForums(Collection<MessagesForum> messagesForums) {
		this.messagesForums = messagesForums;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

}
