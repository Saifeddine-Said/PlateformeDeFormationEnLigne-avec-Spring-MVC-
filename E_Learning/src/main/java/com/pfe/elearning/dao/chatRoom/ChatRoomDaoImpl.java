package com.pfe.elearning.dao.chatRoom;

import java.util.List;

import javax.persistence.Query;

import com.pfe.elearning.dao.genericDao.GenericDaoImpl;
import com.pfe.elearning.entities.ChatRoom;
import com.pfe.elearning.entities.MessagesChatRoom;

public class ChatRoomDaoImpl extends GenericDaoImpl<ChatRoom> implements IChatRoomDao {

	@Override
	public List<MessagesChatRoom> messagesChatRooms(Long idChatRoom) {
		Query query=em.createQuery("Select m from ChatRoom c join c.messagesChatRooms m where c.idChatRoom=:x");
		query.setParameter("x", idChatRoom);
		return query.getResultList();
	}

	
}
