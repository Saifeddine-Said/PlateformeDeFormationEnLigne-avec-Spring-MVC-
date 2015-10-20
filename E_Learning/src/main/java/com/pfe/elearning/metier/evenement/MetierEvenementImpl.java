package com.pfe.elearning.metier.evenement;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.evenement.EvenementDaoImpl;
import com.pfe.elearning.entities.Evenement;
import com.pfe.elearning.entities.Utilisateur;
@Transactional
public class MetierEvenementImpl implements IMetierEvenement {
	
	private EvenementDaoImpl dao;

	@Override
	public Evenement inserer(Evenement entity) {
		return dao.inserer(entity);
	}

	@Override
	public Evenement modifier(Evenement entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<Evenement> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Evenement findById(Long id) {
		return dao.findById(id);
	}

	public void setDao(EvenementDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<Utilisateur> listeParticipantParEvenement(Long idEvenement) {
		return dao.listeParticipantParEvenement(idEvenement);
	}

}
