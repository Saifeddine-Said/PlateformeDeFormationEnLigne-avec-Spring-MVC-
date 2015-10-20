package com.pfe.elearning.dao.apprenant;

import java.util.List;

import com.pfe.elearning.dao.genericDao.IGenericDao;
import com.pfe.elearning.entities.Apprenant;
import com.pfe.elearning.entities.Examen;
import com.pfe.elearning.entities.Module;

public interface IApprenantDao extends IGenericDao<Apprenant> {
	
	public List<Module> listeDesModuleParApprenant(Long id);
	
	public void ajouterInscription(Long idModule,Long idUtilisateur);
	public void annulerInscription(Long idModule,Long idUtilisateur);
	
	public List<Examen>listExamenParApprenant(Long idUtilisateur);

}
