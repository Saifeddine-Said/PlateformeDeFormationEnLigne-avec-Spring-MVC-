package com.pfe.elearning.metier.evenement;

import java.util.List;

import com.pfe.elearning.entities.Evenement;
import com.pfe.elearning.entities.Utilisateur;

public interface IMetierEvenement {
	public Evenement inserer(Evenement entity);

	public Evenement modifier(Evenement entity);

	public void supprimer(Long id);

	public List<Evenement> selectAll();

	public Evenement findById(Long id);
	
	public List<Utilisateur> listeParticipantParEvenement(Long idEvenement);
}
