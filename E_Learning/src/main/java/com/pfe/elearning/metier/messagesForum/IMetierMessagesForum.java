package com.pfe.elearning.metier.messagesForum;

import java.util.List;

import com.pfe.elearning.entities.MessagesForum;
import com.pfe.elearning.entities.PieceJointeForum;

public interface IMetierMessagesForum {

	public MessagesForum inserer(MessagesForum entity);

	public MessagesForum modifier(MessagesForum entity);

	public void supprimer(Long id);

	public List<MessagesForum> selectAll();

	public MessagesForum findById(Long id);
	
	public List<PieceJointeForum>getListPieceJointeForums(Long idMessage);

}
