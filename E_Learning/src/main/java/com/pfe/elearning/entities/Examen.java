package com.pfe.elearning.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import org.hibernate.annotations.Type;
@Entity
public class Examen implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idExamen;
	private String titreExamen;
	@Column(name="descriptionExamen")
	@Type(type="text")
	private String descriptionExamen;
	private String typeExamen;
	private double scoreMini;
	
	@ManyToOne
	@JoinColumn(name="idChapitre")
	private Chapitres chapitres;
	
	@OneToMany(mappedBy="examen")
	private Collection<Questions> questions;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Module module;
	
	@ManyToMany
	@JoinTable(name = "ApprenantExamen", joinColumns = @JoinColumn(name = "idExamen"), inverseJoinColumns = @JoinColumn(name = "idUtlisateur"))
	private Collection<Apprenant> apprenants;

	public Examen() {
		super();
	}

	public Examen(String titreExamen, String descriptionExamen, String typeExamen, double scoreMini) {
		super();
		this.titreExamen = titreExamen;
		this.descriptionExamen = descriptionExamen;
		this.typeExamen = typeExamen;
		this.scoreMini = scoreMini;
	}

	public Long getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(Long idExamen) {
		this.idExamen = idExamen;
	}

	public String getTitreExamen() {
		return titreExamen;
	}

	public void setTitreExamen(String titreExamen) {
		this.titreExamen = titreExamen;
	}

	public String getDescriptionExamen() {
		return descriptionExamen;
	}

	public void setDescriptionExamen(String descriptionExamen) {
		this.descriptionExamen = descriptionExamen;
	}

	public String getTypeExamen() {
		return typeExamen;
	}

	public void setTypeExamen(String typeExamen) {
		this.typeExamen = typeExamen;
	}

	public Chapitres getChapitres() {
		return chapitres;
	}

	public void setChapitres(Chapitres chapitres) {
		this.chapitres = chapitres;
	}

	public Collection<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(Collection<Questions> questions) {
		this.questions = questions;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public double getScoreMini() {
		return scoreMini;
	}

	public void setScoreMini(double scoreMini) {
		this.scoreMini = scoreMini;
	}

	

}
