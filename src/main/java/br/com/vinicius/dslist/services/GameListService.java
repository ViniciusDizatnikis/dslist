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
import br.com.vinicius.dslist.projections.GameMinProjection;
import br.com.vinicius.dslist.repositories.GameListRepository;
import br.com.vinicius.dslist.repositories.GameRepository;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gamelistRepository;
    
    
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gamelistRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }
    
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
    	List<GameMinProjection> list = gameRepository.searchByList(listId);
    	
    	GameMinProjection obj = list.remove(sourceIndex);
    	list.add(destinationIndex, obj);
    	
    	int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
    	
    	int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
    	
    	for (int i = min; i <= max; i++) {
    		gamelistRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
    	}
    }
}
