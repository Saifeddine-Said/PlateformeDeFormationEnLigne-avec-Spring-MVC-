package com.pfe.elearning.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Concepteur extends Utilisateur implements Serializable {

	@OneToMany(mappedBy = "concepteur")
	private Collection<Module> modules;

	public Collection<Module> getModules() {
		return modules;
	}

	public void setModules(Collection<Module> modules) {
		this.modules = modules;
	}

	public Concepteur() {
		super();
	}

	public Concepteur(String nom, String prenom, String email,
			Date dateNaissance, String pays, String ville,
			Date dateInscription, byte[] photo, String motDePasse,
			boolean valide, boolean etat, String apropos, String sexe, String type) {
		super(nom, prenom, email, dateNaissance, pays, ville, dateInscription,
				photo, motDePasse, valide, etat, apropos, sexe, type);
	}

}
