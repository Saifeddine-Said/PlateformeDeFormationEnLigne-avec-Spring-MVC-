package com.pfe.elearning.dao.examen;

import java.util.List;

import com.pfe.elearning.dao.genericDao.IGenericDao;
import com.pfe.elearning.entities.Apprenant;
import com.pfe.elearning.entities.Examen;
import com.pfe.elearning.entities.Questions;

public interface IExamenDao extends IGenericDao<Examen> {
	
	public List<Questions>getListQuestions(Long idExamen);
	public List<Examen>getListExamenParModule(Long idModule);
	public Examen getExamenParModuleEtChapitre(Long idModule,Long idChapitre);
	
	
	public List<Apprenant>getListApprenantPasserExamen(Long idExamen);
	public List<Examen> getExamenPasserParAppreantParChapitre(Long idApprenant,Long idChapitre);
	
}
