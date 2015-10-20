package com.pfe.elearning.dao.email;

import java.util.List;

import javax.persistence.Query;

import com.pfe.elearning.dao.genericDao.GenericDaoImpl;
import com.pfe.elearning.entities.Email;
import com.pfe.elearning.entities.PieceJointeEmail;

public class EmailDaoImpl extends GenericDaoImpl<Email> implements IEmailDao {

	@Override
	public List<PieceJointeEmail> listePiecejointeParEmail(Long idEmail) {
		Query query = em.createQuery("select p from Email e join e.piecesJointes p where e.idEmail = :x");
		query.setParameter("x", idEmail);
		return query.getResultList();
	}

}
