package com.pfe.elearning.metier.tuteur;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.tuteur.TuteurDaoImpl;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.Tuteur;
import com.pfe.elearning.entities.VisioConference;

@Transactional
public class MetierTuteurImpl implements IMetierTuteur{
	
	private TuteurDaoImpl dao;

	@Override
	public Tuteur inserer(Tuteur entity) {
		return dao.inserer(entity);
	}

	@Override
	public Tuteur modifier(Tuteur entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<Tuteur> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Tuteur findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<VisioConference> getListVisioConferences(Long idUtilisateur) {
		return dao.getListVisioConferences(idUtilisateur);
	}

	@Override
	public List<Module> getListModule(Long idUtilisateur) {
		return dao.getListModule(idUtilisateur);
	}

	public void setDao(TuteurDaoImpl dao) {
		this.dao = dao;
	}

}
