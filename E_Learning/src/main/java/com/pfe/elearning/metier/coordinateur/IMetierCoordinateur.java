package com.pfe.elearning.metier.coordinateur;

import java.util.List;

import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.Coordinateur;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.metier.utilisateur.IMetierUtilisateur;

public interface IMetierCoordinateur extends IMetierUtilisateur{
	public Coordinateur inserer(Coordinateur entity);

	public Coordinateur modifier(Coordinateur entity);

	public void supprimer(Long id);

	public List<Coordinateur> listeCoordinateurs(Long idUser);

	public Coordinateur findById(Long id);
	
	public List<Formation>getListFormations(Long idUtilisateur);
	
	public List<ContenuChapitre>getListContenu(Long idUtilisateur);
	
	public List<Module>getListModulesCoordinateurParFormation(Long idUtilisateur,Long idFormation);

}
