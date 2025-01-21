package br.com.vinicius.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vinicius.dslist.entities.Game;
import br.com.vinicius.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
