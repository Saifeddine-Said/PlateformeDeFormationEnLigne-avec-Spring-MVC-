package com.pfe.elearning.dao.module;

import java.util.List;

import javax.persistence.Query;

import com.pfe.elearning.dao.genericDao.GenericDaoImpl;
import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.SujetForum;

public class ModuleDaoImpl extends GenericDaoImpl<Module> implements IModuleDao {

	@Override
	public List<Chapitres> listeChapitresParModule(Long idModule) {
		Query query = em.createQuery("select c from Module m join m.chapitres c where m.idModule = :x order by numChapitre");
		query.setParameter("x", idModule);
		return query.getResultList();
	}

	@Override
	public List<Module> listeModuleParCoordinateur(Long idUser) {
		Query query = em.createQuery("select m from Module m join m.coordinateur u where u.idUtilisateur = :x");
		query.setParameter("x", idUser);
		return query.getResultList();
	}

	@Override
	public List<Module> listeModuleParConcepteur(Long idUser) {
		Query query = em.createQuery("select m from Module m join m.concepteur u where u.idUtilisateur = :x");
		query.setParameter("x", idUser);
		return query.getResultList();
	}

	@Override
	public List<SujetForum> listeSujetForum(Long idModule) {
		Query query = em.createQuery("select s from SujetForum s join s.module m where m.idModule = :x");
		query.setParameter("x", idModule);
		return query.getResultList();
	}

	@Override
	public List<ContenuChapitre> listContenuChapitreParModule(Long idModule) {
		Query query = em.createQuery("select c from ContenuChapitre c join c.chapitre p join p.module m where m.idModule = :x");
		query.setParameter("x", idModule);
		return query.getResultList();
	}

	@Override
	public List<Module> listeModuleParAUtresCoordinateurs(Long idUser) {
		Query query = em.createQuery("select m from Module m join m.coordinateur u where u.idUtilisateur <> :x");
		query.setParameter("x", idUser);
		return query.getResultList();
	}

}
