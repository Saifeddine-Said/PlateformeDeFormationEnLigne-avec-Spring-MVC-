package com.pfe.elearning.dao.acteurs.coordinateur;

import java.util.List;

import com.pfe.elearning.dao.acteurs.concepteur.ActeurConcepteurDaoImpl;
import com.pfe.elearning.dao.formation.FormationDaoImpl;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;

public class ActeurCoordinateurDaoImpl extends ActeurConcepteurDaoImpl implements IActeurCoordinateurDao{
	
	private FormationDaoImpl daoFormation;

	@Override
	public Formation insererFormation(Formation entity) {
		return daoFormation.inserer(entity);
	}

	@Override
	public Formation modifierFormation(Formation entity) {
		return daoFormation.modifier(entity);
	}

	@Override
	public void supprimerFormation(Long id) {
		daoFormation.supprimer(id);
	}

	@Override
	public List<Formation> selectAllFormations() {
		return daoFormation.selectAll();
	}

	@Override
	public Formation findFormationById(Long id) {
		return daoFormation.findById(id);
	}

	@Override
	public List<Module> getListModules(Long idFormation) {
		return daoFormation.getListModules(idFormation);
	}

	public void setDaoFormation(FormationDaoImpl daoFormation) {
		this.daoFormation = daoFormation;
	}

}
