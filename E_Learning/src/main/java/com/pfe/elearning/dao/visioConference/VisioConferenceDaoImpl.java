package com.pfe.elearning.dao.visioConference;

import java.util.List;

import javax.persistence.Query;

import com.pfe.elearning.dao.genericDao.GenericDaoImpl;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.entities.VisioConference;

public class VisioConferenceDaoImpl extends GenericDaoImpl<VisioConference> implements IVisioConferenceDao {

	@Override
	public List<Utilisateur> listeDesParticipantParVisioConf(Long idVisioConf) {
		Query query = em.createQuery("select u from VisionConference v join v.listeParticipants u where u.idUtilisateur = :x");
		query.setParameter("x", idVisioConf);
		return query.getResultList();
	}

}
