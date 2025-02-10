package com.kuki.tic_tac_toe_be.move.controller;

import com.kuki.tic_tac_toe_be.game.dto.GameResponseDTO;
import com.kuki.tic_tac_toe_be.move.entity.Move;
import com.kuki.tic_tac_toe_be.move.service.MoveService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MoveController {
     private final MoveService moveService;

     public MoveController(MoveService moveService) {
          this.moveService = moveService;
     }

     @MessageMapping("/move")
     @SendTo("/topic/game")
     public GameResponseDTO processMove(Move move) {
          return moveService.processMove(move);
     }
}
