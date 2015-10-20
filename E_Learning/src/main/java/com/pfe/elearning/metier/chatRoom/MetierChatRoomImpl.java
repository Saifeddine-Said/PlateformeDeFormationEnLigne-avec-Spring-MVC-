package com.pfe.elearning.metier.chatRoom;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.chatRoom.ChatRoomDaoImpl;
import com.pfe.elearning.entities.Apprenant;
import com.pfe.elearning.entities.ChatRoom;
import com.pfe.elearning.entities.MessagesChatRoom;
@Transactional
public class MetierChatRoomImpl implements IMetierChatRoom {
	
	private ChatRoomDaoImpl dao;

	@Override
	public ChatRoom inserer(ChatRoom entity) {
		return dao.inserer(entity);
	}

	@Override
	public ChatRoom modifier(ChatRoom entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<ChatRoom> selectAll() {
		return dao.selectAll();
	}

	@Override
	public ChatRoom findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<MessagesChatRoom> messagesChatRooms(Long idChatRoom) {
		return dao.messagesChatRooms(idChatRoom);
	}

	public void setDao(ChatRoomDaoImpl dao) {
		this.dao = dao;
	}

	

}
