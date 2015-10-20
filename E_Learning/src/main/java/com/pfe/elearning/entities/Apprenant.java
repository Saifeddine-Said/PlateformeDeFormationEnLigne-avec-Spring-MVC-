package com.pfe.elearning.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Apprenant extends Utilisateur implements Serializable {

	@ManyToMany(mappedBy = "apprenants")
	private Collection<Module> modules;
	@ManyToMany(mappedBy="apprenants")
	private Collection<Examen>apprenants;

	public Apprenant() {
		super();
	}

	public Apprenant(String nom, String prenom, String email,
			Date dateNaissance, String pays, String ville,
			Date dateInscription, byte[] photo, String motDePasse,
			boolean valide, boolean etat, String apropos, String sexe,
			String type) {
		super(nom, prenom, email, dateNaissance, pays, ville, dateInscription,
				photo, motDePasse, valide, etat, apropos, sexe, type);
	}

	public Collection<Module> getModules() {
		return modules;
	}

	public void setModules(Collection<Module> modules) {
		this.modules = modules;
	}

	public Collection<Examen> getApprenants() {
		return apprenants;
	}

	public void setApprenants(Collection<Examen> apprenants) {
		this.apprenants = apprenants;
	}


}
