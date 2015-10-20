package com.pfe.elearning.dao.formation;

import java.util.List;

import com.pfe.elearning.dao.genericDao.IGenericDao;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;

public interface IFormationDao extends IGenericDao<Formation> {

	public List<Module>getListModules(Long idFormation);
	
	public List<Formation> listeFormationsParCoordinateur(Long idUser);
	public List<Formation> listeFormationsAutresCoordinateurs(Long idUser);
}
