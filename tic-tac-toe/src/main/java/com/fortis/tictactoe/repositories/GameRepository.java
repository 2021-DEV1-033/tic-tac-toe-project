package com.fortis.tictactoe.repositories;

import org.springframework.stereotype.Repository;

import com.fortis.tictactoe.entities.Game;
import com.fortis.tictactoe.repositories.base.BaseRepository;

@Repository
public interface GameRepository extends BaseRepository<Game> {
}
