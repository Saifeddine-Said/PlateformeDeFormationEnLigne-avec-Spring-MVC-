package com.pfe.elearning.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class PieceJointeEmail implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPiece;
	private String nomPiece;
	private Date dateDepot;
	@Lob
	private byte[] pieceJointe;

	@ManyToOne
	@JoinColumn(name = "idEmail")
	private Email email;

	public PieceJointeEmail(String nomPiece, Date dateDepot, byte[] pieceJointe) {
		super();
		this.nomPiece = nomPiece;
		this.dateDepot = dateDepot;
		this.pieceJointe = pieceJointe;
	}

	public PieceJointeEmail() {
		super();
	}

	public Long getIdPiece() {
		return idPiece;
	}

	public void setIdPiece(Long idPiece) {
		this.idPiece = idPiece;
	}

	public String getNomPiece() {
		return nomPiece;
	}

	public void setNomPiece(String nomPiece) {
		this.nomPiece = nomPiece;
	}

	public Date getDateDepot() {
		return dateDepot;
	}

	public void setDateDepot(Date dateDepot) {
		this.dateDepot = dateDepot;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public byte[] getPieceJointe() {
		return pieceJointe;
	}

	public void setPieceJointe(byte[] pieceJointe) {
		this.pieceJointe = pieceJointe;
	}

}
