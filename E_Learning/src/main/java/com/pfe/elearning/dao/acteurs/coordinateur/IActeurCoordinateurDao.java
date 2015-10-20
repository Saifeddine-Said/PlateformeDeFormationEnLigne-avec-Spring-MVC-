package com.pfe.elearning.dao.acteurs.coordinateur;

import java.util.List;

import com.pfe.elearning.dao.acteurs.concepteur.IActeurConcepteurDao;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;

public interface IActeurCoordinateurDao extends IActeurConcepteurDao {

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
