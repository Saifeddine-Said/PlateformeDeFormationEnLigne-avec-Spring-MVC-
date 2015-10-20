package com.pfe.elearning.metier.formation;

import java.util.List;

import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;

public interface IMetierFormation {
	public Formation inserer(Formation entity);

	public Formation modifier(Formation entity);

	public void supprimer(Long id);

	public List<Formation> selectAll();

	public Formation findById(Long id);
	
	public List<Module>getListModules(Long idFormation);
	
	public List<Formation> listeFormationsParCoordinateur(Long idUser);
	
	public List<Formation> listeFormationsAutresCoordinateurs(Long idUser);

}
