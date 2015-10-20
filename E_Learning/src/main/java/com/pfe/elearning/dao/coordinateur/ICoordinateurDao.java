package com.pfe.elearning.dao.coordinateur;

import java.util.List;

import com.pfe.elearning.dao.genericDao.IGenericDao;
import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.Coordinateur;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;

public interface ICoordinateurDao extends IGenericDao<Coordinateur> {

	public List<Formation> getListFormations(Long idUtilisateur);

	public List<ContenuChapitre> getListContenu(Long idUtilisateur);

	public List<Module> getListModulesCoordinateurParFormation(Long idUtilisateur, Long idFormation);
	
	public List<Coordinateur> listeCoordinateurs(Long idUser);

}
