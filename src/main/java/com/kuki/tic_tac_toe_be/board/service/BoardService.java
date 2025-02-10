package com.kuki.tic_tac_toe_be.board.service;

import com.kuki.tic_tac_toe_be.board.entity.Board;

public interface BoardService {
      Board createBoard(int size, int winningCondition);
      boolean isValidMove(Board board, int row, int col);
     void updateBoard(Board board, int row, int col, String symbol);
     boolean checkWin(Board board, String symbol);
     boolean isDraw(Board board);
}
