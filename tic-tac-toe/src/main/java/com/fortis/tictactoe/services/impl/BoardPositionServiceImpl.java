package com.fortis.tictactoe.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortis.tictactoe.entities.BoardPosition;
import com.fortis.tictactoe.repositories.BoardPositionRepository;
import com.fortis.tictactoe.services.BoardPositionService;
import com.fortis.tictactoe.services.base.AbstractBaseServiceImpl;

@Service
public class BoardPositionServiceImpl extends AbstractBaseServiceImpl<BoardPosition> implements BoardPositionService {
	
	private BoardPositionRepository boardPositionRepository;
	
	@Autowired
	public BoardPositionServiceImpl(BoardPositionRepository boardPositionRepository) {
		this.repository = boardPositionRepository;
		this.boardPositionRepository = boardPositionRepository;
	}
}
