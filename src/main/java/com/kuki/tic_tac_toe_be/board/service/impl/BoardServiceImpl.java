package com.kuki.tic_tac_toe_be.board.service.impl;

import com.kuki.tic_tac_toe_be.board.entity.Board;
import com.kuki.tic_tac_toe_be.board.service.BoardService;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
     @Override
     public  Board createBoard(int size){
          if(size<3){
               throw new IllegalArgumentException("Board size must be greater than 3");
          }
          return new Board(size);
     }
     @Override
     public boolean isValidMove(Board board, int row, int col){
          return row >= 0 && row < board.getSize() &&
                  col >= 0 && col < board.getSize() &&
                  board.getGrid()[row][col].isEmpty();
     }

     @Override
     public void updateBoard(Board board, int row, int col, String symbol){
          if (!isValidMove(board, row, col)) {
               throw new IllegalArgumentException("Invalid move");
          }
          board.getGrid()[row][col] = symbol;
     }

     private boolean checkRows(Board board, String symbol) {
          for (int i = 0; i < board.getSize(); i++) {
               if (checkLine(board.getGrid()[i], symbol)) {
                    return true;
               }
          }
          return false;
     }

     private boolean checkColumns(Board board, String symbol) {
          for (int col = 0; col < board.getSize(); col++) {
               boolean win = true;
               for (int row = 0; row < board.getSize(); row++) {
                    if (!board.getGrid()[row][col].equals(symbol)) {
                         win = false;
                         break;
                    }
               }
               if (win) return true;
          }
          return false;
     }

     private boolean checkDiagonals(Board board, String symbol) {
          boolean mainDiag = true;
          boolean antiDiag = true;

          for (int i = 0; i < board.getSize(); i++) {
               if (!board.getGrid()[i][i].equals(symbol)) {
                    mainDiag = false;
               }
               if (!board.getGrid()[i][board.getSize()-1-i].equals(symbol)) {
                    antiDiag = false;
               }
          }

          return mainDiag || antiDiag;
     }

     private boolean checkLine(String[] line, String symbol) {
          for (String cell : line) {
               if (!cell.equals(symbol)) {
                    return false;
               }
          }
          return true;
     }

     @Override
     public boolean checkWin(Board board, String symbol){
          return checkRows(board, symbol) || checkColumns(board, symbol) || checkDiagonals(board, symbol);
     }

     @Override
     public boolean isDraw(Board board){
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
