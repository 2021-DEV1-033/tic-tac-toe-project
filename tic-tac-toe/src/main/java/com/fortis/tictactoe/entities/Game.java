package com.fortis.tictactoe.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fortis.tictactoe.entities.base.BaseEntity;

@Entity
public class Game extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonIgnore
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	private Player playerOne;

	@OneToOne(cascade = CascadeType.ALL)
	private Player playerTow;

	@OneToOne(cascade = CascadeType.ALL)
	private TicTacToeBoard board;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id : the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the first player
	 */
	public Player getPlayerOne() {
		return playerOne;
	}

	/**
	 * @param playerOne the first player to set
	 */
	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	/**
	 * @return the second player
	 */
	public Player getPlayerTow() {
		return playerTow;
	}

	/**
	 * @param playerTow the second player to set
	 */
	public void setPlayerTow(Player playerTow) {
		this.playerTow = playerTow;
	}

	/**
	 * @return the game board
	 */
	public TicTacToeBoard getBoard() {
		return board;
	}

	/**
	 * @param board : the game board to set
	 */
	public void setBoard(TicTacToeBoard board) {
		this.board = board;
	}

	/**
	 * @return the serial version uid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(board, id, playerOne, playerTow);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Game)) {
			return false;
		}
		Game other = (Game) obj;
		return Objects.equals(board, other.board) && Objects.equals(id, other.id)
				&& Objects.equals(playerOne, other.playerOne) && Objects.equals(playerTow, other.playerTow);
	}

}
