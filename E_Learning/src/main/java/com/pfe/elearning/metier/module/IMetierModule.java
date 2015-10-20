package com.pfe.elearning.metier.module;

import java.util.List;

import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.SujetForum;

public interface IMetierModule {
	public Module inserer(Module entity);

	public Module modifier(Module entity);

	public void supprimer(Long id);

	public List<Module> selectAll();

	public Module findById(Long id);

	public List<Chapitres> listeChapitresParModule(Long idModule);

	public List<Module> listeModuleParCoordinateur(Long idUser);

	public List<Module> listeModuleParConcepteur(Long idUser);

	public List<SujetForum> listeSujetForum(Long idModule);
	
	public List<ContenuChapitre>listContenuChapitreParModule(Long idModule);
	
	public List<Module> listeModuleParAUtresCoordinateurs(Long idUser);
}
