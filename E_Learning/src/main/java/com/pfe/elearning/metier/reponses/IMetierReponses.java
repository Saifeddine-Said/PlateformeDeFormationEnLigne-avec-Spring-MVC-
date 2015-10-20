package com.pfe.elearning.metier.reponses;

import java.util.List;

import com.pfe.elearning.entities.Reponses;

public interface IMetierReponses {
	
	public Reponses inserer(Reponses entity);

	public Reponses modifier(Reponses entity);

	public void supprimer(Long id);

	public List<Reponses> selectAll();

	public Reponses findById(Long id);

}
