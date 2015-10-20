package com.pfe.elearning.metier.notification;

import java.util.List;

import com.pfe.elearning.entities.Notification;
import com.pfe.elearning.entities.Notification;

public interface IMetierNotification {
	
	public Notification inserer(Notification entity);

	public Notification modifier(Notification entity);

	public void supprimer(Long id);

	public List<Notification> selectAll();

	public Notification findById(Long id);
	
	public List<Notification>listNotificationParUtilisateur(Long idUtilisateur);

}
