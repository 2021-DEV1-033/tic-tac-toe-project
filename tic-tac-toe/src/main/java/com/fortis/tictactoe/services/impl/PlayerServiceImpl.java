package com.fortis.tictactoe.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortis.tictactoe.entities.Player;
import com.fortis.tictactoe.repositories.PlayerRepository;
import com.fortis.tictactoe.services.PlayerService;
import com.fortis.tictactoe.services.base.AbstractBaseServiceImpl;

@Service
public class PlayerServiceImpl extends AbstractBaseServiceImpl<Player> implements PlayerService {
	
	private PlayerRepository playerRepository;
	
	@Autowired
	public PlayerServiceImpl(PlayerRepository playerRepository) {
		this.repository = playerRepository;
		this.playerRepository = playerRepository;
	}
}
