package br.com.vinicius.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vinicius.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
