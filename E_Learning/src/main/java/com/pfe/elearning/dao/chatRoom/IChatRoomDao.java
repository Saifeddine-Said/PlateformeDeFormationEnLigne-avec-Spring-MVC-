package com.pfe.elearning.dao.chatRoom;

import java.util.List;

import com.pfe.elearning.dao.genericDao.IGenericDao;
import com.pfe.elearning.entities.*;

public interface IChatRoomDao extends IGenericDao<ChatRoom> {
	
	public List<MessagesChatRoom>messagesChatRooms(Long idChatRoom);

}
