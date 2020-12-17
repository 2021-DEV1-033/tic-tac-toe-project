package com.fortis.tictactoe.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fortis.tictactoe.entities.base.BaseEntity;

/**
 * 
 * This entity is a simplified representation of a player and his checked boxes
 * 
 * 
 * @author the developer
 *
 */
@Entity
public class Player extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonIgnore
	private Long id;

	@Column(name = "player_name")
	private String name;

	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "player")
	private Set<BoardPosition> checkedPositions = new HashSet<>();

	public Player() {
		super();
	}
	
	public Player(String name) {
		super();
		this.name = name;
	}
	
	public Player(String name, Set<BoardPosition> checkedPositions) {
		super();
		this.name = name;
		this.checkedPositions = checkedPositions;
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
	 * @return the player name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the player name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the checked positions by this player
	 */
	public Set<BoardPosition> getCheckedPositions() {
		return checkedPositions;
	}

	/**
	 * @param checkedPositions the checked positions to set for this player
	 */
	public void setCheckedPositions(Set<BoardPosition> checkedPositions) {
		this.checkedPositions = checkedPositions;
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
		result = prime * result + Objects.hash(id, name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Player)) {
			return false;
		}
		if (!super.equals(obj)) {
			return false;
		}
		Player other = (Player) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

}
