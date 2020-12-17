package com.fortis.tictactoe.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortis.tictactoe.entities.TicTacToeBoard;
import com.fortis.tictactoe.repositories.TicTacToeBoardRepository;
import com.fortis.tictactoe.services.TicTacToeBoardService;
import com.fortis.tictactoe.services.base.AbstractBaseServiceImpl;


/**
 * {@link TicTacToeBoardServiceImpl} the {@link TicTacToeBoard} Service Implementation
 * 
 * @author karim
 *
 */
@Service
public class TicTacToeBoardServiceImpl extends AbstractBaseServiceImpl<TicTacToeBoard> implements TicTacToeBoardService {
	
	private TicTacToeBoardRepository tacToeBoardRepository;
	
	@Autowired
	public TicTacToeBoardServiceImpl(TicTacToeBoardRepository tacToeBoardRepository) {
		this.repository = tacToeBoardRepository;
		this.tacToeBoardRepository = tacToeBoardRepository;
	}
}
