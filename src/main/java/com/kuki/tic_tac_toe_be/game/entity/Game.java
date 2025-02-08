package com.kuki.tic_tac_toe_be.game.entity;

import lombok.Data;

@Data
public class Game {
     private String gameId;
     private String [][] board;
     private String currentPlayer;
     private String status;
     private String winner;
}

