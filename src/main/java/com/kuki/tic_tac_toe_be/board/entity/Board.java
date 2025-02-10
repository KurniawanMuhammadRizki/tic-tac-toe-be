package com.kuki.tic_tac_toe_be.board.entity;

import lombok.Data;

@Data
public class Board {
     private String[][] grid;
     private int size;
     private int winningCondition;

     public Board(int size, int winningCondition) {
          this.size = size;
          this.grid = new String[size][size];
          this.winningCondition = winningCondition;
          initializeBoard();
     }

     private void initializeBoard() {
          for (int i = 0; i < size; i++) {
               for (int j = 0; j < size; j++) {
                    grid[i][j] = "";
               }
          }
     }
}
