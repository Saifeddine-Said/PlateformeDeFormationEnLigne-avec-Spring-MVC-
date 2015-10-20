package com.pfe.elearning.dao.messagesForum;

import java.util.List;

import com.pfe.elearning.dao.genericDao.IGenericDao;
import com.pfe.elearning.entities.MessagesForum;
import com.pfe.elearning.entities.PieceJointeForum;

public interface IMessagesForumDao extends IGenericDao<MessagesForum> {
	
	public List<PieceJointeForum>getListPieceJointeForums(Long idMessage);

}
