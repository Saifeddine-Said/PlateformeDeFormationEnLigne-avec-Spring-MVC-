package com.pfe.elearning.dao.evenement;

import java.util.List;

import com.pfe.elearning.dao.genericDao.IGenericDao;
import com.pfe.elearning.entities.Evenement;
import com.pfe.elearning.entities.Utilisateur;

public interface IEvenementDao extends IGenericDao<Evenement> {
	
	public List<Utilisateur> listeParticipantParEvenement(Long idEvenement);

}
