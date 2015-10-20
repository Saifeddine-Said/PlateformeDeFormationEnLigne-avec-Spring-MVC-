package com.pfe.elearning.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class MessagesForum implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMessage;
	private String message;
	private Date dateDepotMessage;
	private boolean messageCorrecte;

	@ManyToOne
	@JoinColumn(name = "idSujet")
	private SujetForum sujetForum;

	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateur;

	@OneToMany(mappedBy = "messageForum")
	private Collection<PieceJointeForum> pieceJointeForums;

	public MessagesForum(String message, Date dateDepotMessage, boolean messageCorrecte) {
		super();
		this.message = message;
		this.dateDepotMessage = dateDepotMessage;
		this.messageCorrecte = messageCorrecte;
	}

	public MessagesForum() {
		super();
	}

	public Long getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Long idMessage) {
		this.idMessage = idMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateDepotMessage() {
		return dateDepotMessage;
	}

	public void setDateDepotMessage(Date dateDepotMessage) {
		this.dateDepotMessage = dateDepotMessage;
	}

	public boolean isMessageCorrecte() {
		return messageCorrecte;
	}

	public void setMessageCorrecte(boolean messageCorrecte) {
		this.messageCorrecte = messageCorrecte;
	}

	public SujetForum getSujetForum() {
		return sujetForum;
	}

	public void setSujetForum(SujetForum sujetForum) {
		this.sujetForum = sujetForum;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Collection<PieceJointeForum> getPieceJointeForums() {
		return pieceJointeForums;
	}

	public void setPieceJointeForums(Collection<PieceJointeForum> pieceJointeForums) {
		this.pieceJointeForums = pieceJointeForums;
	}

}
