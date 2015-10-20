package com.pfe.elearning.metier.ressources;

import java.util.List;

import com.pfe.elearning.entities.Ressources;

public interface IMetierRessources {
	
	public Ressources inserer(Ressources entity);

	public Ressources modifier(Ressources entity);

	public void supprimer(Long id);

	public List<Ressources> selectAll();

	public Ressources findById(Long id);

}
