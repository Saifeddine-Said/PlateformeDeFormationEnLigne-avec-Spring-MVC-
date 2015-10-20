package com.pfe.elearning.dao.module;

import java.util.List;

import com.pfe.elearning.dao.genericDao.IGenericDao;
import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.SujetForum;

public interface IModuleDao extends IGenericDao<Module> {
	
	public List<Module> listeModuleParCoordinateur(Long idUser);
	
	public List<Module> listeModuleParAUtresCoordinateurs(Long idUser);
	
	public List<Module> listeModuleParConcepteur(Long idUser);
	
	public List<Chapitres> listeChapitresParModule(Long idModule);
	
	public List<SujetForum> listeSujetForum(Long idModule);
	
	public List<ContenuChapitre>listContenuChapitreParModule(Long idModule);

}
