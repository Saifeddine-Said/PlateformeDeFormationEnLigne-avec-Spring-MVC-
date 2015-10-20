package com.pfe.elearning.metier.tuteur;

import java.util.List;

import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.Tuteur;
import com.pfe.elearning.entities.VisioConference;

public interface IMetierTuteur {
	
	public Tuteur inserer(Tuteur entity);

	public Tuteur modifier(Tuteur entity);

	public void supprimer(Long id);

	public List<Tuteur> selectAll();

	public Tuteur findById(Long id);
	
	public List<VisioConference>getListVisioConferences(Long idUtilisateur);
	public List<Module>getListModule(Long idUtilisateur);

}
