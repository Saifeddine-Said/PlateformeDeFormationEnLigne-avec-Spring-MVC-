package com.pfe.elearning.dao.acteurs.apprenant;

import java.util.List;

import com.pfe.elearning.dao.formation.FormationDaoImpl;
import com.pfe.elearning.dao.messagesForum.MessagesForumDaoImpl;
import com.pfe.elearning.dao.module.ModuleDaoImpl;
import com.pfe.elearning.dao.sujetForum.SujetForumDaoImpl;
import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.MessagesForum;
import com.pfe.elearning.entities.Module;

public class ActeurApprenantDaoImpl implements IActeurApprenantDao {
	
	private FormationDaoImpl daoFormation;
	private ModuleDaoImpl daoModule;
	private MessagesForumDaoImpl daoMessagesForum;
	private SujetForumDaoImpl daoForum;
	
	@Override
	public List<Formation> selectAllFormations() {
		return daoFormation.selectAll();
	}

	@Override
	public Formation findFormationById(Long id) {
		return daoFormation.findById(id);
	}

	@Override
	public List<Module> getListModulesParFormation(Long idFormation) {
		return daoFormation.getListModules(idFormation);
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
	public MessagesForum insererMessagesForum(MessagesForum entity) {
		return daoMessagesForum.inserer(entity);
	}

	@Override
	public MessagesForum modifierMessagesForum(MessagesForum entity) {
		return daoMessagesForum.modifier(entity);
	}

	@Override
	public void supprimerMessagesForum(Long id) {
		daoMessagesForum.supprimer(id);
	}

	@Override
	public List<MessagesForum> selectAllMessagesForum() {
		return daoMessagesForum.selectAll();
	}

	@Override
	public MessagesForum findMessagesForumById(Long id) {
		return daoMessagesForum.findById(id);
	}

	@Override
	public List<MessagesForum> getListMessageForumParForum(Long idSujet) {
		return daoForum.getListMessageForum(idSujet);
	}

}
