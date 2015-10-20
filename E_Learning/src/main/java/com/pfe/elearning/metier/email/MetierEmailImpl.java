package com.pfe.elearning.metier.email;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.email.EmailDaoImpl;
import com.pfe.elearning.entities.Email;
import com.pfe.elearning.entities.PieceJointeEmail;
@Transactional
public class MetierEmailImpl implements IMetierEmail {

	private EmailDaoImpl dao;
	
	@Override
	public Email inserer(Email entity) {
		return dao.inserer(entity);
	}

	@Override
	public Email modifier(Email entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<Email> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Email findById(Long id) {
		return dao.findById(id);
	}

	public void setDao(EmailDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<PieceJointeEmail> listePiecejointeParEmail(Long idEmail) {
		return dao.listePiecejointeParEmail(idEmail);
	}

}
