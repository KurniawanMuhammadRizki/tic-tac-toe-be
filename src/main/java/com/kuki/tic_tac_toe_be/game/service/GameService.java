package com.kuki.tic_tac_toe_be.game.service;

import com.kuki.tic_tac_toe_be.game.dto.GameResponseDTO;
import com.kuki.tic_tac_toe_be.game.entity.Game;

public interface GameService {
     GameResponseDTO createGame(int size);
     Game getGame(String gameId);
     Game saveGame(Game game);
}
