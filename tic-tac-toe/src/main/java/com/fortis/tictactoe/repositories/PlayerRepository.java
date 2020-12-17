package com.fortis.tictactoe.repositories;

import org.springframework.stereotype.Repository;

import com.fortis.tictactoe.entities.Player;
import com.fortis.tictactoe.repositories.base.BaseRepository;


/**
 * Player Repository
 * 
 * @author the developer
 *
 */
@Repository
public interface PlayerRepository extends BaseRepository<Player> {
}
