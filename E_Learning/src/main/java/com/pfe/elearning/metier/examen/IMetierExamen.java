package com.pfe.elearning.metier.examen;

import java.util.List;

import com.pfe.elearning.entities.Apprenant;
import com.pfe.elearning.entities.Examen;
import com.pfe.elearning.entities.Questions;

public interface IMetierExamen {
	public Examen inserer(Examen entity);

	public Examen modifier(Examen entity);

	public void supprimer(Long id);

	public List<Examen> selectAll();

	public Examen findById(Long id);
	
	public List<Questions>getListQuestions(Long idExamen);
	
	public List<Examen>getListExamenParModule(Long idModule);
	
	public Examen getExamenParModuleEtChapitre(Long idModule,Long idChapitre);
	
	public List<Apprenant>getListApprenantPasserExamen(Long idExamen);
	public List<Examen> getExamenPasserParAppreantParChapitre(Long idApprenant,Long idChapitre);

}
