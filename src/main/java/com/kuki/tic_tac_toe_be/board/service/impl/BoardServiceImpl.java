package com.kuki.tic_tac_toe_be.board.service.impl;

import com.kuki.tic_tac_toe_be.board.entity.Board;
import com.kuki.tic_tac_toe_be.board.service.BoardService;
import com.kuki.tic_tac_toe_be.exception.GameException;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

     @Override
     public Board createBoard(int size, int winningCondition) {
          if (size < 3) {
               throw new GameException("Board size must be greater than 3");
          }

          if (winningCondition < 3) {
               throw new GameException("Winning condition must greater than 3");
          }

          if (winningCondition > size) {
               throw new GameException("Winning condition must less than Board size");
          }

          return new Board(size, winningCondition);
     }

     @Override
     public boolean isValidMove(Board board, int row, int col) {
          return row >= 0 && row < board.getSize() &&
                  col >= 0 && col < board.getSize() &&
                  board.getGrid()[row][col].isEmpty();
     }

     @Override
     public void updateBoard(Board board, int row, int col, String symbol) {
          if (!isValidMove(board, row, col)) {
               throw new GameException("Invalid move");
          }
          board.getGrid()[row][col] = symbol;
     }

     private int getWinCondition(Board board) {
          return (board.getWinningCondition());
     }

     private boolean checkRows(Board board, String symbol) {
          int winCondition = getWinCondition(board);
          for (int i = 0; i < board.getSize(); i++) {
               if (checkLine(board.getGrid()[i], symbol, winCondition)) {
                    return true;
               }
          }
          return false;
     }

     private boolean checkColumns(Board board, String symbol) {
          int winCondition = getWinCondition(board);
          for (int col = 0; col < board.getSize(); col++) {
               int count = 0;
               for (int row = 0; row < board.getSize(); row++) {
                    if (board.getGrid()[row][col].equals(symbol)) {
                         count++;
                         if (count == winCondition) return true;
                    } else {
                         count = 0;
                    }
               }
          }
          return false;
     }

     private boolean checkDiagonals(Board board, String symbol) {
          int winCondition = getWinCondition(board);
          int size = board.getSize();

          for (int startRow = 0; startRow <= size - winCondition; startRow++) {
               for (int startCol = 0; startCol <= size - winCondition; startCol++) {
                    int count = 0;
                    for (int i = 0; i < winCondition; i++) {
                         if (board.getGrid()[startRow + i][startCol + i].equals(symbol)) {
                              count++;
                              if (count == winCondition) return true;
                         } else {
                              break;
                         }
                    }
               }
          }

          for (int startRow = 0; startRow <= size - winCondition; startRow++) {
               for (int startCol = winCondition - 1; startCol < size; startCol++) {
                    int count = 0;
                    for (int i = 0; i < winCondition; i++) {
                         if (board.getGrid()[startRow + i][startCol - i].equals(symbol)) {
                              count++;
                              if (count == winCondition) return true;
                         } else {
                              break;
                         }
                    }
               }
          }

          return false;
     }

     private boolean checkLine(String[] line, String symbol, int winCondition) {
          int count = 0;
          for (String cell : line) {
               if (cell.equals(symbol)) {
                    count++;
                    if (count == winCondition) return true;
               } else {
                    count = 0;
               }
          }
          return false;
     }

     @Override
     public boolean checkWin(Board board, String symbol) {
          return checkRows(board, symbol) || checkColumns(board, symbol) || checkDiagonals(board, symbol);
     }

     @Override
     public boolean isDraw(Board board) {
          for (String[] row : board.getGrid()) {
               for (String cell : row) {
                    if (cell.isEmpty()) {
                         return false;
                    }
               }
          }
          return true;
     }
}
