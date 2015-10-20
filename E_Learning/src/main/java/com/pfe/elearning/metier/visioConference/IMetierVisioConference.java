package com.pfe.elearning.metier.visioConference;

import java.util.List;

import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.entities.VisioConference;

public interface IMetierVisioConference {
	public VisioConference inserer(VisioConference entity);

	public VisioConference modifier(VisioConference entity);

	public void supprimer(Long id);

	public List<VisioConference> selectAll();

	public VisioConference findById(Long id);
	
	public List<Utilisateur> listeDesParticipantParVisioConf(Long idVisioConf);

}
