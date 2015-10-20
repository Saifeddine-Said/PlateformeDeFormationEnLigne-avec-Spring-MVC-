package com.pfe.elearning.dao.sujetForum;

import java.util.List;

import com.pfe.elearning.dao.genericDao.IGenericDao;
import com.pfe.elearning.entities.MessagesForum;
import com.pfe.elearning.entities.SujetForum;

public interface ISujetForumDao extends IGenericDao<SujetForum> {

	public List<MessagesForum>getListMessageForum(Long idSujet);
}
