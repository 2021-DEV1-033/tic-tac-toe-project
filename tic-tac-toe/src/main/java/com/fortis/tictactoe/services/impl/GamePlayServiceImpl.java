package com.fortis.tictactoe.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortis.tictactoe.entities.BoardPosition;
import com.fortis.tictactoe.entities.Game;
import com.fortis.tictactoe.entities.Player;
import com.fortis.tictactoe.entities.TicTacToeBoard;
import com.fortis.tictactoe.enums.ExceptionType;
import com.fortis.tictactoe.enums.GameStatus;
import com.fortis.tictactoe.enums.LineType;
import com.fortis.tictactoe.models.ApiException;
import com.fortis.tictactoe.models.GameResult;
import com.fortis.tictactoe.models.PickBoxAction;
import com.fortis.tictactoe.models.Position;
import com.fortis.tictactoe.services.BoardPositionService;
import com.fortis.tictactoe.services.GamePlayService;
import com.fortis.tictactoe.services.GameService;
import com.fortis.tictactoe.tools.TicTacToeTools;

/**
 * Game Play Service<br>
 * 
 * This is the main service, the way to start game, and check a box 
 * and retrieve game result
 * 
 * 
 * After every boxe-pick action, the system will verify if this action result a winner vertical/horizontal line or diameter
 * if not, the game continue until all boxes are checked by one of the players.
 * 
 * I developed this application, considering that it can be another dimension, more than 3x3 
 * but steel need a 3 sequence to win.
 * 
 * @author the developer
 *
 */
@Service
public class GamePlayServiceImpl implements GamePlayService {

	@Autowired
	private GameService gameService;
	@Autowired
	private BoardPositionService boardPositionService;

	@Override
	public Game startGame(Game game) {
		TicTacToeBoard board = new TicTacToeBoard(game);
		game.setBoard(board);
		board.getPositions().add(new BoardPosition(0, 0, board));
		board.getPositions().add(new BoardPosition(0, 1, board));
		board.getPositions().add(new BoardPosition(0, 2, board));
		board.getPositions().add(new BoardPosition(1, 0, board));
		board.getPositions().add(new BoardPosition(1, 1, board));
		board.getPositions().add(new BoardPosition(1, 2, board));
		board.getPositions().add(new BoardPosition(2, 0, board));
		board.getPositions().add(new BoardPosition(2, 1, board));
		board.getPositions().add(new BoardPosition(2, 2, board));
		if (game.getPlayerOne() == null || game.getPlayerTow() == null || 
				game.getBoard().getPositions() == null || game.getBoard().getPositions().isEmpty()) {
			throw new ApiException("Somethig went wrong while creating the game", ExceptionType.SERVER_ERROR);
		}
		
		return gameService.save(game);
	}

	@Override
	@Transactional
	public GameResult pickBox(PickBoxAction action) {
		if (TicTacToeTools.isNullOrEmpty(action.getGameUuid()) 
			|| TicTacToeTools.isNullOrEmpty(action.getPlayerUuid()) 
			|| action.getHorizontal() == null 
			|| action.getVertical() == null) {
			throw new ApiException(ExceptionType.BAD_REQUEST);
		}
		
		Game game = gameService.findByUuid(action.getGameUuid());
		if (game == null) {
			throw new ApiException("This game does not exist", ExceptionType.UNAUTHORIZED);
		}
		Player currentPlayer = game.getNextPlayer();
		
		if (!action.getPlayerUuid().equals(game.getNextPlayer().getUuid())) {
			throw new ApiException("It's not the turn of this player", ExceptionType.UNAUTHORIZED);
		}

		Optional<BoardPosition> foundPosition = game.getBoard().getPositions().stream().filter(position-> position.getHorizontal().equals(action.getHorizontal())
		&& position.getVertical().equals(action.getVertical()))
		.findFirst();
		
		Stream<BoardPosition> freePositionCount = game.getBoard().getPositions().stream().filter(position-> !position.isChecked());
		if (foundPosition.isEmpty()) {
			throw new ApiException("Selected box does not exist", ExceptionType.FORBIDDEN);
		} else if (foundPosition.get().isChecked()) {
			throw new ApiException("Selected box is already checked", ExceptionType.FORBIDDEN);
		}
		if (game.getPlayerOne().equals(currentPlayer)) {
			game.setNextPlayer(game.getPlayerTow());
		} else {
			game.setNextPlayer(game.getPlayerOne());
		}
		
		gameService.update(game);
		BoardPosition position = foundPosition.get();
		position.setChecked(true);
		position.setPlayer(currentPlayer);
		boardPositionService.update(position);
		LineType wonLine = findAWinner(game.getBoard(), position);
		if (wonLine != null) {
			return new GameResult(position.getPlayer().getName(), wonLine,
					new Position(position.getVertical(), position.getHorizontal()), GameStatus.FINISHED);
		}else if (freePositionCount.count() == 0l) {
			return new GameResult(null, null, new Position(position.getVertical(), position.getHorizontal()), GameStatus.FINISHED);
		} else {
			return new GameResult(null, null, new Position(position.getVertical(), position.getHorizontal()), GameStatus.IN_PROGRESS);
		}
	}
	
