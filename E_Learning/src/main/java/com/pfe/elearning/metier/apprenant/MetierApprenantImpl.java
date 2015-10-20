package com.pfe.elearning.metier.apprenant;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.apprenant.ApprenantDaoAImpl;
import com.pfe.elearning.entities.Apprenant;
import com.pfe.elearning.entities.Examen;
import com.pfe.elearning.entities.Module;

@Transactional
public class MetierApprenantImpl implements IMetierApprenant {

	private ApprenantDaoAImpl dao;

	@Override
	public Apprenant inserer(Apprenant entity) {
		return dao.inserer(entity);
	}

	@Override
	public Apprenant modifier(Apprenant entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<Apprenant> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Apprenant findById(Long id) {
		return dao.findById(id);
	}

	public void setDao(ApprenantDaoAImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<Module> listeDesModuleParApprenant(Long id) {
		return dao.listeDesModuleParApprenant(id);
	}

	@Override
	public void ajouterInscription(Long idModule, Long idUtilisateur) {
		dao.ajouterInscription(idModule, idUtilisateur);
	}

	@Override
	public void annulerInscription(Long idModule, Long idUtilisateur) {
		dao.annulerInscription(idModule, idUtilisateur);
	}

	@Override
	public List<Examen> listExamenParApprenant(Long idUtilisateur) {
		return dao.listExamenParApprenant(idUtilisateur);
	}
	
}
