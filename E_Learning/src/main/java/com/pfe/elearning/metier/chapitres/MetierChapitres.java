package com.pfe.elearning.metier.chapitres;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.chapitres.ChapitresDaoImpl;
import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.FAQ;
@Transactional
public class MetierChapitres implements IMetierChapitres {
	
	private ChapitresDaoImpl dao;

	@Override
	public Chapitres inserer(Chapitres entity) {
		return dao.inserer(entity);
	}

	@Override
	public Chapitres modifier(Chapitres entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<Chapitres> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Chapitres findById(Long id) {
		return dao.findById(id);
	}

	public void setDao(ChapitresDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<ContenuChapitre> listeContenuChapitre(Long idChapitre) {
		return dao.listeContenuChapitre(idChapitre);
	}

	@Override
	public List<FAQ> listFaqParChapitre(Long idChapitre) {
		return dao.listFaqParChapitre(idChapitre);
	}

}
