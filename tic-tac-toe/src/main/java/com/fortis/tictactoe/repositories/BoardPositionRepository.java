package com.fortis.tictactoe.repositories;

import org.springframework.stereotype.Repository;

import com.fortis.tictactoe.entities.BoardPosition;
import com.fortis.tictactoe.repositories.base.BaseRepository;

@Repository
public interface BoardPositionRepository extends BaseRepository<BoardPosition> {
}
