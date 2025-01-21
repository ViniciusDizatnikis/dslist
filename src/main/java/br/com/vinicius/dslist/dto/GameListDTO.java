package br.com.vinicius.dslist.dto;

import br.com.vinicius.dslist.entities.GameList;

public class GameListDTO {
	private long id;
	private String name;
	
	public GameListDTO() {
		// TODO Auto-generated constructor stub
	}

	public GameListDTO(GameList entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
