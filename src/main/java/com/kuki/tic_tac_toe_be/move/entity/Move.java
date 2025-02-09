package com.kuki.tic_tac_toe_be.move.entity;

import lombok.Data;

@Data
public class Move {
     private int row;
     private int col;
     private String gameId;
     private String playerSymbol;
}
