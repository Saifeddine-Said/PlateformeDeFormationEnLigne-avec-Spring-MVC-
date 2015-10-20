package com.pfe.elearning.metier.formation;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.formation.FormationDaoImpl;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;
@Transactional
public class MetierFormationImpl implements IMetierFormation {

		private FormationDaoImpl dao;
	@Override
	public Formation inserer(Formation entity) {
		return dao.inserer(entity);
	}

	@Override
	public Formation modifier(Formation entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<Formation> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Formation findById(Long id) {
		return dao.findById(id);
	}
 
	@Override
	public List<Module> getListModules(Long idFormation) {
		return dao.getListModules(idFormation);
	}

	public void setDao(FormationDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<Formation> listeFormationsParCoordinateur(Long idUser) {
		return dao.listeFormationsParCoordinateur(idUser);
	}

	@Override
	public List<Formation> listeFormationsAutresCoordinateurs(Long idUser) {
		return dao.listeFormationsAutresCoordinateurs(idUser);
	}

}
