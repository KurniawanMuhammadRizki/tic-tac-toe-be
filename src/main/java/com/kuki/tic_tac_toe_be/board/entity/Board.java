package com.kuki.tic_tac_toe_be.board.entity;

import lombok.Data;

@Data
public class Board {
     private String[][] grid;
     private int size;

     public Board(int size) {
          this.size = size;
          this.grid = new String[size][size];
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
