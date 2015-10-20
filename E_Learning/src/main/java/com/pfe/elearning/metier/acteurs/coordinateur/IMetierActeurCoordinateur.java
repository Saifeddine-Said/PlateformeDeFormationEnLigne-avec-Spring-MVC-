package com.pfe.elearning.metier.acteurs.coordinateur;

import java.util.List;

import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.metier.acteurs.concepteur.IMetierActeurConcepteur;

public interface IMetierActeurCoordinateur extends IMetierActeurConcepteur {

	/**
	 * Gestion des formations
	 */

	public Formation insererFormation(Formation entity);

	public Formation modifierFormation(Formation entity);

	public void supprimerFormation(Long id);

	public List<Formation> selectAllFormations();

	public Formation findFormationById(Long id);

	public List<Module> getListModules(Long idFormation);

}
