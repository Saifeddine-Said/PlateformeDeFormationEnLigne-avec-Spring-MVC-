package com.pfe.elearning.metier.acteurs.internaute;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.acteurs.internaute.ActeurInternauteDaoImpl;
import com.pfe.elearning.entities.Utilisateur;

@Transactional
public class MetierActeurInternauteImpl implements IMetierActeurInternaute {
	
	private ActeurInternauteDaoImpl dao;
	



	public void setDao(ActeurInternauteDaoImpl dao) {
		this.dao = dao;
	}




	@Override
	public Utilisateur checkUserLogin(String mail, String passw) {
		return dao.checkUserLogin(mail, passw);
	}

}
