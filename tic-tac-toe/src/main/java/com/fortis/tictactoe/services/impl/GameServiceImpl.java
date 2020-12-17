package com.fortis.tictactoe.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortis.tictactoe.entities.Game;
import com.fortis.tictactoe.repositories.GameRepository;
import com.fortis.tictactoe.services.GameService;
import com.fortis.tictactoe.services.base.AbstractBaseServiceImpl;

@Service
public class GameServiceImpl extends AbstractBaseServiceImpl<Game> implements GameService {
	
	private GameRepository gameRepository;
	
	@Autowired
	public GameServiceImpl(GameRepository gameRepository) {
		this.repository = gameRepository;
		this.gameRepository = gameRepository;
	}
}
