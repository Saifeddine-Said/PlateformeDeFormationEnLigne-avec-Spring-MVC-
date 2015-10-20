package com.pfe.elearning.metier.reponses;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.reponses.ReponsesDaoImpl;
import com.pfe.elearning.entities.Reponses;
@Transactional
public class MetierReponsesImpl implements IMetierReponses {
	
	private ReponsesDaoImpl dao;

	@Override
	public Reponses inserer(Reponses entity) {
		return dao.inserer(entity);
	}

	@Override
	public Reponses modifier(Reponses entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<Reponses> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Reponses findById(Long id) {
		return dao.findById(id);
	}

	public void setDao(ReponsesDaoImpl dao) {
		this.dao = dao;
	}
	

}
