package com.pfe.elearning.dao.acteurs.internaute;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pfe.elearning.entities.Utilisateur;

public class ActeurInternauteDaoImpl implements IActeurInternauteDao {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Utilisateur checkUserLogin(String mail, String passw) {
		Query query = em.createQuery("select u from Utilisateur u where u.email = :x and u.motDePasse = :y");
		query.setParameter("x", mail);
		query.setParameter("y", passw);
		if(query.getResultList().size() == 0)
			return null;
		return (Utilisateur)query.getResultList().get(0);
	}

}
