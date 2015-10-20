package com.pfe.elearning.metier.notification;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.notification.NotificationDaoImpl;
import com.pfe.elearning.entities.Notification;

@Transactional
public class MetierNotification implements IMetierNotification {

	private NotificationDaoImpl dao;

	@Override
	public Notification inserer(Notification entity) {
		return dao.inserer(entity);
	}

	@Override
	public Notification modifier(Notification entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<Notification> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Notification findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Notification> listNotificationParUtilisateur(Long idUtilisateur) {
		return dao.listNotificationParUtilisateur(idUtilisateur);
	}

	public void setDao(NotificationDaoImpl dao) {
		this.dao = dao;
	}

}
