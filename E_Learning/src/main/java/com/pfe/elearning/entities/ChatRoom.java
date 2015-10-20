package com.pfe.elearning.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ChatRoom implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idChatRoom;
	private String nomChatRoom;
	private Date dateCreation;

	@OneToMany(mappedBy = "chatRoom")
	private Collection<MessagesChatRoom> messagesChatRooms;

	public ChatRoom() {
		super();
	}

	public ChatRoom(String nomChatRoom, Date dateCreation) {
		super();
		this.nomChatRoom = nomChatRoom;
		this.dateCreation = dateCreation;
	}

	public Long getIdChatRoom() {
		return idChatRoom;
	}

	public void setIdChatRoom(Long idChatRoom) {
		this.idChatRoom = idChatRoom;
	}

	public String getNomChatRoom() {
		return nomChatRoom;
	}

	public void setNomChatRoom(String nomChatRoom) {
		this.nomChatRoom = nomChatRoom;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Collection<MessagesChatRoom> getMessagesChatRooms() {
		return messagesChatRooms;
	}

	public void setMessagesChatRooms(Collection<MessagesChatRoom> messagesChatRooms) {
		this.messagesChatRooms = messagesChatRooms;
	}

}
