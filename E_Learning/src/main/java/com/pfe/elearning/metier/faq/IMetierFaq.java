package com.pfe.elearning.metier.faq;

import java.util.List;

import com.pfe.elearning.entities.FAQ;

public interface IMetierFaq {
	
	public FAQ inserer(FAQ entity);

	public FAQ modifier(FAQ entity);

	public void supprimer(Long id);

	public List<FAQ> selectAll();

	public FAQ findById(Long id);

}
