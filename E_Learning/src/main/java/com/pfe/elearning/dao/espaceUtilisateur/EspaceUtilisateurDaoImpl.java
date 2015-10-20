package com.pfe.elearning.dao.espaceUtilisateur;

import java.util.List;

import javax.persistence.Query;

import com.pfe.elearning.dao.genericDao.GenericDaoImpl;
import com.pfe.elearning.entities.EspaceUtilisateur;
import com.pfe.elearning.entities.Fichiers;

public class EspaceUtilisateurDaoImpl extends GenericDaoImpl<EspaceUtilisateur>
		implements IEspaceUtilisateurDao {

	@Override
	public List<EspaceUtilisateur> getListSousEspace(Long idEspace) {

//		Query query = em.createQuery("select s from EspaceUtilisateur e join e.espaceParent s where e.idEspace=:x");
		Query query = em.createQuery("from EspaceUtilisateur e where e.espaceParent.idEspace=:x");
		query.setParameter("x", idEspace);
		return query.getResultList();
	}

	@Override
	public List<Fichiers> getListFichiers(Long idEspace) {
		Query query = em.createQuery("Select f from EspaceUtilisateur e join e.listeFichiers f where e.idEspace=:x");
		query.setParameter("x", idEspace);
		return query.getResultList();
	}

}
