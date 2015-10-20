package com.pfe.elearning.metier.utilisateur;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.utilisateur.UtilisateurDaoImpl;
import com.pfe.elearning.entities.Email;
import com.pfe.elearning.entities.EspaceUtilisateur;
import com.pfe.elearning.entities.Evenement;
import com.pfe.elearning.entities.MessagesChatRoom;
import com.pfe.elearning.entities.MessagesForum;
import com.pfe.elearning.entities.SujetForum;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.entities.VisioConference;

@Transactional
public class MetierUtilisateurImpl implements IMetierUtilisateur {

	private UtilisateurDaoImpl dao;
	
	@Override
	public Utilisateur inserer(Utilisateur entity) {
		return dao.inserer(entity);
	}

	@Override
	public Utilisateur modifier(Utilisateur entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<Utilisateur> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Utilisateur findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Evenement> listDesEvenementsCrees(Long id) {
		return dao.listDesEvenementsCrees(id);
	}

	@Override
	public List<Email> listDesEmailsRecus(Long id) {
		return dao.listDesEmailsRecus(id);
	}

	@Override
	public List<Email> listDesEmailsEnvoyes(Long id) {
		return dao.listDesEmailsEnvoyes(id);
	}

	@Override
	public List<Evenement> listDesEvenenementsParticpe(Long id) {
		return dao.listDesEvenenementsParticpe(id);
	}

	@Override
	public List<VisioConference> listDesVisioConferenceParticipe(Long id) {
		return dao.listDesVisioConferenceParticipe(id);
	}

	@Override
	public List<MessagesChatRoom> listDesMessagesDesChatRoom(Long id) {
		return dao.listDesMessagesDesChatRoom(id);
	}

	@Override
	public EspaceUtilisateur espaceUtilisateur(Long id) {
		return dao.espaceUtilisateur(id);
	}

	@Override
	public List<MessagesForum> listDesMessagesForum(Long id) {
		return dao.listDesMessagesForum(id);
	}

	@Override
	public List<SujetForum> listDesPosteForum(Long id) {
		return dao.listDesPosteForum(id);
	}

	public void setDao(UtilisateurDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<Email> listDesEmailsRecuNonLu(Long id) {
		return dao.listDesEmailsRecuNonLu(id);
	}

	@Override
	public Utilisateur getUtilisateurParEmail(String email) {
		return dao.getUtilisateurParEmail(email);
	}

}
