package com.pfe.elearning.metier.ContenuChapitre;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.contenuChapitre.ContenuChapitreDaoImpl;
import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.Ressources;
@Transactional
public class MetierContenuChapitreImpl implements IMetierContenuChapitre {
	
	private ContenuChapitreDaoImpl dao;

	@Override
	public ContenuChapitre inserer(ContenuChapitre entity) {
		return dao.inserer(entity);
	}

	@Override
	public ContenuChapitre modifier(ContenuChapitre entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<ContenuChapitre> selectAll() {
		return dao.selectAll();
	}

	@Override
	public ContenuChapitre findById(Long id) {
		return dao.findById(id);
	}

	public void setDao(ContenuChapitreDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<Ressources> listeRessourcesParContenuChapitre(Long idContenu) {
		return dao.listeRessourcesParContenuChapitre(idContenu);
	}

}
