package com.pfe.elearning.metier.questions;

import java.util.List;

import com.pfe.elearning.entities.Questions;
import com.pfe.elearning.entities.Reponses;

public interface IMetierQuestions {
	public Questions inserer(Questions entity);

	public Questions modifier(Questions entity);

	public void supprimer(Long id);

	public List<Questions> selectAll();

	public Questions findById(Long id);
	
	public List<Reponses>getListReponses(Long idQuestion);

}
