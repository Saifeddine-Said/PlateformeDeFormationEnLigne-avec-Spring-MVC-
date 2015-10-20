package com.pfe.elearning.dao.formation;

import java.util.List;

import javax.persistence.Query;

import com.pfe.elearning.dao.genericDao.GenericDaoImpl;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;

public class FormationDaoImpl extends GenericDaoImpl<Formation> implements IFormationDao {

	@Override
	public List<Module> getListModules(Long idFormation) {
		Query query =em.createQuery("Select m from Formation f join f.modules m where f.idFormation=:x");
		query.setParameter("x", idFormation);
		return query.getResultList();
	}

	@Override
	public List<Formation> listeFormationsParCoordinateur(Long idUser) {
		Query query =em.createQuery("Select f from Formation f join f.coordinateur c where c.idUtilisateur=:x");
		query.setParameter("x", idUser);
		return query.getResultList();
	}

	@Override
	public List<Formation> listeFormationsAutresCoordinateurs(Long idUser) {
		Query query =em.createQuery("Select f from Formation f join f.coordinateur c where c.idUtilisateur <> :x");
		query.setParameter("x", idUser);
		return query.getResultList();
	}

}
