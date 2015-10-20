package com.pfe.elearning.dao.visioConference;

import java.util.List;

import com.pfe.elearning.dao.genericDao.IGenericDao;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.entities.VisioConference;

public interface IVisioConferenceDao extends IGenericDao<VisioConference> {
	
	public List<Utilisateur> listeDesParticipantParVisioConf(Long idVisioConf);

}
