package br.com.vinicius.dslist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vinicius.dslist.dto.GameDTO;
import br.com.vinicius.dslist.dto.GameListDTO;
import br.com.vinicius.dslist.dto.GameMinDTO;
import br.com.vinicius.dslist.entities.Game;
import br.com.vinicius.dslist.entities.GameList;
import br.com.vinicius.dslist.repositories.GameListRepository;
import br.com.vinicius.dslist.repositories.GameRepository;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gamelistRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gamelistRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }
}
