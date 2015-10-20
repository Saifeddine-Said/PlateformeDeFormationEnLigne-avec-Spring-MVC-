package com.pfe.elearning.metier.email;

import java.util.List;

import com.pfe.elearning.entities.Email;
import com.pfe.elearning.entities.PieceJointeEmail;

public interface IMetierEmail {
	public Email inserer(Email entity);

	public Email modifier(Email entity);

	public void supprimer(Long id);

	public List<Email> selectAll();

	public Email findById(Long id);
	
	public List<PieceJointeEmail> listePiecejointeParEmail(Long idEmail);

}
