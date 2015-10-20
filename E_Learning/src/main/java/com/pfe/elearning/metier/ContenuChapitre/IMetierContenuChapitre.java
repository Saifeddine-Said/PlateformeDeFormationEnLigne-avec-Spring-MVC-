package com.pfe.elearning.metier.ContenuChapitre;

import java.util.List;

import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.Ressources;

public interface IMetierContenuChapitre {
	
	public ContenuChapitre inserer(ContenuChapitre entity);

	public ContenuChapitre modifier(ContenuChapitre entity);

	public void supprimer(Long id);

	public List<ContenuChapitre> selectAll();

	public ContenuChapitre findById(Long id);
	
	public List<Ressources> listeRessourcesParContenuChapitre(Long idContenu);

}
