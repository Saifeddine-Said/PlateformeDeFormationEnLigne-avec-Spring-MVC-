package com.pfe.elearning.metier.concepteur;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.concepteur.ConcepteurDaoImpl;
import com.pfe.elearning.entities.Concepteur;
import com.pfe.elearning.entities.Module;
@Transactional
public class MetierConecpteurImpl implements IMetierConcepteur {

	private ConcepteurDaoImpl dao;
	
	@Override
	public Concepteur inserer(Concepteur entity) {
		return dao.inserer(entity);
	}

	@Override
	public Concepteur modifier(Concepteur entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<Concepteur> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Concepteur findById(Long id) {
		return dao.findById(id);
	}

	public void setDao(ConcepteurDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<Module> listeModulesCreeParConcepteur(Long idConcepteur) {
		return dao.listeModulesCreeParConcepteur(idConcepteur);
	}

}
