package com.pfe.elearning.metier.chatRoom;

import java.util.List;

import com.pfe.elearning.entities.ChatRoom;
import com.pfe.elearning.entities.ChatRoom;
import com.pfe.elearning.entities.MessagesChatRoom;

public interface IMetierChatRoom {

	public ChatRoom inserer(ChatRoom entity);

	public ChatRoom modifier(ChatRoom entity);

	public void supprimer(Long id);

	public List<ChatRoom> selectAll();

	public ChatRoom findById(Long id);
	
	public List<MessagesChatRoom>messagesChatRooms(Long idChatRoom);

}
