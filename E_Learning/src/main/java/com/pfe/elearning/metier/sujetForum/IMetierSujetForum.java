package com.pfe.elearning.metier.sujetForum;

import java.util.List;

import com.pfe.elearning.entities.MessagesForum;
import com.pfe.elearning.entities.SujetForum;

public interface IMetierSujetForum {

	public SujetForum inserer(SujetForum entity);

	public SujetForum modifier(SujetForum entity);

	public void supprimer(Long id);

	public List<SujetForum> selectAll();

	public SujetForum findById(Long id);
	
	public List<MessagesForum>getListMessageForum(Long idSujet);

}
