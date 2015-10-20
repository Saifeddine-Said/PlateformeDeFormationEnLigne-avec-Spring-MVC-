package com.pfe.elearning.dao.contenuChapitre;

import java.util.List;

import javax.persistence.Query;

import com.pfe.elearning.dao.genericDao.GenericDaoImpl;
import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.Ressources;

public class ContenuChapitreDaoImpl extends GenericDaoImpl<ContenuChapitre> implements IContenuChapitreDao {

	@Override
	public List<Ressources> listeRessourcesParContenuChapitre(Long idContenu) {
		Query query = em.createQuery("select r from ContenuChapitre c join c.ressources r where c.idContenu = :x");
		query.setParameter("x", idContenu);
		return query.getResultList();
	}

}
