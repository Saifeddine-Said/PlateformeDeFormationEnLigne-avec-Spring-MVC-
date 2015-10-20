package com.pfe.elearning.metier.ressources;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.ressources.RessourcesDaoImpl;
import com.pfe.elearning.entities.Ressources;
@Transactional
public class MetierRessourcesImpl implements IMetierRessources {
	
	private RessourcesDaoImpl dao;

	@Override
	public Ressources inserer(Ressources entity) {
		return dao.inserer(entity);
	}

	@Override
	public Ressources modifier(Ressources entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<Ressources> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Ressources findById(Long id) {
		return dao.findById(id);
	}

	public void setDao(RessourcesDaoImpl dao) {
		this.dao = dao;
	}
	

}
