package com.pfe.elearning.metier.espaceUtilisateur;

import java.util.List;

import com.pfe.elearning.entities.EspaceUtilisateur;
import com.pfe.elearning.entities.Fichiers;

public interface IMetierEspaceUtilisateur {
	
	public EspaceUtilisateur inserer(EspaceUtilisateur entity);

	public EspaceUtilisateur modifier(EspaceUtilisateur entity);

	public void supprimer(Long id);

	public List<EspaceUtilisateur> selectAll();

	public EspaceUtilisateur findById(Long id);
	
	public List<EspaceUtilisateur>getListSousEspace(Long idEspace);
	public List<Fichiers>getListFichiers(Long idEspace);

}
