package com.pfe.elearning.metier.faq;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.faq.FaqDaoImpl;
import com.pfe.elearning.entities.FAQ;
@Transactional
public class MetierFaqImpl implements IMetierFaq {
	
	private FaqDaoImpl dao;

	@Override
	public FAQ inserer(FAQ entity) {
		return dao.inserer(entity);
	}

	@Override
	public FAQ modifier(FAQ entity) {
		return dao.modifier(entity);
	}

	@Override
	public void supprimer(Long id) {
		dao.supprimer(id);
	}

	@Override
	public List<FAQ> selectAll() {
		return dao.selectAll();
	}

	@Override
	public FAQ findById(Long id) {
		return dao.findById(id);
	}

	public void setDao(FaqDaoImpl dao) {
		this.dao = dao;
	}

}
