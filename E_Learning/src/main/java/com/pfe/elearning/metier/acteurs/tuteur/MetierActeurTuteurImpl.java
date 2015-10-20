package com.pfe.elearning.metier.acteurs.tuteur;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.acteurs.tuteur.ActeurTuteurDaoImpl;
import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.MessagesForum;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.entities.VisioConference;
@Transactional
public class MetierActeurTuteurImpl implements IMetierActeurTuteur {
	
	private ActeurTuteurDaoImpl dao;

	@Override
	public VisioConference insererVisioConference(VisioConference entity) {
		return dao.insererVisioConference(entity);
	}

	@Override
	public VisioConference modifierVisioConference(VisioConference entity) {
		return dao.modifierVisioConference(entity);
	}

	@Override
	public void supprimerVisioConference(Long idVisioConference) {
		dao.supprimerVisioConference(idVisioConference);
	}

	@Override
	public List<VisioConference> selectAllVisioConferences() {
		return dao.selectAllVisioConferences();
	}

	@Override
	public VisioConference findVisioConferenceById(Long idVisioConference) {
		return dao.findVisioConferenceById(idVisioConference);
	}

	@Override
	public List<Utilisateur> listeDesParticipantParVisioConf(
			Long idVisioConference) {
		return dao.listeDesParticipantParVisioConf(idVisioConference);
	}

	@Override
	public List<Module> selectAllModules() {
		return dao.selectAllModules();
	}

	@Override
	public Module findModuleById(Long id) {
		return dao.findModuleById(id);
	}

	@Override
	public List<Chapitres> listeChapitresParModule(Long idModule) {
		return dao.listeChapitresParModule(idModule);
	}

	@Override
	public List<MessagesForum> getListMessageForum(Long idForum) {
		return dao.getListMessageForum(idForum);
	}

	public void setDao(ActeurTuteurDaoImpl dao) {
		this.dao = dao;
	}

}
