package com.kuki.tic_tac_toe_be.game.dto;

import lombok.Data;

@Data
public class GameResponseDTO {
     private String gameId;
     private String[][] board;
     private String currentPlayer;
     private String status;
     private String winner;
}
