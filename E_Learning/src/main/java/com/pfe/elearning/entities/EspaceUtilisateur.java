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
public class EspaceUtilisateur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEspace;
	private String nomEspace;
	@Column(name="descriptionEspace")
	@Type(type="text")
	private String descriptionEspace;
	private Date dateCreation;
	private boolean partage;

	@ManyToOne
	@JoinColumn(name = "ESP_PAR")
	private EspaceUtilisateur espaceParent;

	@OneToMany(mappedBy = "espaceUtilisateur")
	private Collection<Fichiers> listeFichiers;

	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	private Utilisateur proprietaire;

	public EspaceUtilisateur(String nomEspace, String descriptionEspace,
			Date dateCreation, boolean partage) {
		super();
		this.nomEspace = nomEspace;
		this.descriptionEspace = descriptionEspace;
		this.dateCreation = dateCreation;
		this.partage = partage;
	}

	public EspaceUtilisateur() {
		super();
	}

	public Long getIdEspace() {
		return idEspace;
	}

	public void setIdEspace(Long idEspace) {
		this.idEspace = idEspace;
	}

	public String getNomEspace() {
		return nomEspace;
	}

	public void setNomEspace(String nomEspace) {
		this.nomEspace = nomEspace;
	}

	public String getDescriptionEspace() {
		return descriptionEspace;
	}

	public void setDescriptionEspace(String descriptionEspace) {
		this.descriptionEspace = descriptionEspace;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public boolean isPartage() {
		return partage;
	}

	public void setPartage(boolean partage) {
		this.partage = partage;
	}

	public EspaceUtilisateur getEspaceParent() {
		return espaceParent;
	}

	public void setEspaceParent(EspaceUtilisateur espaceParent) {
		this.espaceParent = espaceParent;
	}

	@JsonIgnore
	public Collection<Fichiers> getListeFichiers() {
		return listeFichiers;
	}

	public void setListeFichiers(Collection<Fichiers> listeFichiers) {
		this.listeFichiers = listeFichiers;
	}

	@JsonIgnore
	public Utilisateur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Utilisateur proprietaire) {
		this.proprietaire = proprietaire;
	}

}
