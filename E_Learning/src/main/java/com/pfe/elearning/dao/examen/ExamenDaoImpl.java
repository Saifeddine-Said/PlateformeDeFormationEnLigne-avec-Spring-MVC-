package com.pfe.elearning.dao.examen;

import java.util.List;

import javax.persistence.Query;

import com.pfe.elearning.dao.genericDao.GenericDaoImpl;
import com.pfe.elearning.entities.Apprenant;
import com.pfe.elearning.entities.Examen;
import com.pfe.elearning.entities.Questions;

public class ExamenDaoImpl extends GenericDaoImpl<Examen>implements IExamenDao {

	@Override
	public List<Questions> getListQuestions(Long idExamen) {
		Query query=em.createQuery("Select q from Examen e join e.questions q where e.idExamen=:x");
		query.setParameter("x", idExamen);
		return query.getResultList();
	}

	@Override
	public List<Examen> getListExamenParModule(Long idModule) {
		
		Query query=em.createQuery("Select e from Examen e join e.module m where m.idModule=:x");
		query.setParameter("x", idModule);
		return query.getResultList();
	}

	@Override
	public Examen getExamenParModuleEtChapitre(Long idModule,Long idChapitre) {

		Query query=em.createQuery("Select e from Examen e join e.module m join e.chapitres c where m.idModule=:x and c.idChapitre=:y");
		query.setParameter("x", idModule);
		query.setParameter("y", idChapitre);
		return (Examen) query.getSingleResult();
	}

	@Override
	public List<Apprenant> getListApprenantPasserExamen(Long idExamen) {
		
		Query query=em.createQuery("Select a from Examen e join e.apprenants a where e.idExamen=:x");
		query.setParameter("x", idExamen);
		return query.getResultList();
	}

	@Override
	public List<Examen> getExamenPasserParAppreantParChapitre(Long idApprenant,Long idChapitre){
		Query query=em.createQuery("Select e from Examen e join e.apprenants a join e.chapitres c where a.idUtilisateur=:x and c.idChapitre=:y");
		query.setParameter("x", idApprenant);
		query.setParameter("y", idChapitre);
		return query.getResultList();
	}
	
	
	
	

}
