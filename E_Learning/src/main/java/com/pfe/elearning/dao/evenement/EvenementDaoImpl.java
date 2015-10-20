package com.pfe.elearning.dao.evenement;

import java.util.List;

import javax.persistence.Query;

import com.pfe.elearning.dao.genericDao.GenericDaoImpl;
import com.pfe.elearning.entities.Evenement;
import com.pfe.elearning.entities.Utilisateur;

public class EvenementDaoImpl extends GenericDaoImpl<Evenement> implements IEvenementDao {

	@Override
	public List<Utilisateur> listeParticipantParEvenement(Long idEvenement) {
		Query query = em.createQuery("select u from Evenement e join e.listeParticipants u where u.idUtilisateur = :x");
		query.setParameter("x", idEvenement);
		return query.getResultList();
	}

}
