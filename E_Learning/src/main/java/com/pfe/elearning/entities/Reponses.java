package com.pfe.elearning.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reponses implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idReponse;
	private String titreReponse;
	private String reponse;
	private boolean reponseCorrecte;
	private String feedBack;
	private double poids;

	@ManyToOne
	@JoinColumn(name = "idQuestion")
	private Questions questions;

	public Reponses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reponses(String titreReponse, String reponse, boolean reponseCorrecte, String feedBack, double poids) {
		super();
		this.titreReponse = titreReponse;
		this.reponse = reponse;
		this.reponseCorrecte = reponseCorrecte;
		this.feedBack = feedBack;
		this.poids = poids;
	}

	public Long getIdReponse() {
		return idReponse;
	}

	public void setIdReponse(Long idReponse) {
		this.idReponse = idReponse;
	}

	public String getTitreReponse() {
		return titreReponse;
	}

	public void setTitreReponse(String titreReponse) {
		this.titreReponse = titreReponse;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public boolean isReponseCorrecte() {
		return reponseCorrecte;
	}

	public void setReponseCorrecte(boolean reponseCorrecte) {
		this.reponseCorrecte = reponseCorrecte;
	}

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public Questions getQuestions() {
		return questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

}
