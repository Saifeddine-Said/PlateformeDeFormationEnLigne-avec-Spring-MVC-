package com.pfe.elearning.dao.chapitres;

import java.util.List;

import javax.persistence.Query;

import com.pfe.elearning.dao.genericDao.GenericDaoImpl;
import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.FAQ;

public class ChapitresDaoImpl extends GenericDaoImpl<Chapitres> implements IChapitresDao {

	@Override
	public List<ContenuChapitre> listeContenuChapitre(Long idChapitre) {
		Query query = em.createQuery("select cc from Chapitres c join c.contenuChapitres cc where c.idChapitre = :x");
		query.setParameter("x", idChapitre);
		return query.getResultList();
	}

	@Override
	public List<FAQ> listFaqParChapitre(Long idChapitre) {
		Query query = em.createQuery("select f from Chapitres c join c.faqs f where c.idChapitre = :x");
		query.setParameter("x", idChapitre);
		return query.getResultList();
	}

}
