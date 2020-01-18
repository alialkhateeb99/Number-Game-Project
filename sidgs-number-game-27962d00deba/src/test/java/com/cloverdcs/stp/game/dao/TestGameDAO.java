package com.cloverdcs.stp.game.dao;

import com.cloverdcs.stp.game.entity.Game;
import org.junit.Test;

public class TestGameDAO {

    @Test
    public void testSave(){
        int gameID = 1;
        Game game = new Game();
        GameDAO gamedao = new GameDAO();
        gamedao.inmemoryGameDatasource.put(gameID,game);
        //testing game id is always greater than 0 or not
        assert (gameID > 0);
        //testing weather the hash map is containing the game id as its key
        assert (gamedao.inmemoryGameDatasource.containsKey(gameID));
        //testing weather the hash map is containing the given game object in it or not
        assert (gamedao.inmemoryGameDatasource.containsValue(game));
        //testing weather the game in the hash map is same as the game object sent by the gameService
        assert (gamedao.save(game).equals(gamedao.inmemoryGameDatasource.get(game.getGameId())));

    }

    @Test
    public void testUpdate(){

        GameDAO gamedao = new GameDAO();
        int gameId = 1;
        Game game1 = new Game();
        Game game2 = new Game();
        gamedao.inmemoryGameDatasource.put(1,game1);
        gamedao.update(game2);
        //tests if the value of game is up dated in to the list or not
        assert(gamedao.inmemoryGameDatasource.containsValue(game2));
        //tests if the new game object is assigned to gameID that is existing in the list

    }

    @Test
    public void testDelete(){

        GameDAO gameDAO = new GameDAO();
        Game game = new Game();
        gameDAO.save(game);
        gameDAO.delete(game);
        //tests if the value of game of a particular game id is deleted or not
        // as its already deleted soo it will be null and hash map gives null pointer exception
        // soo try catch block will handle it and asserts true
        try {
            gameDAO.inmemoryGameDatasource.get(game.getGameId());
        }
        catch (NullPointerException e)
        {
            assert true;
        }
    }

    @Test
    public void testRead(){
        GameDAO gamedao = new GameDAO();
        Game game = new Game();
        gamedao.save(game);
        assert (gamedao.read(game.getGameId()).equals(gamedao.inmemoryGameDatasource.get(game.getGameId())));
    }



}