	/**
	 * Get the line type if the last action result a won line else null
	 * @param board
	 * @param lastPlayedPosition
	 * @return
	 */
	private LineType findAWinner(TicTacToeBoard board, BoardPosition lastPlayedPosition) {
		Map<LineType, Set<BoardPosition>> possibleWonBoardLines = getPossibleWonBoardLines(board, lastPlayedPosition);
		List<LineType> lineTypes = new ArrayList<>(possibleWonBoardLines.keySet());
		for (int i = 0; i < lineTypes.size(); i++) {
			if (possibleWonBoardLines.get(lineTypes.get(i)).size() == 3) {
				return lineTypes.get(i);
			}
		}
		return null;
	}
	
	
	/**
	 * Get the map of checked boxes by the current player, filtered by line type
	 * @param board
	 * @param position
	 * @return
	 */
	private Map<LineType, Set<BoardPosition>> getPossibleWonBoardLines(TicTacToeBoard board, BoardPosition position) {
		List<BoardPosition> foundNeighbor = getAllConcernedPositions(board.getPositions(), position);
		Map<LineType, Set<BoardPosition>> linesPositions = new HashMap<>();
		linesPositions.put(LineType.HORIZONTAL, new HashSet<>());
		linesPositions.put(LineType.VERTICAL, new HashSet<>());
		linesPositions.put(LineType.LEFT_DIAMETER, new HashSet<>());
		linesPositions.put(LineType.RIGHT_DIAMETER, new HashSet<>());
		
		foundNeighbor.forEach(pos-> {
			if (pos.equals(position)) {
				linesPositions.get(LineType.VERTICAL).add(pos);
				linesPositions.get(LineType.HORIZONTAL).add(pos);
				if (pos.getVertical()==pos.getHorizontal()) {
					linesPositions.get(LineType.LEFT_DIAMETER).add(pos);
				}
				if (pos.getHorizontal() == 2 - pos.getVertical()) {
					linesPositions.get(LineType.RIGHT_DIAMETER).add(pos);
				}
			} else if (pos.getHorizontal().equals(position.getHorizontal())) {
				linesPositions.get(LineType.HORIZONTAL).add(pos);
				if (pos.getVertical()==pos.getHorizontal()) {
					linesPositions.get(LineType.LEFT_DIAMETER).add(pos);
				}
				if (pos.getHorizontal() == 2 - pos.getVertical()) {
					linesPositions.get(LineType.RIGHT_DIAMETER).add(pos);
				}
			} else if (pos.getVertical().equals(position.getVertical())) {
				linesPositions.get(LineType.VERTICAL).add(pos);
				if (pos.getVertical()==pos.getHorizontal()) {
					linesPositions.get(LineType.LEFT_DIAMETER).add(pos);
				}
				if (pos.getHorizontal() == 2 - pos.getVertical()) {
					linesPositions.get(LineType.RIGHT_DIAMETER).add(pos);
				}
			} else {
				if (pos.getVertical()==pos.getHorizontal()) {
					linesPositions.get(LineType.LEFT_DIAMETER).add(pos);
				}
				if (pos.getHorizontal() == 2 - pos.getVertical()) {
					linesPositions.get(LineType.RIGHT_DIAMETER).add(pos);
				}
			}
		});
		
		return linesPositions;
	}
	/**
	 * Get the current player checked boxes, in the same vertical or Horizontal line,
	 * or in the diameter if possible
	 * 
	 * 
	 * @param boardPositions
	 * @param position
	 * @return
	 */
	List<BoardPosition> getAllConcernedPositions(Collection<BoardPosition> boardPositions, BoardPosition position) {
		List<BoardPosition> allConcernedPositions = boardPositions.stream()
		.filter(pos-> pos.isChecked() && pos.getPlayer().equals(position.getPlayer())
				&& (Math.abs(pos.getHorizontal()-position.getHorizontal()) == Math.abs(pos.getVertical()-position.getVertical())
				|| pos.getHorizontal().equals(position.getHorizontal()) || pos.getVertical().equals(position.getVertical()))
				)
		.collect(Collectors.toList());
		return allConcernedPositions;
	}
	
}
