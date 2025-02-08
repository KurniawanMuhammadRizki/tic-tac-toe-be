package com.kuki.tic_tac_toe_be.player.service.impl;

import com.kuki.tic_tac_toe_be.player.entity.Player;
import com.kuki.tic_tac_toe_be.player.service.PlayerService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.random.RandomGenerator;

@Service
public class PlayerServiceImpl implements PlayerService {

     @Override
     public Player createPlayer(String symbol){
          Player player = new Player();
          player.setId(RandomStringUtils.randomAlphanumeric(6));
          player.setSymbol(symbol);
          return player;
     }
}
