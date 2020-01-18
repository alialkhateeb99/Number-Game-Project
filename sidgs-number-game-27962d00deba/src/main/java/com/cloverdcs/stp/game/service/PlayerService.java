package com.cloverdcs.stp.game.service;

import com.cloverdcs.stp.game.dao.PlayerDAO;
import com.cloverdcs.stp.game.entity.Game;
import com.cloverdcs.stp.game.entity.Player;

import java.util.List;

public class PlayerService {

    public Player createPlayer(Player player, String name, String email_id) {
        player.setName(name);
        player.setEmail(email_id);
        PlayerDAO playerDAO = new PlayerDAO();
        return playerDAO.save(player);
    }

   public List<Game> getPlayerGameSummary(Player player)
    {
        return player.getList();
    }


}
