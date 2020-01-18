package com.cloverdcs.stp.game.service;

import com.cloverdcs.stp.game.dao.GameDAO;
import com.cloverdcs.stp.game.entity.Game;
import com.cloverdcs.stp.game.exception.GameHasEndedException;
import com.cloverdcs.stp.game.exception.GuessToHighException;
import com.cloverdcs.stp.game.exception.GuessToLowException;
import com.cloverdcs.stp.game.exception.MaxGuessExceededException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestGameService {


    @Test
    public void testGetNewGame() {
        GameService gameService = new GameService();
        Game game = gameService.getNewGame();
        assert (game.getGameId() > 0);
        assert (game.isActive());
        assert (game.getRandomNumberGenerated() > 0 && game.getRandomNumberGenerated() <= 100);
        assert (game.getGameStatus() == null || game.getGameStatus().isEmpty());
        assert (game.getGuesses().size() == 0);
        //validate that game was saved to my database memory
        GameDAO gameDAO = new GameDAO();
        Game game1 = gameDAO.read(game.getGameId());
        assert (game1 != null);
        assert (game1.equals(game));


    }

    @Test
    public void testIsGuessCorrect() {
        GameService gameService = new GameService();
        Game game = gameService.getNewGame();

        // Set my Random # to something I know
        game.setRandomNumberGenerated(10);
        // Expect my Guess to be correct

        try {
            if (gameService.isGuessCorrect(game, 10)) assert true;

            // assert that game is no longer active
            if (!game.isActive()) assert true;

            // assert that game status is won
            if (!game.getGameStatus().equals("WON")) assert true;

            //assert that number is added to the list
            assert (game.getGuesses().contains(10));
            //check the game object we changed is the same object as stored in the db
            GameDAO gameDAO = new GameDAO();
            Game game1 = gameDAO.read(game.getGameId());
            assert (game.equals(game1));


        } catch (GuessToLowException e) {
            assert false;
        } catch (GameHasEndedException | GuessToHighException | MaxGuessExceededException e) {
            assert false;
        }

        //Expect my guess to fail when given higher number by throwing GuessHighException
        game = gameService.getNewGame();
        game.setRandomNumberGenerated(10);
        try {
            gameService.isGuessCorrect(game, 20);
        } catch (GuessToHighException e) {
            System.out.println(e);
            assert true;
        } catch (GuessToLowException | GameHasEndedException | MaxGuessExceededException e) {

            assert false;
        }

        //finally check if the guessed number is added to the list
        assert (game.getGuesses().contains(20));
        //check if its saved to the database aka hashmap
        GameDAO gameDAO = new GameDAO();
        assert (gameDAO.read(game.getGameId()).equals(game));

        // Expect my Guess to fail when given a less number
        game = gameService.getNewGame();
        game.setRandomNumberGenerated(10);
        try {
            if (gameService.isGuessCorrect(game, 5)) assert false;
        } catch (GuessToLowException e) {
            assert true;
        } catch (GameHasEndedException | GuessToHighException | MaxGuessExceededException e) {
            System.out.println(e.getLocalizedMessage());
            assert false;
        }
        assert (gameDAO.read(game.getGameId()).equals(game));

        //Expect isGuessCorrect to throw GameHasEndedException if game isActive is false
        game = gameService.getNewGame();
        game.setActive(false);
        try {
            gameService.isGuessCorrect(game, 10);
        } catch (GameHasEndedException e) {
            assert true;
        } catch (MaxGuessExceededException | GuessToLowException | GuessToHighException e) {
            assert false;
        }
        //expect the isguesscorret to throw maxguessexceded exception if the list is full
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) list.add(1);
        game.setActive(true);
        game.setGuesses(list);

        try {
            gameService.isGuessCorrect(game, 10);
        } catch (MaxGuessExceededException e) {
            assert true;
        } catch (GameHasEndedException | GuessToHighException | GuessToLowException e) {
            //System.out.println(e.getLocalizedMessage());
            assert false;
        }


    }


}



