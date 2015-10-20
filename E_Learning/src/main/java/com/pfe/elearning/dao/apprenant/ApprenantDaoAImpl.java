package com.pfe.elearning.dao.apprenant;

import java.util.List;

import javax.persistence.Query;

import com.pfe.elearning.dao.genericDao.GenericDaoImpl;
import com.pfe.elearning.entities.Apprenant;
import com.pfe.elearning.entities.Examen;
import com.pfe.elearning.entities.Module;

public class ApprenantDaoAImpl extends GenericDaoImpl<Apprenant> implements
		IApprenantDao {

	@Override
	public List<Module> listeDesModuleParApprenant(Long id) {
		Query query = em.createQuery("select m from Apprenant a join a.modules m where a.idUtilisateur=:x");
		query.setParameter("x", id);
		return query.getResultList();
	}

	@Override
	public void ajouterInscription(Long idModule, Long idUtilisateur) {
		
		Apprenant apprenant=em.find(Apprenant.class, idUtilisateur);
		Module module=em.find(Module.class,idModule);
		
		apprenant.getModules().add(module);
		module.getApprenants().add(apprenant);
	}

	@Override
	public void annulerInscription(Long idModule, Long idUtilisateur) {
		
		Apprenant apprenant=em.find(Apprenant.class, idUtilisateur);
		Module module=em.find(Module.class,idModule);
		
		apprenant.getModules().remove(module);
		module.getApprenants().remove(apprenant);
	}

	@Override
	public List<Examen> listExamenParApprenant(Long idUtilisateur) {
		Query query = em.createQuery("select e from Apprenant a join a.apprenants e where a.idUtilisateur=:x");
		query.setParameter("x", idUtilisateur);
		return query.getResultList();
		
	}
	
	
	

}
