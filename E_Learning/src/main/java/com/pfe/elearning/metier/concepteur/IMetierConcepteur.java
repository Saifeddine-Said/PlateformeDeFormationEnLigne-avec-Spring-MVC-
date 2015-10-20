package com.pfe.elearning.metier.concepteur;

import java.util.List;

import com.pfe.elearning.entities.Concepteur;
import com.pfe.elearning.entities.Module;

public interface IMetierConcepteur {
	public Concepteur inserer(Concepteur entity);

	public Concepteur modifier(Concepteur entity);

	public void supprimer(Long id);

	public List<Concepteur> selectAll();

	public Concepteur findById(Long id);
	
	public List<Module> listeModulesCreeParConcepteur(Long idConcepteur);

}
