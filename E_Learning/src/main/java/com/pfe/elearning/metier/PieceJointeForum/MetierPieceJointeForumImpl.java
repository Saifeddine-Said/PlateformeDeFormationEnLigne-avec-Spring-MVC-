package com.pfe.elearning.metier.PieceJointeForum;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.pieceJointeForum.PieceJointeForumDaoImpl;
import com.pfe.elearning.entities.PieceJointeForum;
@Transactional
public class MetierPieceJointeForumImpl implements IMetierPieceJointeForum {
	
	private PieceJointeForumDaoImpl dao;

	@Override
	public PieceJointeForum inserer(PieceJointeForum entity) {
		return dao.inserer(entity);
	}

	@Override
	public PieceJointeForum modifier(PieceJointeForum entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<PieceJointeForum> selectAll() {
		return dao.selectAll();
	}

	@Override
	public PieceJointeForum findById(Long id) {
		return dao.findById(id);
	}

	public void setDao(PieceJointeForumDaoImpl dao) {
		this.dao = dao;
	}

}
