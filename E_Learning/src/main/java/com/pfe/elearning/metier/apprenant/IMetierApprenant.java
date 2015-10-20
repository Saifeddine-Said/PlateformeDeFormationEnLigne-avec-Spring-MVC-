package com.pfe.elearning.metier.apprenant;

import java.util.List;

import com.pfe.elearning.entities.Apprenant;
import com.pfe.elearning.entities.Examen;
import com.pfe.elearning.entities.Module;

public interface IMetierApprenant{
	
	public Apprenant inserer(Apprenant entity);

	public Apprenant modifier(Apprenant entity);

	public void supprimer(Long id);

	public List<Apprenant> selectAll();

	public Apprenant findById(Long id);

	public List<Module> listeDesModuleParApprenant(Long id);
	
	//ApprenantModule
	public void ajouterInscription(Long idModule,Long idUtilisateur);
	public void annulerInscription(Long idModule,Long idUtilisateur);
	
	//examen par apprenant
	public List<Examen>listExamenParApprenant(Long idUtilisateur);
}
