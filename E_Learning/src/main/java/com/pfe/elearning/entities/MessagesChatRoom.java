package com.pfe.elearning.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MessagesChatRoom implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMessageCR;
	private String message;
	private Date dateEnvoi;

	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateur;

	@ManyToOne
	@JoinColumn(name = "idChatRoom")
	private ChatRoom chatRoom;

	public MessagesChatRoom() {
		super();
	}

	public MessagesChatRoom(String message, Date dateEnvoi) {
		super();
		this.message = message;
		this.dateEnvoi = dateEnvoi;
	}

	public Long getIdMessageCR() {
		return idMessageCR;
	}

	public void setIdMessageCR(Long idMessageCR) {
		this.idMessageCR = idMessageCR;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public ChatRoom getChatRoom() {
		return chatRoom;
	}

	public void setChatRoom(ChatRoom chatRoom) {
		this.chatRoom = chatRoom;
	}

}
