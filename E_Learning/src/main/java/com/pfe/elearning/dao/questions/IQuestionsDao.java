package com.pfe.elearning.dao.questions;

import java.util.List;

import com.pfe.elearning.dao.genericDao.IGenericDao;
import com.pfe.elearning.entities.Questions;
import com.pfe.elearning.entities.Reponses;

public interface IQuestionsDao extends IGenericDao<Questions> {
	
	public List<Reponses>getListReponses(Long idQuestion);

}
