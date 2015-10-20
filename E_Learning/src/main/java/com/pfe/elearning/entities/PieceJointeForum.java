package com.pfe.elearning.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
public class PieceJointeForum implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPiece;
	@Column(name="description")
	@Type(type="text")
	private String description;
	private Date dateDepot;

	@ManyToOne
	@JoinColumn(name = "idMessage")
	private MessagesForum messageForum;

	public PieceJointeForum(String description, Date dateDepot) {
		super();
		this.description = description;
		this.dateDepot = dateDepot;
	}

	public PieceJointeForum() {
		super();
	}

	public Long getIdPiece() {
		return idPiece;
	}

	public void setIdPiece(Long idPiece) {
		this.idPiece = idPiece;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateDepot() {
		return dateDepot;
	}

	public void setDateDepot(Date dateDepot) {
		this.dateDepot = dateDepot;
	}

	public MessagesForum getMessageForum() {
		return messageForum;
	}

	public void setMessageForum(MessagesForum messageForum) {
		this.messageForum = messageForum;
	}

}
