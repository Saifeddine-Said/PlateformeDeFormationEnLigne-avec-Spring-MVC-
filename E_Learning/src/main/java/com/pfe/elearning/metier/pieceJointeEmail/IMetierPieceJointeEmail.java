package com.pfe.elearning.metier.pieceJointeEmail;

import java.util.List;

import com.pfe.elearning.entities.PieceJointeEmail;

public interface IMetierPieceJointeEmail {

	public PieceJointeEmail inserer(PieceJointeEmail entity);

	public PieceJointeEmail modifier(PieceJointeEmail entity);

	public void supprimer(Long id);

	public List<PieceJointeEmail> selectAll();

	public PieceJointeEmail findById(Long id);

}
