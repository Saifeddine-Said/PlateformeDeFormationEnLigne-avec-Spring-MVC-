package com.pfe.elearning.metier.sujetForum;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.sujetForum.SujetForumDaoImpl;
import com.pfe.elearning.entities.MessagesForum;
import com.pfe.elearning.entities.SujetForum;
@Transactional
public class MetierSujetForum implements IMetierSujetForum {
	
	private SujetForumDaoImpl dao;

	@Override
	public SujetForum inserer(SujetForum entity) {
		return dao.inserer(entity);
	}

	@Override
	public SujetForum modifier(SujetForum entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<SujetForum> selectAll() {
		return dao.selectAll();
	}

	@Override
	public SujetForum findById(Long id) {
		return dao.findById(id);
	}
	
	@Override
	public List<MessagesForum> getListMessageForum(Long idSujet) {
		return dao.getListMessageForum(idSujet);
	}

	public void setDao(SujetForumDaoImpl dao) {
		this.dao = dao;
	}

}
