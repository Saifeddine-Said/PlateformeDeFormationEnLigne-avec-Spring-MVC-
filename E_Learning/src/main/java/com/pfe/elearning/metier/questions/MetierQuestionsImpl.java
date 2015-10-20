package com.pfe.elearning.metier.questions;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.questions.QuestionsDaoImpl;
import com.pfe.elearning.entities.Questions;
import com.pfe.elearning.entities.Reponses;
@Transactional
public class MetierQuestionsImpl implements IMetierQuestions {
	
	private QuestionsDaoImpl dao;

	@Override
	public Questions inserer(Questions entity) {
		return dao.inserer(entity);
	}

	@Override
	public Questions modifier(Questions entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<Questions> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Questions findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Reponses> getListReponses(Long idQuestion) {
		return dao.getListReponses(idQuestion);
	}

	public void setDao(QuestionsDaoImpl dao) {
		this.dao = dao;
	}

}
