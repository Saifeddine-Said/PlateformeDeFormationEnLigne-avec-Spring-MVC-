package com.pfe.elearning.metier.acteurs.tuteur;

import java.util.List;

import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.MessagesForum;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.entities.VisioConference;

public interface IMetierActeurTuteur {
	/**
	 * Gestion VisioConferences
	 */

	public VisioConference insererVisioConference(VisioConference entity);

	public VisioConference modifierVisioConference(VisioConference entity);

	public void supprimerVisioConference(Long idVisioConference);

	public List<VisioConference> selectAllVisioConferences();

	public VisioConference findVisioConferenceById(Long idVisioConference);

	public List<Utilisateur> listeDesParticipantParVisioConf(Long idVisioConference);

	/**
	 * 
	 * Gestion Modules
	 *
	 */
	
	public List<Module> selectAllModules();

	public Module findModuleById(Long id);

	public List<Chapitres> listeChapitresParModule(Long idModule);
	
//	public List<Apprenant> listeApprenantsParModule(Long idModule);
	
	/**
	 * 
	 * Gestion Forum
	 * 
	 */
		public List<MessagesForum>getListMessageForum(Long idForum);

	/**
	 * 
	 * Gestion EspaceUtilisateur
	 * 
	 */
//	public EspaceUtilisateur insererSousEspace(EspaceUtilisateur sousEspace);
//
//	public EspaceUtilisateur modifierSousEspace(EspaceUtilisateur sousEspace);
//
//	public void supprimerEspaceSousEspace(Long idSousEspace);
//
//	public List<EspaceUtilisateur> getListSousEspace(Long idEspace);
//
//	public List<Fichiers> getListFichiers(Long idEspace);
}
