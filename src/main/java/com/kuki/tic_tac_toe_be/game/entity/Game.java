package com.kuki.tic_tac_toe_be.game.entity;

import com.kuki.tic_tac_toe_be.board.entity.Board;
import com.kuki.tic_tac_toe_be.game.dto.GameResponseDTO;
import com.kuki.tic_tac_toe_be.player.entity.Player;
import lombok.Data;

@Data
public class Game {
     private String id;
     private Board board;
     private Player currentPlayer;
     private Player winner;
     private GameStatus status;

      GameResponseDTO convertToGameResponseDTO() {
          GameResponseDTO gameResponseDTO = new GameResponseDTO();
          gameResponseDTO.setGameId(this.getId());
          gameResponseDTO.setBoard(this.getBoard().getGrid());
          gameResponseDTO.setCurrentPlayer(this.getCurrentPlayer().getSymbol());
          gameResponseDTO.setStatus(this.getStatus().toString());

          if (game.getWinner() != null) {
               gameResponseDTO.setWinner(this.getWinner().getSymbol());
          }
          return gameResponseDTO;
     }
}

