package com.pfe.elearning.metier.messagesForum;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.messagesForum.IMessagesForumDao;
import com.pfe.elearning.dao.messagesForum.MessagesForumDaoImpl;
import com.pfe.elearning.entities.MessagesForum;
import com.pfe.elearning.entities.PieceJointeForum;

@Transactional
public class MetierMessagesForumImpl implements IMetierMessagesForum {

	private MessagesForumDaoImpl dao;

	@Override
	public MessagesForum inserer(MessagesForum entity) {
		return dao.inserer(entity);
	}

	@Override
	public MessagesForum modifier(MessagesForum entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<MessagesForum> selectAll() {
		return dao.selectAll();
	}

	@Override
	public MessagesForum findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<PieceJointeForum> getListPieceJointeForums(Long idMessage) {
		return dao.getListPieceJointeForums(idMessage);
	}

	public void setDao(MessagesForumDaoImpl dao) {
		this.dao = dao;
	}
}
