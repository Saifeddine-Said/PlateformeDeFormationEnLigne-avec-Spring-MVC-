package com.pfe.elearning.metier.examen;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.examen.ExamenDaoImpl;
import com.pfe.elearning.entities.Apprenant;
import com.pfe.elearning.entities.Examen;
import com.pfe.elearning.entities.Questions;
@Transactional
public class MetierExamenImpl implements IMetierExamen {
	
	private ExamenDaoImpl dao;

	@Override
	public Examen inserer(Examen entity) {
		return dao.inserer(entity);
	}

	@Override
	public Examen modifier(Examen entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<Examen> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Examen findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Questions> getListQuestions(Long idExamen) {
		return dao.getListQuestions(idExamen);
	}

	@Override
	public List<Examen> getListExamenParModule(Long idModule) {
		
		return dao.getListExamenParModule(idModule);
	}
	
	@Override
	public Examen getExamenParModuleEtChapitre(Long idModule,	Long idChapitre) {
		return dao.getExamenParModuleEtChapitre(idModule, idChapitre);
	}
	
	@Override
	public List<Apprenant> getListApprenantPasserExamen(Long idExamen) {
		return dao.getListApprenantPasserExamen(idExamen);
	}

	@Override
	public List<Examen> getExamenPasserParAppreantParChapitre(Long idApprenant,Long idChapitre) {
		return dao.getExamenPasserParAppreantParChapitre(idApprenant, idChapitre);
	}

	public void setDao(ExamenDaoImpl dao) {
		this.dao = dao;
	}

}
