package com.pfe.elearning.dao.email;

import java.util.List;

import com.pfe.elearning.dao.genericDao.IGenericDao;
import com.pfe.elearning.entities.Email;
import com.pfe.elearning.entities.PieceJointeEmail;

public interface IEmailDao extends IGenericDao<Email> {
	
	public List<PieceJointeEmail> listePiecejointeParEmail(Long idEmail);

}
