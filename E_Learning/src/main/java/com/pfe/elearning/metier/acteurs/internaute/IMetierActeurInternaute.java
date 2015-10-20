package com.pfe.elearning.metier.acteurs.internaute;

import com.pfe.elearning.entities.Utilisateur;

public interface IMetierActeurInternaute {

	public Utilisateur checkUserLogin(String mail, String passw);
}
