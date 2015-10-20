package com.pfe.elearning.metier.chapitres;

import java.util.List;

import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.FAQ;

public interface IMetierChapitres {
	public Chapitres inserer(Chapitres entity);

	public Chapitres modifier(Chapitres entity);

	public void supprimer(Long id);

	public List<Chapitres> selectAll();

	public Chapitres findById(Long id);
	
	public List<ContenuChapitre> listeContenuChapitre(Long idChapitre);
	
	public List<FAQ> listFaqParChapitre(Long idChapitre);

}
