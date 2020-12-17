package com.fortis.tictactoe.services.base;

import java.util.Collection;

public interface BaseService<T> {
	T findByUuid(String uuid);
	T findById(Long id);
	Collection<T> findAll();
	T save(T entity);
	Collection<T> save(Collection<T> entities);
	T update(T entity);
	void remove(T entity);
	void removeByUuid(String uuid);
	void removeById(Long id);
	void removeAll(Collection<T> entities);
}