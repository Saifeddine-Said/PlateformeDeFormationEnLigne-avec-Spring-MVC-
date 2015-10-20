package com.pfe.elearning.dao.concepteur;

import java.util.List;

import javax.persistence.Query;

import com.pfe.elearning.dao.genericDao.GenericDaoImpl;
import com.pfe.elearning.entities.Concepteur;
import com.pfe.elearning.entities.Module;

public class ConcepteurDaoImpl extends GenericDaoImpl<Concepteur> implements IConcepteurDao{

	@Override
	public List<Module> listeModulesCreeParConcepteur(Long idConcepteur) {
		Query query = em.createQuery("select m from Concepteur c join c.modules where c.idUtilisateur =:x");
		query.setParameter("x", idConcepteur);
		return query.getResultList();
	}


}
