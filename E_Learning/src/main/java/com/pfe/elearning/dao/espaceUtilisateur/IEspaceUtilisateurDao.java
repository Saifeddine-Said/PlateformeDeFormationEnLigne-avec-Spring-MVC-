package com.pfe.elearning.dao.espaceUtilisateur;

import java.util.List;

import com.pfe.elearning.dao.genericDao.IGenericDao;
import com.pfe.elearning.entities.*;

public interface IEspaceUtilisateurDao extends IGenericDao<EspaceUtilisateur> {
	
	public List<EspaceUtilisateur>getListSousEspace(Long idEspace);
	public List<Fichiers>getListFichiers(Long idEspace);
	
}
