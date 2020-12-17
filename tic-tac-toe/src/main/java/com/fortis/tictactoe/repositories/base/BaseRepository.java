package com.fortis.tictactoe.repositories.base;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, Long> {
	Optional<T> findByUuid(String uuid);
	void deleteByUuid(String uuid);
}
