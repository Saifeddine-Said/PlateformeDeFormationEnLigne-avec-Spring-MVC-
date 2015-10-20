package com.pfe.elearning.dao.utilisateur;

import java.util.List;

import javax.persistence.Query;

import com.pfe.elearning.dao.genericDao.GenericDaoImpl;
import com.pfe.elearning.entities.Email;
import com.pfe.elearning.entities.EspaceUtilisateur;
import com.pfe.elearning.entities.Evenement;
import com.pfe.elearning.entities.MessagesChatRoom;
import com.pfe.elearning.entities.MessagesForum;
import com.pfe.elearning.entities.SujetForum;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.entities.VisioConference;
@SuppressWarnings("unchecked")
public class UtilisateurDaoImpl extends GenericDaoImpl<Utilisateur> implements IUtilisateurDao {

	
	@Override
	public List<Evenement> listDesEvenementsCrees(Long id) {
		Query query = em.createQuery("select e from Utilisateur u join u.creerEvenements e where u.idUtilisateur=:x");
		query.setParameter("x", id);
		return query.getResultList();
	}

	@Override
	public List<Email> listDesEmailsRecus(Long id) {
		Query query = em.createQuery("select e from Utilisateur u join u.eMailsRecus e where u.idUtilisateur=:x order by e.dateEnvoi desc");
		query.setParameter("x", id);
		return query.getResultList();
	}

	@Override
	public List<Email> listDesEmailsEnvoyes(Long id) {
		Query query = em.createQuery("select e from Utilisateur u join u.eMailsEnvoye e where u.idUtilisateur=:x order by e.dateEnvoi desc");
		query.setParameter("x", id);
		return query.getResultList();
	}
	
	

	@Override
	public List<Evenement> listDesEvenenementsParticpe(Long id) {
		Query query = em.createQuery("select e from Utilisateur u join u.participationEvenement e where u.idUtilisateur=:x");
		query.setParameter("x", id);
		return query.getResultList();

	}

	@Override
	public List<VisioConference> listDesVisioConferenceParticipe(Long id) {
		Query query = em.createQuery("select v from Utilisateur u join u.participantVisioConf v where u.idUtilisateur=:x");
		query.setParameter("x", id);
		return query.getResultList();
	}

	@Override
	public List<MessagesChatRoom> listDesMessagesDesChatRoom(Long id) {
		Query query = em.createQuery("select m from Utilisateur u join u.messagesChatRooms m where u.idUtilisateur=:x");
		query.setParameter("x", id);
		return query.getResultList();
	}

	@Override
	public EspaceUtilisateur espaceUtilisateur(Long id) {
		Query query = em.createQuery("select e from EspaceUtilisateur e join e.proprietaire p where p.idUtilisateur=:x");
		query.setParameter("x", id);
		return (EspaceUtilisateur)query.getResultList().get(0);
	}

	@Override
	public List<MessagesForum> listDesMessagesForum(Long id) {
		Query query = em.createQuery("select m from Utilisateur u join u.messagesForums m where u.idUtilisateur=:x");
		query.setParameter("x", id);
		return query.getResultList();
	}

	@Override
	public List<SujetForum> listDesPosteForum(Long id) {
		Query query = em.createQuery("select s from Utilisateur u join u.messagesForums s where u.idUtilisateur=:x");
		query.setParameter("x", id);
		return query.getResultList();
	}

	@Override
	public List<Email> listDesEmailsRecuNonLu(Long id) {
		Query query = em.createQuery("select e from Utilisateur u join u.eMailsRecus e where u.idUtilisateur=:x and e.lu = 0 order by e.dateEnvoi desc");
		query.setParameter("x", id);
		return query.getResultList();
	}

	@Override
	public Utilisateur getUtilisateurParEmail(String email) {
		Query query = em.createQuery("select u from Utilisateur u where u.email like :x");
		query.setParameter("x", "%"+email+"%");
		return (Utilisateur) query.getSingleResult();
	}

}
