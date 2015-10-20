package com.pfe.elearning.dao.concepteur;

import java.util.List;

import com.pfe.elearning.dao.genericDao.IGenericDao;
import com.pfe.elearning.entities.Concepteur;
import com.pfe.elearning.entities.Module;

public interface IConcepteurDao extends IGenericDao<Concepteur> {

	public List<Module> listeModulesCreeParConcepteur(Long idConcepteur);

}
