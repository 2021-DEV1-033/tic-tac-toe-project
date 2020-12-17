package com.fortis.tictactoe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fortis.tictactoe.entities.BoardPosition;
import com.fortis.tictactoe.entities.Game;
import com.fortis.tictactoe.entities.Player;
import com.fortis.tictactoe.entities.TicTacToeBoard;
import com.fortis.tictactoe.services.BoardPositionService;
import com.fortis.tictactoe.services.GameService;
import com.fortis.tictactoe.services.PlayerService;
import com.fortis.tictactoe.services.TicTacToeBoardService;

/**
 * 
 * Basics services tests
 * 
 * @author the developer
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class TicTacToeProjectApplicationTests {
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private TicTacToeBoardService boardService;
	
	@Autowired
	private BoardPositionService boardPositionService;

	@Test
	void contextLoads() {
	}
	
	@Test
	void playersServiceTest() {
		Player player =  playerService.save(new Player("Me"));
		assertNotNull(player);
		assertEquals(player.getName(), "Me");
		assertNotEquals(player.getName(), "me");
	}
	
	@Test
	void gameServiceTest() {
		Game game =  gameService.save(new Game());
		assertNotNull(game);
		assertEquals(game, gameService.findByUuid(game.getUuid()));
	}
	
	@Test
	void boardServiceTest() {
		TicTacToeBoard board = boardService.save(new TicTacToeBoard());
		assertNotNull(board);
		assertEquals(board, boardService.findByUuid(board.getUuid()));
	}
	
	@Test
	void boardPositionServiceTest() {
		
		BoardPosition boardPosition = boardPositionService.save(new BoardPosition(1,3));
		assertNotNull(boardPosition);
		assertEquals(boardPosition, boardPositionService.findByUuid(boardPosition.getUuid()));
	}

}
