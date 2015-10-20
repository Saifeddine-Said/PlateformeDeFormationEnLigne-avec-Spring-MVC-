package com.pfe.elearning.metier.PieceJointeForum;

import java.util.List;

import com.pfe.elearning.entities.PieceJointeForum;

public interface IMetierPieceJointeForum {
	public PieceJointeForum inserer(PieceJointeForum entity);

	public PieceJointeForum modifier(PieceJointeForum entity);

	public void supprimer(Long id);

	public List<PieceJointeForum> selectAll();

	public PieceJointeForum findById(Long id);

}
