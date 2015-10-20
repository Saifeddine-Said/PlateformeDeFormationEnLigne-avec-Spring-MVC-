package com.pfe.elearning.dao.tuteur;

import java.util.List;

import javax.persistence.Query;

import com.pfe.elearning.dao.genericDao.GenericDaoImpl;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.Tuteur;
import com.pfe.elearning.entities.VisioConference;

public class TuteurDaoImpl extends GenericDaoImpl<Tuteur> implements ITuteurDao {

	@Override
	public List<VisioConference> getListVisioConferences(Long idUtilisateur) {
		Query query=em.createQuery("Select v from Tuteur t join t.visioConferences v where t.idUtilisateur=:x");
		query.setParameter("x", idUtilisateur);
		return query.getResultList();
	}

	@Override
	public List<Module> getListModule(Long idUtilisateur) {
		Query query=em.createQuery("Select m from Tuteur t join t.moduleTuteurs m where t.idUtilisateur=:x");
		query.setParameter("x", idUtilisateur);
		return query.getResultList();
	}

}
