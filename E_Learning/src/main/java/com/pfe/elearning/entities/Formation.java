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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Formation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFormation;
	@NotEmpty
	private String nomFormation;
	@NotEmpty
	@Column(name="descriptionFormation")
	@Type(type="text")
	private String descriptionFormation;
	private Date dateCreation;
	private Date dateDerinerModification;
	@Lob
	private byte[] photo;

	@LazyCollection(LazyCollectionOption.TRUE)
	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Coordinateur coordinateur;

	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonManagedReference
	@OneToMany(mappedBy = "formation")
	private Collection<Module> modules;

	@LazyCollection(LazyCollectionOption.TRUE)
	@OneToMany(mappedBy = "formation")
	private Collection<Evenement> evenements;

	public Formation() {
		super();
	}

	public Formation(String nomFormation, String descriptionFormation,
			Date dateCreation, Date dateDerinerModification, byte[] photo) {
		super();
		this.nomFormation = nomFormation;
		this.descriptionFormation = descriptionFormation;
		this.dateCreation = dateCreation;
		this.dateDerinerModification = dateDerinerModification;
		this.photo = photo;
	}

	public Long getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}

	public String getNomFormation() {
		return nomFormation;
	}

	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}

	public String getDescriptionFormation() {
		return descriptionFormation;
	}

	public void setDescriptionFormation(String descriptionFormation) {
		this.descriptionFormation = descriptionFormation;
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

	public Coordinateur getCoordinateur() {
		return coordinateur;
	}

	public void setCoordinateur(Coordinateur coordinateur) {
		this.coordinateur = coordinateur;
	}

	public Collection<Module> getModules() {
		return modules;
	}

	public void setModules(Collection<Module> modules) {
		this.modules = modules;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Collection<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(Collection<Evenement> evenements) {
		this.evenements = evenements;
	}
	
	@Transient
	public int nbrSujetsParModule() {
		int nbr = 0;
		for(Module m : getModules()) {
			nbr += m.getSujetForums().size();
		}
		return nbr;
	}
}
