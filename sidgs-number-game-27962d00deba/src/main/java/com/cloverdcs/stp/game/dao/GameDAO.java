package com.cloverdcs.stp.game.dao;
import com.cloverdcs.stp.game.entity.Game;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *  Used to perform CRUD Operations on a game
 *  save|update|delete|read
 */
public class GameDAO {
    private static int gameID;
    // Stores inforamtion about all the games
    static  HashMap<Integer, Game> inmemoryGameDatasource=new HashMap<Integer, Game>();


    private int getGameID() {
        gameID = gameID + 1;
        return gameID;
    }

    public Game save(Game game) {
        //set the gameId
        gameID = getGameID();
        game.setGameId(gameID);
        // add the game to the inmemoryGameDatasource
        inmemoryGameDatasource.put (new Integer(game.getGameId()),game);
        // Key is the gameId and Value is the game
        return inmemoryGameDatasource.get(gameID);
    }

    public void update(Game game) {
        inmemoryGameDatasource.replace(new Integer(game.getGameId()),game);
    }

    public void delete(Game game) {
        inmemoryGameDatasource.remove(new Integer(game.getGameId()),game);
    }

    public Game read(int gameId) {
        return inmemoryGameDatasource.get(new Integer(gameId));
    }

    public Collection<Game> getAllGames() {
        return inmemoryGameDatasource.values();
    }

}
