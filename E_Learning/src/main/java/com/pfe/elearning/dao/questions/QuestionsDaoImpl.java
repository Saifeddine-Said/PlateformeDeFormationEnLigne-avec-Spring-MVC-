package com.pfe.elearning.dao.questions;

import java.util.List;

import javax.persistence.Query;

import com.pfe.elearning.dao.genericDao.GenericDaoImpl;
import com.pfe.elearning.entities.Questions;
import com.pfe.elearning.entities.Reponses;

public class QuestionsDaoImpl extends GenericDaoImpl<Questions> implements IQuestionsDao {

	@Override
	public List<Reponses> getListReponses(Long idQuestion) {
		Query query=em.createQuery("Select r from Questions q join q.reponses where q.idQuestion=:x");
		query.setParameter("x", idQuestion);
		return query.getResultList();
	}

}
