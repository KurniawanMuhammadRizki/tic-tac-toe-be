package com.kuki.tic_tac_toe_be.game.repository;

import com.kuki.tic_tac_toe_be.game.entity.Game;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class GameRepository {
     private final Map<String, Game> games = new ConcurrentHashMap<>();
     public Game save(Game game) {
          games.put(game.getId(), game);
          return game;
     }

     public Game findById(String id) {
          return games.get(id);
     }
}
