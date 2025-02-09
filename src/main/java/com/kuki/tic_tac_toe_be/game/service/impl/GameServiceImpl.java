package com.kuki.tic_tac_toe_be.game.service.impl;

import com.kuki.tic_tac_toe_be.board.entity.Board;
import com.kuki.tic_tac_toe_be.board.service.BoardService;
import com.kuki.tic_tac_toe_be.game.dto.GameResponseDTO;
import com.kuki.tic_tac_toe_be.game.entity.Game;
import com.kuki.tic_tac_toe_be.game.entity.GameStatus;
import com.kuki.tic_tac_toe_be.game.repository.GameRepository;
import com.kuki.tic_tac_toe_be.game.service.GameService;
import com.kuki.tic_tac_toe_be.player.entity.Player;
import com.kuki.tic_tac_toe_be.player.service.PlayerService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
     private final BoardService boardService;
     private final PlayerService playerService;
     private final GameRepository gameRepository;


     public GameServiceImpl(BoardService boardService, PlayerService playerService, GameRepository gameRepository) {
          this.boardService = boardService;
          this.playerService = playerService;
          this.gameRepository = gameRepository;
     }

     @Override
     public GameResponseDTO createGame(int size){
          Board board = boardService.createBoard(size);
          Player p1 = playerService.createPlayer("X");
          Player p2 = playerService.createPlayer("O");

          Game game = new Game();
          game.setId(RandomStringUtils.randomAlphanumeric(6));
          game.setBoard(board);
          game.setCurrentPlayer(p1);
          game.setStatus(GameStatus.PLAYING);
          gameRepository.save(game);

          return convertToGameResponseDTO(game);
     }

     @Override
     public Game getGame(String gameId){
          Game game =  gameRepository.findById(gameId);
          if(game == null){
               throw new IllegalArgumentException("Game not found");
          }
          return game;
     }

     private GameResponseDTO convertToGameResponseDTO(Game game) {
          GameResponseDTO gameResponseDTO = new GameResponseDTO();
          gameResponseDTO.setGameId(game.getId());
          gameResponseDTO.setBoard(game.getBoard().getGrid());
          gameResponseDTO.setCurrentPlayer(game.getCurrentPlayer().getSymbol());
          gameResponseDTO.setStatus(game.getStatus().toString());

          if (game.getWinner() != null) {
               gameResponseDTO.setWinner(game.getWinner().getSymbol());
          }
          return gameResponseDTO;
     }

}
