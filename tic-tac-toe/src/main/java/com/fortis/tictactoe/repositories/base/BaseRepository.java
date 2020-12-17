package com.fortis.tictactoe.repositories.base;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 
 * This is my standard on project start<br>
 * this make development of Services, repositories easier and faster and make developer skip
 * the basics of Repositories and Service development 
 * 
 * @NoRepositoryBean will be extended by repositories
 * 
 * 
 * @author the developer
 *
 * @param <T> the managed entity class
 */
@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, Long> {
	Optional<T> findByUuid(String uuid);
	void deleteByUuid(String uuid);
}
