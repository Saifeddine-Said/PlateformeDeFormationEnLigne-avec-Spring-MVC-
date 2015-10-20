package com.pfe.elearning.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Type;

@Entity
public class Chapitres implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idChapitre;
	private String titreChapitre;
	@Column(name="discriptionChapitre")
	@Type(type="text")
	private String discriptionChapitre;
	private String numChapitre;
	private Date dateCreation;
	private Date dateDerinerModification;

	@ManyToOne
	@JoinColumn(name = "idModule")
	private Module module;

	@OneToMany(fetch = FetchType.EAGER,mappedBy = "chapitre")
	private Collection<ContenuChapitre> contenuChapitres;

	@OneToMany(mappedBy = "chapitres")
	private Collection<Examen> examens;

	@OneToMany(mappedBy = "chapitres")
	private Collection<FAQ> faqs;

	public Chapitres() {
		super();
	}

	public Chapitres(String titreChapitre, String discriptionChapitre, String numChapitre, Date dateCreation, Date dateDerinerModification) {
		super();
		this.titreChapitre = titreChapitre;
		this.discriptionChapitre = discriptionChapitre;
		this.numChapitre = numChapitre;
		this.dateCreation = dateCreation;
		this.dateDerinerModification = dateDerinerModification;
	}

	public Long getIdChapitre() {
		return idChapitre;
	}

	public void setIdChapitre(Long idChapitre) {
		this.idChapitre = idChapitre;
	}

	public String getTitreChapitre() {
		return titreChapitre;
	}

	public void setTitreChapitre(String titreChapitre) {
		this.titreChapitre = titreChapitre;
	}

	public String getDiscriptionChapitre() {
		return discriptionChapitre;
	}

	public void setDiscriptionChapitre(String discriptionChapitre) {
		this.discriptionChapitre = discriptionChapitre;
	}

	public String getNumChapitre() {
		return numChapitre;
	}

	public void setNumChapitre(String numChapitre) {
		this.numChapitre = numChapitre;
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
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	@JsonIgnore
	public Collection<ContenuChapitre> getContenuChapitres() {
		return contenuChapitres;
	}

	public void setContenuChapitres(Collection<ContenuChapitre> contenuChapitres) {
		this.contenuChapitres = contenuChapitres;
	}

	@JsonIgnore
	public Collection<Examen> getExamens() {
		return examens;
	}

	public void setExamens(Collection<Examen> examens) {
		this.examens = examens;
	}

	@JsonIgnore
	public Collection<FAQ> getFaqs() {
		return faqs;
	}

	public void setFaqs(Collection<FAQ> faqs) {
		this.faqs = faqs;
	}

}
