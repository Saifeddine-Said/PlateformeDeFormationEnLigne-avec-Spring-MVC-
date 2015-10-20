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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

@Entity

public class Module implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idModule;
	
	private String nomModule;
	@Column(name="descriptionModule")
	@Type(type="text")
	private String descriptionModule;
	private String numModule;
	private Date dateCreation;
	private Date dateDerinerModification;
	@Lob
	private byte[] photo;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "idFormation")
	private Formation formation;

	@LazyCollection(LazyCollectionOption.TRUE)
	@OneToMany(mappedBy = "module")
	private Collection<Chapitres> chapitres;

	@LazyCollection(LazyCollectionOption.TRUE)
	@ManyToMany
	@JoinTable(name = "ModuleTuteur", joinColumns = @JoinColumn(name = "idModule"), inverseJoinColumns = @JoinColumn(name = "idUtilisateur"))
	private Collection<Tuteur> moduleTuteurs;

	@LazyCollection(LazyCollectionOption.TRUE)
	@ManyToMany
	@JoinTable(name = "ModuleApprenant", joinColumns = @JoinColumn(name = "idModule"), inverseJoinColumns = @JoinColumn(name = "idUtlisateur"))
	private Collection<Apprenant> apprenants;

	@LazyCollection(LazyCollectionOption.TRUE)
	@OneToMany(mappedBy = "module")
	private Collection<SujetForum> sujetForums;

	@ManyToOne
	@JoinColumn(name = "idConcepteur")
	private Concepteur concepteur;

	@ManyToOne
	@JoinColumn(name = "idCoordinateur")
	private Coordinateur coordinateur;

	public Module() {
		super();
	}

	public Module(String nomModule, String descriptionModule, String numModule,
			Date dateCreation, Date dateDerinerModification, byte[] photo) {
		super();
		this.nomModule = nomModule;
		this.descriptionModule = descriptionModule;
		this.numModule = numModule;
		this.dateCreation = dateCreation;
		this.dateDerinerModification = dateDerinerModification;
		this.photo = photo;
	}

	public Long getIdModule() {
		return idModule;
	}

	public void setIdModule(Long idModule) {
		this.idModule = idModule;
	}

	public String getNomModule() {
		return nomModule;
	}

	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
	}

	public String getDescriptionModule() {
		return descriptionModule;
	}

	public void setDescriptionModule(String descriptionModule) {
		this.descriptionModule = descriptionModule;
	}

	public String getNumModule() {
		return numModule;
	}

	public void setNumModule(String numModule) {
		this.numModule = numModule;
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
	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	@JsonIgnore
	public Collection<Chapitres> getChapitres() {
		return chapitres;
	}

	public void setChapitres(Collection<Chapitres> chapitres) {
		this.chapitres = chapitres;
	}
	@JsonIgnore
	public Collection<Apprenant> getApprenants() {
		return apprenants;
	}

	public void setApprenants(Collection<Apprenant> apprenants) {
		this.apprenants = apprenants;
	}
	@JsonIgnore
	public Collection<SujetForum> getSujetForums() {
		return sujetForums;
	}

	public void setSujetForums(Collection<SujetForum> sujetForums) {
		this.sujetForums = sujetForums;
	}

	@JsonIgnore
	public Collection<Tuteur> getModuleTuteurs() {
		return moduleTuteurs;
	}

	public void setModuleTuteurs(Collection<Tuteur> moduleTuteurs) {
		this.moduleTuteurs = moduleTuteurs;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	@JsonIgnore
	public Concepteur getConcepteur() {
		return concepteur;
	}

	public void setConcepteur(Concepteur concepteur) {
		this.concepteur = concepteur;
	}
	@JsonIgnore
	public Coordinateur getCoordinateur() {
		return coordinateur;
	}

	public void setCoordinateur(Coordinateur coordinateur) {
		this.coordinateur = coordinateur;
	}

}
