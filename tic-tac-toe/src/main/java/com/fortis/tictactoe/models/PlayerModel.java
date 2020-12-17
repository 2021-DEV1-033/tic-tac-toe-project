package com.fortis.tictactoe.models;

import com.fortis.tictactoe.entities.Player;

public class PlayerModel {
	private String name;
	private String uuid;

	public PlayerModel() {
	}

	public PlayerModel(String name, String uuid) {
		super();
		this.name = name;
		this.uuid = uuid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

	public static PlayerModel fromPlayer(Player player) {
		return new PlayerModel(player.getName(), player.getUuid());
	}
}
