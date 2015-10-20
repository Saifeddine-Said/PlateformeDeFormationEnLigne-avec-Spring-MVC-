package com.pfe.elearning.metier.espaceUtilisateur;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.espaceUtilisateur.EspaceUtilisateurDaoImpl;
import com.pfe.elearning.entities.EspaceUtilisateur;
import com.pfe.elearning.entities.Fichiers;
@Transactional
public class MetierEspaceUtilisateurImpl implements IMetierEspaceUtilisateur {
	
	private EspaceUtilisateurDaoImpl dao;

	@Override
	public EspaceUtilisateur inserer(EspaceUtilisateur entity) {
		return dao.inserer(entity);
	}

	@Override
	public EspaceUtilisateur modifier(EspaceUtilisateur entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<EspaceUtilisateur> selectAll() {
		return dao.selectAll();
	}

	@Override
	public EspaceUtilisateur findById(Long id) {
		return dao.findById(id);
	}

	
	@Override
	public List<EspaceUtilisateur> getListSousEspace(Long idEspace) {
		return dao.getListSousEspace(idEspace);
	}

	@Override
	public List<Fichiers> getListFichiers(Long idEspace) {
		return dao.getListFichiers(idEspace);
	}

	public void setDao(EspaceUtilisateurDaoImpl dao) {
		this.dao = dao;
	}
	
}
