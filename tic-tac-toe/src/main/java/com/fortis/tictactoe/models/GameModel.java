package com.fortis.tictactoe.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fortis.tictactoe.entities.Game;
/**
 * 
 * Simplified game model
 * 
 * @author the developer
 *
 */
public class GameModel {
	private String uuid;
	private PlayerModel firstPlayer;
	private PlayerModel secondPlayer;
	private List<BoardPositionModel> boardPositions = new ArrayList<>();
	
	public GameModel() {
	}
	
	public GameModel(String uuid, PlayerModel firstPlayer, PlayerModel secondPlayer, List<BoardPositionModel> boardPositions) {
		super();
		this.uuid = uuid;
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		this.boardPositions = boardPositions;
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the firstPlayer
	 */
	public PlayerModel getFirstPlayer() {
		return firstPlayer;
	}

	/**
	 * @param firstPlayer the firstPlayer to set
	 */
	public void setFirstPlayer(PlayerModel firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	/**
	 * @return the secondPlayer
	 */
	public PlayerModel getSecondPlayer() {
		return secondPlayer;
	}

	/**
	 * @param secondPlayer the secondPlayer to set
	 */
	public void setSecondPlayer(PlayerModel secondPlayer) {
		this.secondPlayer = secondPlayer;
	}

	/**
	 * @return the boardPositions
	 */
	public List<BoardPositionModel> getBoardPositions() {
		return boardPositions;
	}

	/**
	 * @param boardPositions the boardPositions to set
	 */
	public void setBoardPositions(List<BoardPositionModel> boardPositions) {
		this.boardPositions = boardPositions;
	}

	public static GameModel fromGame(Game game) {
		return new GameModel(game.getUuid(), PlayerModel.fromPlayer(game.getPlayerOne()), PlayerModel.fromPlayer(game.getPlayerTow()),
				game.getBoard().getPositions().stream().map(position->BoardPositionModel.from(position)).collect(Collectors.toList()));
	}
}
