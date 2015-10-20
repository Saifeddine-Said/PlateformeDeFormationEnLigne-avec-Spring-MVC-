package com.pfe.elearning.metier.module;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.module.ModuleDaoImpl;
import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.SujetForum;
@Transactional
public class MetierModuleImpl implements IMetierModule {
	
	private ModuleDaoImpl dao;

	@Override
	public Module inserer(Module entity) {
		return dao.inserer(entity);
	}

	@Override
	public Module modifier(Module entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<Module> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Module findById(Long id) {
		return dao.findById(id);
	}

	public void setDao(ModuleDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<Chapitres> listeChapitresParModule(Long idModule) {
		return dao.listeChapitresParModule(idModule);
	}

	@Override
	public List<Module> listeModuleParCoordinateur(Long idUser) {
		return dao.listeModuleParCoordinateur(idUser);
	}

	@Override
	public List<Module> listeModuleParConcepteur(Long idUser) {
		return dao.listeModuleParConcepteur(idUser);
	}

	@Override
	public List<SujetForum> listeSujetForum(Long idModule) {
		return dao.listeSujetForum(idModule);
	}
	public List<ContenuChapitre>listContenuChapitreParModule(Long idModule){
		return dao.listContenuChapitreParModule(idModule);
	}

	@Override
	public List<Module> listeModuleParAUtresCoordinateurs(Long idUser) {
		return dao.listeModuleParAUtresCoordinateurs(idUser);
	}

}
