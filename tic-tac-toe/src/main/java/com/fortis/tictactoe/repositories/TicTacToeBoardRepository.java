package com.fortis.tictactoe.repositories;

import org.springframework.stereotype.Repository;

import com.fortis.tictactoe.entities.TicTacToeBoard;
import com.fortis.tictactoe.repositories.base.BaseRepository;

/**
 * 
 * Board Repository
 * 
 * @author the developer
 *
 */
@Repository
public interface TicTacToeBoardRepository extends BaseRepository<TicTacToeBoard> {
}
