package com.pfe.elearning.dao.contenuChapitre;

import java.util.List;

import com.pfe.elearning.dao.genericDao.IGenericDao;
import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.Ressources;

public interface IContenuChapitreDao extends IGenericDao<ContenuChapitre> {

	public List<Ressources> listeRessourcesParContenuChapitre(Long idContenu);

}
