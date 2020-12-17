package com.fortis.tictactoe.services.base;

import java.util.Collection;


/**
 * 
 * This is my standard on project start<br>
 * This make development of Services, repositories easier and faster and make developer skip
 * the basics of Repositories and Service development <br>
 * 
 * This will be implemented by services
 * 
 * @author the developer
 * 
 *
 * @param <T>
 */
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