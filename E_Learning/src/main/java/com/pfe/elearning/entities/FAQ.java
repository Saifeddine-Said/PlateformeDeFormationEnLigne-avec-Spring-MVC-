package com.pfe.elearning.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FAQ implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFaq;
	private String question;
	private String reponse;

	@ManyToOne
	@JoinColumn(name = "idChapitre")
	private Chapitres chapitres;

	public FAQ() {
		super();
	}

	public FAQ(String question, String reponse) {
		super();
		this.question = question;
		this.reponse = reponse;
	}

	public Long getIdFaq() {
		return idFaq;
	}

	public void setIdFaq(Long idFaq) {
		this.idFaq = idFaq;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public Chapitres getChapitres() {
		return chapitres;
	}

	public void setChapitres(Chapitres chapitres) {
		this.chapitres = chapitres;
	}

}
