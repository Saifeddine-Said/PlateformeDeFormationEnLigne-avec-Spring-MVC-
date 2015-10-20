package com.pfe.elearning.metier.pieceJointeEmail;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.pieceJointeEmail.PieceJointeEmailDaoImpl;
import com.pfe.elearning.entities.PieceJointeEmail;

@Transactional
public class MetierPieceJointeEmailImpl implements IMetierPieceJointeEmail {

	private PieceJointeEmailDaoImpl dao;

	@Override
	public PieceJointeEmail inserer(PieceJointeEmail entity) {
		return dao.inserer(entity);
	}

	@Override
	public PieceJointeEmail modifier(PieceJointeEmail entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<PieceJointeEmail> selectAll() {
		return dao.selectAll();
	}

	@Override
	public PieceJointeEmail findById(Long id) {
		return dao.findById(id);
	}

	public void setDao(PieceJointeEmailDaoImpl dao) {
		this.dao = dao;
	}

}
