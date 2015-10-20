package com.pfe.elearning.dao.chapitres;

import java.util.List;

import com.pfe.elearning.dao.genericDao.IGenericDao;
import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.FAQ;

public interface IChapitresDao extends IGenericDao<Chapitres> {
	
	public List<ContenuChapitre> listeContenuChapitre(Long idChapitre);
	
	public List<FAQ> listFaqParChapitre(Long idChapitre);

}
