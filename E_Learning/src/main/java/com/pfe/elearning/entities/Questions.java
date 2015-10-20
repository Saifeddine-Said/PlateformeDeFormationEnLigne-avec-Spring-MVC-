package com.pfe.elearning.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Questions implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idQuestion;
	private String titreQuestion;
	private String question;
	private String numQuestion;
	private String typeQuestion;

	@OneToMany(mappedBy = "questions")
	private Collection<Reponses> reponses;

	@ManyToOne
	@JoinColumn(name = "idExamen")
	private Examen examen;

	public Questions() {
		super();
	}

	public Questions(String titreQuestion, String question, String numQuestion,
			String typeQuestion) {
		super();
		this.titreQuestion = titreQuestion;
		this.question = question;
		this.numQuestion = numQuestion;
		this.typeQuestion = typeQuestion;
	}

	public Long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(Long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getTitreQuestion() {
		return titreQuestion;
	}

	public void setTitreQuestion(String titreQuestion) {
		this.titreQuestion = titreQuestion;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getNumQuestion() {
		return numQuestion;
	}

	public void setNumQuestion(String numQuestion) {
		this.numQuestion = numQuestion;
	}

	public String getTypeQuestion() {
		return typeQuestion;
	}

	public void setTypeQuestion(String typeQuestion) {
		this.typeQuestion = typeQuestion;
	}

	public Collection<Reponses> getReponses() {
		return reponses;
	}

	public void setReponses(Collection<Reponses> reponses) {
		this.reponses = reponses;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

}
