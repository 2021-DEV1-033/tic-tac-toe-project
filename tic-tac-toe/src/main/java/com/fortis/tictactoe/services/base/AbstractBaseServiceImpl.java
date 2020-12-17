package com.fortis.tictactoe.services.base;

import java.util.Collection;

import com.fortis.tictactoe.repositories.base.BaseRepository;

/**
 * 
 * This is my standard on project start<br>
 * This make development of Services, repositories easier and faster and make developers skip
 * the basics of Repositories and Service development <br>
 * 
 * This the basic services implementation, it can be overridden if developer have a better choice
 * 
 * @author karim
 *
 * @param <T>
 */
public abstract class AbstractBaseServiceImpl<T> implements BaseService<T> {

	protected BaseRepository<T> repository;
	
	@Override
	public T findByUuid(String uuid) {
		return repository.findByUuid(uuid).orElse(null);
	}

	@Override
	public T findById(Long id) {
		return repository.getOne(id);
	}

	@Override
	public Collection<T> findAll() {
		return repository.findAll();
	}

	@Override
	public T save(T entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public Collection<T> save(Collection<T> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public T update(T entity) {
		return repository.save(entity);
	}

	@Override
	public void remove(T entity) {
		repository.delete(entity);
	}

	@Override
	public void removeByUuid(String uuid) {
		repository.deleteByUuid(uuid);
	}

	@Override
	public void removeById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void removeAll(Collection<T> entities) {
		repository.deleteAll(entities);
	}

}
