package com.kuki.tic_tac_toe_be.game.service;

import com.kuki.tic_tac_toe_be.game.entity.Game;

public interface GameService {
     Game createGame(int size);
}
