package com.kuki.tic_tac_toe_be.game.controller;

import com.kuki.tic_tac_toe_be.game.dto.GameResponseDTO;
import com.kuki.tic_tac_toe_be.game.entity.Game;
import com.kuki.tic_tac_toe_be.game.service.GameService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/game")
public class GameController {
     private final GameService gameService;

     public GameController(GameService gameService) {
          this.gameService = gameService;
     }

     @PostMapping("/start")
     public GameResponseDTO startGame(@RequestParam int size) {
          return gameService.createGame(size);
     }

     @GetMapping("/{gameId}")
     public GameResponseDTO getGame(@PathVariable String gameId) {
          Game game = gameService.getGame(gameId);
          return game.ToGameResponseDTO();
     }
}
