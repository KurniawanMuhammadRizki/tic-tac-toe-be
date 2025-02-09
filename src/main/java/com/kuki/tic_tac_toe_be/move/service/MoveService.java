package com.kuki.tic_tac_toe_be.move.service;

import com.kuki.tic_tac_toe_be.game.dto.GameResponseDTO;
import com.kuki.tic_tac_toe_be.move.entity.Move;

public interface MoveService {
     GameResponseDTO processMove(Move move);

}
