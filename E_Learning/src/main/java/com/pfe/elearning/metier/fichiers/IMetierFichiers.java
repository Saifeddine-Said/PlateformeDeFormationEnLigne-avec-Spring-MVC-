package com.pfe.elearning.metier.fichiers;

import java.util.List;

import com.pfe.elearning.entities.Fichiers;

public interface IMetierFichiers {
	public Fichiers inserer(Fichiers entity);

	public Fichiers modifier(Fichiers entity);

	public void supprimer(Long id);

	public List<Fichiers> selectAll();

	public Fichiers findById(Long id);

}
