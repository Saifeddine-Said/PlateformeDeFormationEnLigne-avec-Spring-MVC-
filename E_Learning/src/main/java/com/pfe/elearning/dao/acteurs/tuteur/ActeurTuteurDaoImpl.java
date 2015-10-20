package com.pfe.elearning.dao.acteurs.tuteur;

import java.util.List;

import com.pfe.elearning.dao.module.ModuleDaoImpl;
import com.pfe.elearning.dao.sujetForum.SujetForumDaoImpl;
import com.pfe.elearning.dao.visioConference.VisioConferenceDaoImpl;
import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.MessagesForum;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.entities.VisioConference;

public class ActeurTuteurDaoImpl implements IActeurTuteurDao {
	
	private ModuleDaoImpl daoModule;
//	private EspaceUtilisateurDaoImpl daoEspace;
	private VisioConferenceDaoImpl daoVisioConf;
	private SujetForumDaoImpl daoForum;

	@Override
	public VisioConference insererVisioConference(VisioConference entity) {
		return daoVisioConf.inserer(entity);
	}

	@Override
	public VisioConference modifierVisioConference(VisioConference entity) {
		return daoVisioConf.modifier(entity);
	}

	@Override
	public void supprimerVisioConference(Long id) {
		daoVisioConf.supprimer(id);
	}

	@Override
	public List<VisioConference> selectAllVisioConferences() {
		return daoVisioConf.selectAll();
	}

	@Override
	public VisioConference findVisioConferenceById(Long id) {
		return daoVisioConf.findById(id);
	}

	@Override
	public List<Module> selectAllModules() {
		return daoModule.selectAll();
	}

	@Override
	public Module findModuleById(Long id) {
		return daoModule.findById(id);
	}

	@Override
	public List<Chapitres> listeChapitresParModule(Long idModule) {
		return daoModule.listeChapitresParModule(idModule);
	}

	@Override
	public List<Utilisateur> listeDesParticipantParVisioConf(
			Long idVisioConference) {
		return daoVisioConf.listeDesParticipantParVisioConf(idVisioConference);
	}

	@Override
	public List<MessagesForum> getListMessageForum(Long idForum) {
		return daoForum.getListMessageForum(idForum);
	}

	
}
