package com.pfe.elearning.metier.messagesChatRoom;

import java.util.List;

import com.pfe.elearning.entities.MessagesChatRoom;

public interface IMetierMessagesChatRoom {
	public MessagesChatRoom inserer(MessagesChatRoom entity);

	public MessagesChatRoom modifier(MessagesChatRoom entity);

	public void supprimer(Long id);

	public List<MessagesChatRoom> selectAll();

	public MessagesChatRoom findById(Long id);

}
