package com.kuki.tic_tac_toe_be.game.entity;

import com.kuki.tic_tac_toe_be.board.entity.Board;
import com.kuki.tic_tac_toe_be.player.entity.Player;
import lombok.Data;

@Data
public class Game {
     private String id;
     private Board board;
     private Player currentPlayer;
     private Player winner;
     private GameStatus status;

}

