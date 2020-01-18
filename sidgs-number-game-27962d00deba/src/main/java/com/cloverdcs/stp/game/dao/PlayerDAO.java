package com.cloverdcs.stp.game.dao;

import com.cloverdcs.stp.game.entity.Player;

import java.util.HashMap;

public class PlayerDAO {
    static HashMap<String, Player> playerDetails = new HashMap<String, Player>();

    public Player save(Player player) {

        String playerID = player.getEmail();
        playerDetails.put(playerID, player);
        return playerDetails.get(playerID);

    }


    public void delete(Player player) {

        playerDetails.remove(player.getEmail());
    }

    public void update(Player player) {

        playerDetails.replace(player.getEmail(), player);

    }

    public Player read(String email_id) {

        return playerDetails.get(email_id);
    }

}
