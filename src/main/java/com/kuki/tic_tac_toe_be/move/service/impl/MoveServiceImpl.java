package com.kuki.tic_tac_toe_be.move.service.impl;

import com.kuki.tic_tac_toe_be.board.service.BoardService;
import com.kuki.tic_tac_toe_be.game.dto.GameResponseDTO;
import com.kuki.tic_tac_toe_be.game.entity.Game;
import com.kuki.tic_tac_toe_be.game.service.GameService;
import com.kuki.tic_tac_toe_be.move.entity.Move;
import com.kuki.tic_tac_toe_be.move.service.MoveService;
import com.kuki.tic_tac_toe_be.player.service.PlayerService;
import org.springframework.stereotype.Service;

@Service
public class MoveServiceImpl implements MoveService {
     private final GameService gameService;
     private final BoardService boardService;

     public MoveServiceImpl(GameService gameService, BoardService boardService) {
          this.gameService = gameService;
          this.boardService = boardService;
     }

     @Override
     public GameResponseDTO processMove(Move move){
          Game game = gameService.

     }

}
