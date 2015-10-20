package com.pfe.elearning.dao.notification;

import java.util.List;

import com.pfe.elearning.dao.genericDao.IGenericDao;
import com.pfe.elearning.entities.Notification;

public interface INotificationDao extends IGenericDao<Notification> {
	
	public List<Notification>listNotificationParUtilisateur(Long idUtilisateur);

}
