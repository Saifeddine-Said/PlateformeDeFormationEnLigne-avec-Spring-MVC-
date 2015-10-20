package com.pfe.elearning.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Tuteur extends Utilisateur implements Serializable {

	@OneToMany(mappedBy = "tuteurCreateur")
	private Collection<VisioConference> visioConferences;

	@ManyToMany(mappedBy = "moduleTuteurs")
	private Collection<Module> moduleTuteurs;

	public Tuteur() {
		super();
	}

	public Tuteur(String nom, String prenom, String email, Date dateNaissance,
			String pays, String ville, Date dateInscription, byte[] photo,
			String motDePasse, boolean valide, boolean etat, String apropos,
			String sexe, String type) {
		super(nom, prenom, email, dateNaissance, pays, ville, dateInscription,
				photo, motDePasse, valide, etat, apropos, sexe, type);
	}

	public Collection<VisioConference> getVisioConferences() {
		return visioConferences;
	}

	public void setVisioConferences(Collection<VisioConference> visioConferences) {
		this.visioConferences = visioConferences;
	}

	public Collection<Module> getModuleTuteurs() {
		return moduleTuteurs;
	}

	public void setModuleTuteurs(Collection<Module> moduleTuteurs) {
		this.moduleTuteurs = moduleTuteurs;
	}

}
