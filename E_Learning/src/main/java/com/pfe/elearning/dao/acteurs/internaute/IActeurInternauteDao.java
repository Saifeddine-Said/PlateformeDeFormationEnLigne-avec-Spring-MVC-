package com.pfe.elearning.dao.acteurs.internaute;

import com.pfe.elearning.entities.Utilisateur;

public interface IActeurInternauteDao {
	
	public Utilisateur checkUserLogin(String mail, String passw);

}
