package com.kuki.tic_tac_toe_be.move.service.impl;

import com.kuki.tic_tac_toe_be.board.service.BoardService;
import com.kuki.tic_tac_toe_be.exception.GameException;
import com.kuki.tic_tac_toe_be.game.dto.GameResponseDTO;
import com.kuki.tic_tac_toe_be.game.entity.Game;
import com.kuki.tic_tac_toe_be.game.entity.GameStatus;
import com.kuki.tic_tac_toe_be.game.service.GameService;
import com.kuki.tic_tac_toe_be.move.entity.Move;
import com.kuki.tic_tac_toe_be.move.service.MoveService;
import com.kuki.tic_tac_toe_be.player.service.PlayerService;
import org.springframework.stereotype.Service;

@Service
public class MoveServiceImpl implements MoveService {
     private final GameService gameService;
     private final BoardService boardService;
     private final PlayerService playerService;

     public MoveServiceImpl(GameService gameService, BoardService boardService, PlayerService playerService) {
          this.gameService = gameService;
          this.boardService = boardService;
          this.playerService = playerService;
     }

     @Override
     public GameResponseDTO processMove(Move move){
          Game game = gameService.getGame(move.getGameId());

          if(game.getStatus() != GameStatus.PLAYING){
               throw new GameException("Game already finished");
          }
          if (!game.getCurrentPlayer().getSymbol().equals(move.getPlayerSymbol())) {
               throw new GameException("Not your turn");
          }

          boardService.updateBoard(game.getBoard(), move.getRow(),
                  move.getCol(),
                  move.getPlayerSymbol());
          updateGameStatus(game, move.getPlayerSymbol());
          gameService.saveGame(game);
          return game.ToGameResponseDTO();
     }

     private void updateGameStatus(Game game, String playerSymbol) {
          if (boardService.checkWin(game.getBoard(), playerSymbol)) {
               game.setStatus(GameStatus.WIN);
               game.setWinner(game.getCurrentPlayer());
          } else if (boardService.isDraw(game.getBoard())) {
               game.setStatus(GameStatus.DRAW);
          } else {
               String nextPlayerSymbol = playerSymbol.equals("X") ? "O" : "X";
               game.setCurrentPlayer(playerService.createPlayer(nextPlayerSymbol));
          }
     }

}
