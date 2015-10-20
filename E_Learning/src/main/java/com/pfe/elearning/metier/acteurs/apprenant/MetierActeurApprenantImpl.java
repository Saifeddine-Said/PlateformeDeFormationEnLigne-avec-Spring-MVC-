package com.pfe.elearning.metier.acteurs.apprenant;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.acteurs.apprenant.ActeurApprenantDaoImpl;
import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.MessagesForum;
import com.pfe.elearning.entities.Module;
@Transactional
public class MetierActeurApprenantImpl implements IMetierActeurApprenant {
	
	ActeurApprenantDaoImpl dao;

	@Override
	public List<Formation> selectAllFormations() {
		return dao.selectAllFormations();
	}

	@Override
	public Formation findFormationById(Long id) {
		return dao.findFormationById(id);
	}

	@Override
	public List<Module> getListModulesParFormation(Long idFormation) {
		return dao.getListModulesParFormation(idFormation);
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
	public MessagesForum insererMessagesForum(MessagesForum entity) {
		return dao.insererMessagesForum(entity);
	}

	@Override
	public MessagesForum modifierMessagesForum(MessagesForum entity) {
		return dao.modifierMessagesForum(entity);
	}

	@Override
	public void supprimerMessagesForum(Long id) {
		dao.supprimerMessagesForum(id);
	}

	@Override
	public List<MessagesForum> selectAllMessagesForum() {
		return dao.selectAllMessagesForum();
	}

	@Override
	public MessagesForum findMessagesForumById(Long id) {
		return dao.findMessagesForumById(id);
	}

	@Override
	public List<MessagesForum> getListMessageForumParForum(Long idSujet) {
		return dao.getListMessageForumParForum(idSujet);
	}

	public void setDao(ActeurApprenantDaoImpl dao) {
		this.dao = dao;
	}

}
