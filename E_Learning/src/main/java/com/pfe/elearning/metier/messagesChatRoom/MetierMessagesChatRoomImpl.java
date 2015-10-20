package com.pfe.elearning.metier.messagesChatRoom;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.messagesChatRoom.MessagesChatRoomDaoImpl;
import com.pfe.elearning.entities.Apprenant;
import com.pfe.elearning.entities.MessagesChatRoom;
@Transactional
public class MetierMessagesChatRoomImpl implements IMetierMessagesChatRoom {
	
	private MessagesChatRoomDaoImpl dao;

	@Override
	public MessagesChatRoom inserer(MessagesChatRoom entity) {
		return dao.inserer(entity);
	}

	@Override
	public MessagesChatRoom modifier(MessagesChatRoom entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<MessagesChatRoom> selectAll() {
		return dao.selectAll();
	}

	@Override
	public MessagesChatRoom findById(Long id) {
		return dao.findById(id);
	}

	public void setDao(MessagesChatRoomDaoImpl dao) {
		this.dao = dao;
	}

	


}
