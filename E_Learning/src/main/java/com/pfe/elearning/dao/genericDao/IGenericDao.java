package com.pfe.elearning.dao.genericDao;

import java.util.List;

public interface IGenericDao<E> {

	public E inserer(E entity);

	public E modifier(E entity);

	public void supprimer(Long id);

	public List<E> selectAll();

	public E findById(Long id);

}
