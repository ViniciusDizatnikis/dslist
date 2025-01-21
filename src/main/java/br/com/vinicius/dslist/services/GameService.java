package br.com.vinicius.dslist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vinicius.dslist.dto.GameDTO;
import br.com.vinicius.dslist.dto.GameMinDTO;
import br.com.vinicius.dslist.entities.Game;
import br.com.vinicius.dslist.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findByID(Long id) {
        Optional<Game> result = gameRepository.findById(id);
        if (result.isPresent()) {
            return new GameDTO(result.get());
        } else {
            System.out.println("Não foi possível achar o jogo com o ID: " + id);
            throw new IllegalArgumentException("Jogo não encontrado com o ID: " + id);
        }
    }
}
