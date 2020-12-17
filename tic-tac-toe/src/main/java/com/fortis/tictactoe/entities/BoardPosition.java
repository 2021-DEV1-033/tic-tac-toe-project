package com.fortis.tictactoe.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fortis.tictactoe.entities.base.BaseEntity;


/**
 * This entity represent the box position in the board<br>
 * The position can be checked by a player, or empty
 * If it's not checked, the next player can check it 
 * and add it to the list of his checked box
 * @author the developer
 *
 */
@Entity
public class BoardPosition extends BaseEntity {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;
    
    @Column(name = "vertical", nullable = false)
    private Integer vertical;
    
    @Column(name = "horizontal", nullable = false)
    private Integer horizontal;
    
    @Column(name = "checked")
    private boolean checked = false;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    private Player player;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    private TicTacToeBoard board;

	public BoardPosition() {
	}

	public BoardPosition(Integer vertical, Integer horizontal) {
		super();
		this.vertical = vertical;
		this.horizontal = horizontal;
	}

	public BoardPosition(Integer vertical, Integer horizontal, TicTacToeBoard board) {
		super();
		this.vertical = vertical;
		this.horizontal = horizontal;
		this.board = board;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the vertical coordinates
	 */
	public Integer getVertical() {
		return vertical;
	}

	/**
	 * @param vertical the vertical coordinates to set
	 */
	public void setVertical(Integer vertical) {
		this.vertical = vertical;
	}

	/**
	 * @return the horizontal coordinates
	 */
	public Integer getHorizontal() {
		return horizontal;
	}

	/**
	 * @param horizontal the horizontal coordinates to set
	 */
	public void setHorizontal(Integer horizontal) {
		this.horizontal = horizontal;
	}

	/**
	 * @return the checked status
	 */
	public boolean isChecked() {
		return checked;
	}

	/**
	 * @param checked : checked status to set
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	/**
	 * @return the the player who checked this position
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player who checked this position to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @return the game board
	 */
	public TicTacToeBoard getBoard() {
		return board;
	}

	/**
	 * @param board the game board to set
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
		result = prime * result + Objects.hash(checked, horizontal, id, vertical);
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
		if (!(obj instanceof BoardPosition)) {
			return false;
		}
		BoardPosition other = (BoardPosition) obj;
		return checked == other.checked && Objects.equals(horizontal, other.horizontal) && Objects.equals(id, other.id)
				&& Objects.equals(vertical, other.vertical);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardPosition [id=");
		builder.append(id);
		builder.append(", vertical=");
		builder.append(vertical);
		builder.append(", horizontal=");
		builder.append(horizontal);
		builder.append(", checked=");
		builder.append(checked);
		builder.append("]");
		return builder.toString();
	}
    

}
