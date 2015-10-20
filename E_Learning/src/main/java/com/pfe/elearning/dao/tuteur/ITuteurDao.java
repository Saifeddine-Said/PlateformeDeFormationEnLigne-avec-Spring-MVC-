package com.pfe.elearning.dao.tuteur;

import java.util.List;

import com.pfe.elearning.dao.genericDao.IGenericDao;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.Tuteur;
import com.pfe.elearning.entities.VisioConference;

public interface ITuteurDao extends IGenericDao<Tuteur>{
	
	public List<VisioConference>getListVisioConferences(Long idUtilisateur);
	public List<Module>getListModule(Long idUtilisateur);

}
