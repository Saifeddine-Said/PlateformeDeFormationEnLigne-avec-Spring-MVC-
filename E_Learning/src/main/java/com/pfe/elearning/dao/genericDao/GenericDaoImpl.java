package com.pfe.elearning.dao.genericDao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class GenericDaoImpl<E> implements IGenericDao<E> {

	@PersistenceContext
	protected EntityManager em;

	private Class<E> type;

	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	@Override
	public E inserer(E entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public E modifier(E entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public void supprimer(Long id) {
		em.remove(em.getReference(type, id));
	}

	@Override
	public List<E> selectAll() {
		Query query = em.createQuery("select e from "+type.getSimpleName()+" e");
		return query.getResultList();
	}

	@Override
	public E findById(Long id) {
		E entity = em.find(type, id);
		return entity;
	}

}
