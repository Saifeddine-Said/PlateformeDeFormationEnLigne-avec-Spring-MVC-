package com.pfe.elearning.metier.utilisateur;

import java.util.List;

import com.pfe.elearning.entities.Email;
import com.pfe.elearning.entities.EspaceUtilisateur;
import com.pfe.elearning.entities.Evenement;
import com.pfe.elearning.entities.MessagesChatRoom;
import com.pfe.elearning.entities.MessagesForum;
import com.pfe.elearning.entities.SujetForum;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.entities.VisioConference;

public interface IMetierUtilisateur {

	public Utilisateur inserer(Utilisateur entity);

	public Utilisateur modifier(Utilisateur entity);

	public void supprimer(Long id);

	public List<Utilisateur> selectAll();

	public Utilisateur findById(Long id);

	public List<Evenement> listDesEvenementsCrees(Long id);

	public List<Email> listDesEmailsRecus(Long id);
	
	public List<Email> listDesEmailsRecuNonLu(Long id);

	public List<Email> listDesEmailsEnvoyes(Long id);

	public List<Evenement> listDesEvenenementsParticpe(Long id);

	public List<VisioConference> listDesVisioConferenceParticipe(Long id);

	public List<MessagesChatRoom> listDesMessagesDesChatRoom(Long id);

	public EspaceUtilisateur espaceUtilisateur(Long id);

	public List<MessagesForum> listDesMessagesForum(Long ig);

	public List<SujetForum> listDesPosteForum(Long id);
	
	public Utilisateur getUtilisateurParEmail(String email);

}
