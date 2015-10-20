package com.pfe.elearning.dao.messagesForum;

import java.util.List;

import javax.persistence.Query;

import com.pfe.elearning.dao.genericDao.GenericDaoImpl;
import com.pfe.elearning.entities.MessagesForum;
import com.pfe.elearning.entities.PieceJointeForum;

public class MessagesForumDaoImpl extends GenericDaoImpl<MessagesForum>
		implements IMessagesForumDao {

	@Override
	public List<PieceJointeForum> getListPieceJointeForums(Long idMessage) {
		Query query=em.createQuery("Select p from MessagesForum m join m.pieceJointeForums p where m.idMessage=:x ");
		query.setParameter("x", idMessage);
		return query.getResultList();
	}

}
