package com.pfe.elearning.metier.acteurs.coordinateur;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.acteurs.coordinateur.ActeurCoordinateurDaoImpl;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.metier.acteurs.concepteur.MetierActeurConcepteurImpl;

@Transactional
public class MetierActeurCoordinateurImpl extends MetierActeurConcepteurImpl implements IMetierActeurCoordinateur {

	private ActeurCoordinateurDaoImpl dao;

	public void setDao(ActeurCoordinateurDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public Formation insererFormation(Formation entity) {
		return dao.insererFormation(entity);
	}

	@Override
	public Formation modifierFormation(Formation entity) {
		return dao.modifierFormation(entity);
	}

	@Override
	public void supprimerFormation(Long id) {
		dao.supprimerFormation(id);
	}

	@Override
	public List<Formation> selectAllFormations() {
		return dao.selectAllFormations();
	}

	@Override
	public Formation findFormationById(Long id) {
		return dao.findFormationById(id);
	}

	@Override
	public List<Module> getListModules(Long idFormation) {
		return dao.getListModules(idFormation);
	}

}
