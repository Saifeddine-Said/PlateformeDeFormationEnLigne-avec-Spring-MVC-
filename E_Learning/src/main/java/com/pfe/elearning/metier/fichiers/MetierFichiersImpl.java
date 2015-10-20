package com.pfe.elearning.metier.fichiers;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.fichiers.FichiersDaoImpl;
import com.pfe.elearning.entities.Fichiers;
@Transactional
public class MetierFichiersImpl implements IMetierFichiers {
	
	private FichiersDaoImpl dao;

	@Override
	public Fichiers inserer(Fichiers entity) {
		return dao.inserer(entity);
	}

	@Override
	public Fichiers modifier(Fichiers entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<Fichiers> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Fichiers findById(Long id) {
		return dao.findById(id);
	}

	public void setDao(FichiersDaoImpl dao) {
		this.dao = dao;
	}

}
