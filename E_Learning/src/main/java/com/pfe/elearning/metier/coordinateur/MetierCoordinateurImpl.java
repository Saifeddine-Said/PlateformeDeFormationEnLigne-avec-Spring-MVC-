package com.pfe.elearning.metier.coordinateur;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.coordinateur.CoordinateurDaoImpl;
import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.Coordinateur;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.metier.utilisateur.MetierUtilisateurImpl;
@Transactional
public class MetierCoordinateurImpl extends MetierUtilisateurImpl implements IMetierCoordinateur {

	private CoordinateurDaoImpl dao;
	@Override
	public Coordinateur inserer(Coordinateur entity) {
		return dao.inserer(entity);
	}

	@Override
	public Coordinateur modifier(Coordinateur entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

//	@Override
//	public List<Coordinateur> selectAll() {
//		return dao.selectAll();
//	}

	@Override
	public Coordinateur findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Formation> getListFormations(Long idUtilisateur) {
		return dao.getListFormations(idUtilisateur);
	}
	

	@Override
	public List<ContenuChapitre> getListContenu(Long idUtilisateur) {
		return dao.getListContenu(idUtilisateur);
	}

	@Override
	public List<Module>getListModulesCoordinateurParFormation(Long idUtilisateur,Long idFormation) {
		return dao.getListModulesCoordinateurParFormation(idUtilisateur,idFormation);
	}

	public void setDao(CoordinateurDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<Coordinateur> listeCoordinateurs(Long idUser) {
		return dao.listeCoordinateurs(idUser);
	}

}
