package com.pfe.elearning.metier.visioConference;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.visioConference.VisioConferenceDaoImpl;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.entities.VisioConference;

@Transactional
public class MetierVisioConferenceImpl implements IMetierVisioConference {

	private VisioConferenceDaoImpl dao;

	public void setDao(VisioConferenceDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public VisioConference inserer(VisioConference entity) {
		return dao.inserer(entity);
	}

	@Override
	public VisioConference modifier(VisioConference entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<VisioConference> selectAll() {
		return dao.selectAll();
	}

	@Override
	public VisioConference findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Utilisateur> listeDesParticipantParVisioConf(Long idVisioConf) {
		return dao.listeDesParticipantParVisioConf(idVisioConf);
	}

}
