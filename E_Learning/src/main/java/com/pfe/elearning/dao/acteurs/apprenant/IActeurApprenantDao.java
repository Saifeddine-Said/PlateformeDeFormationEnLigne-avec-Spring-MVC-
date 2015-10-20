package com.pfe.elearning.dao.acteurs.apprenant;

import java.util.List;

import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.MessagesForum;
import com.pfe.elearning.entities.Module;

public interface IActeurApprenantDao {

	/**
	 * 
	 * Formation
	 * 
	 */
	public List<Formation> selectAllFormations();

	public Formation findFormationById(Long id);

	public List<Module> getListModulesParFormation(Long idFormation);

	/**
	 * 
	 * Module
	 * 
	 */

	public List<Module> selectAllModules();

	public Module findModuleById(Long id);

	public List<Chapitres> listeChapitresParModule(Long idModule);

	/**
	 * 
	 * Participer au forum
	 * 
	 */
	
	public MessagesForum insererMessagesForum(MessagesForum entity);

	public MessagesForum modifierMessagesForum(MessagesForum entity);

	public void supprimerMessagesForum(Long id);

	public List<MessagesForum> selectAllMessagesForum();

	public MessagesForum findMessagesForumById(Long id);
	/**
	 * Forum
	 */
	
	public List<MessagesForum> getListMessageForumParForum(Long idSujet);

	/**
	 * 
	 * 	Examens
	 */
	
	 
}
