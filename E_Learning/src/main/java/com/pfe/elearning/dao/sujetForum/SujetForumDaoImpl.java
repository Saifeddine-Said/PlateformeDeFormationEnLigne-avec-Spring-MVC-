package com.pfe.elearning.dao.sujetForum;

import java.util.List;

import javax.persistence.Query;

import com.pfe.elearning.dao.genericDao.GenericDaoImpl;
import com.pfe.elearning.entities.MessagesForum;
import com.pfe.elearning.entities.SujetForum;

public class SujetForumDaoImpl extends GenericDaoImpl<SujetForum> implements ISujetForumDao {

	@Override
	public List<MessagesForum> getListMessageForum(Long idSujet) {
		Query query=em.createQuery("Select m from SujetForum s join s.messagesForums m where s.idSujet=:x");
		query.setParameter("x", idSujet);
		return query.getResultList();
	}
	

}
