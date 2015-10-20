package com.pfe.elearning.dao.notification;

import java.util.List;

import javax.persistence.Query;

import com.pfe.elearning.dao.genericDao.GenericDaoImpl;
import com.pfe.elearning.entities.Notification;

public class NotificationDaoImpl extends GenericDaoImpl<Notification> implements INotificationDao {

	@Override
	public List<Notification> listNotificationParUtilisateur(Long idUtilisateur) {
		Query query=em.createQuery("Select n from Utilisateur u join u.notifications n where u.idUtilisateur=:x");
		query.setParameter("x", idUtilisateur);
		return query.getResultList();
	}

}
