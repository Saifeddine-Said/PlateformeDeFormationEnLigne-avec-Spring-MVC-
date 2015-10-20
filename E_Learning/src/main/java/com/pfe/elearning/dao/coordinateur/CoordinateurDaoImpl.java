package com.pfe.elearning.dao.coordinateur;

import java.util.List;

import javax.persistence.Query;

import com.pfe.elearning.dao.genericDao.GenericDaoImpl;
import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.Coordinateur;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;

public class CoordinateurDaoImpl extends GenericDaoImpl<Coordinateur> implements ICoordinateurDao{

	@Override
	public List<Formation> getListFormations(Long idUtilisateur) {
		Query query =em.createQuery("Select f from Coordinateur c join c.formations f where c.idUtilisateur=:x");
		query.setParameter("x", idUtilisateur);
		return query.getResultList();
	}

	@Override
	public List<ContenuChapitre> getListContenu(Long idUtilisateur) {
		Query query=em.createQuery("select o from Coordinateur c join c.modules m join m.chapitres h join h.contenuChapitres o where c.idUtilisateur=:x");
		query.setParameter("x", idUtilisateur);
		return query.getResultList();
	}

	@Override
	public List<Module>getListModulesCoordinateurParFormation(Long idUtilisateur,Long idFormation) {
		Query query=em.createQuery("select m from Coordinateur c join c.modules m  where m.formation.idFormation=:y and c.idUtilisateur=:x");
		query.setParameter("x", idUtilisateur);
		query.setParameter("y", idFormation);
		return query.getResultList();
	}

	@Override
	public List<Coordinateur> listeCoordinateurs(Long idUser) {
		Query query=em.createQuery("select c from Coordinateur c");
		return query.getResultList();
	}
	
	

}
