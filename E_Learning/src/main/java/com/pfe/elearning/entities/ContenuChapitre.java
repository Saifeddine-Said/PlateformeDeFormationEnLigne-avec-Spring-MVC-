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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Type;

@Entity
public class ContenuChapitre implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idContenu;
	private String titreContenu;
	@Column(name="contenu")
	@Type(type="text")
	private String contenu;
	private String numContenu;
	private Date dateCreation;
	private Date dateDerinerModification;
	
	@OneToMany(mappedBy="contenuChapitre")
	private Collection<Ressources>ressources;
	
	@ManyToOne
	@JoinColumn(name="idChapitre")
	private Chapitres chapitre;

	public Chapitres getChapitre() {
		return chapitre;
	}

	public void setChapitre(Chapitres chapitre) {
		this.chapitre = chapitre;
	}

	public ContenuChapitre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContenuChapitre(String titreContenu, String contenu, String numContenu, Date dateCreation, Date dateDerinerModification) {
		super();
		this.titreContenu = titreContenu;
		this.contenu = contenu;
		this.numContenu = numContenu;
		this.dateCreation = dateCreation;
		this.dateDerinerModification = dateDerinerModification;
	}

	public Long getIdContenu() {
		return idContenu;
	}

	public void setIdContenu(Long idContenu) {
		this.idContenu = idContenu;
	}

	public String getTitreContenu() {
		return titreContenu;
	}

	public void setTitreContenu(String titreContenu) {
		this.titreContenu = titreContenu;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getNumContenu() {
		return numContenu;
	}

	public void setNumContenu(String numContenu) {
		this.numContenu = numContenu;
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
	@JsonIgnore
	public Collection<Ressources> getRessources() {
		return ressources;
	}

	public void setRessources(Collection<Ressources> ressources) {
		this.ressources = ressources;
	}

	
}
