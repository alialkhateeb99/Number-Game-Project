package com.cloverdcs.stp.game.service;

import com.cloverdcs.stp.game.dao.GameDAO;
import com.cloverdcs.stp.game.entity.Game;
import com.cloverdcs.stp.game.exception.GameHasEndedException;
import com.cloverdcs.stp.game.exception.GuessToHighException;
import com.cloverdcs.stp.game.exception.GuessToLowException;
import com.cloverdcs.stp.game.exception.MaxGuessExceededException;

public class GameService {


    private static int randomNumberGenerator() {
        int generatedNumber = (int) (100 * Math.random());
        return generatedNumber;
    }

    public Game getNewGame() {

        //instansiate a new game
        // create a random # between 1..100
        //assign to the game
        //assign the player to the game
        //save the game
        // return a new game
        Game game = new Game();
        game.setRandomNumberGenerated(randomNumberGenerator());
        game.setActive(true);
        GameDAO gameDAO = new GameDAO();
        game = gameDAO.save(game);
        return game;

    }

    public int getTotalGamesPlayed(){
        return new GameDAO().getAllGames().size();
    }

    /**
     * This method will take guess and validate if the guess is correct. If correct it return 'true'
     * If the guess is incorrect it throws an exception that will indicate if the guess is too high or
     * too low.
     *
     * @param game
     * @param guessedNumber
     * @return
     * @throws GuessToHighException
     * @throws GuessToLowException
     */
    public boolean isGuessCorrect(Game game, int guessedNumber)
            throws GuessToHighException, GuessToLowException, MaxGuessExceededException, GameHasEndedException {

        // check if game is active
        // if not then throw a GameHasEndedException
        if (!game.isActive()) throw new GameHasEndedException();
        if (checkMaxGuessExceeded(game)) throw new MaxGuessExceededException();

        if (game.getRandomNumberGenerated() == guessedNumber) {
            // Set GAME as WON
            // End Game
            game.getGuesses().add(guessedNumber);
            game.setGameStatus("WON");
            game.setActive(false);
            game.setAttempts(game.getGuesses().size());
            return true;
        } else {

            game.getGuesses().add(guessedNumber);
            if (game.getRandomNumberGenerated() < guessedNumber) throw new GuessToHighException();
            else throw new GuessToLowException();
        }
    }




    /**
     * check for the maximum number of guesses by the user.
     *
     * @param game
     * @throws MaxGuessExceededException
     */
    private  boolean checkMaxGuessExceeded(Game game)  {

        if (game.getGuesses().size() >= 10) {
            // Check if max guesses exceeded
            // if yes
            // Set Game as disabled
            // Set Game as LOST
            // throw a new custom exception MaxGuessExceededException
            game.setGameStatus("lost");
            game.setActive(false);
            //TODO : Discuss how to encapsulate this information
            game.setAttempts(10);
            return true;


        } else {
            return false;
        }


    }


}