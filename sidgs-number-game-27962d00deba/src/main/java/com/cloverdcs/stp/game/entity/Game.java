package com.cloverdcs.stp.game.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *  This class holds information about a game
 */
public class Game {

    private String gameName = null ;
    private int gameId ;
    private int attempts;
    private int randomNumberGenerated;
    private List<Integer> guesses= new ArrayList<Integer>();
    private Player player ;
    // WON|LOST
    private String gameStatus ;

    private boolean active ;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getAttempts() {
        return this.attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getRandomNumberGenerated() {
        return randomNumberGenerated;
    }

    public void setRandomNumberGenerated(int randomNumberGenerated) {
        this.randomNumberGenerated = randomNumberGenerated;
    }

    public List<Integer> getGuesses() {
        return guesses;
    }

    public void setGuesses(List<Integer> guesses) {
        this.guesses = guesses;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return gameId == game.gameId &&
                attempts == game.attempts &&
                randomNumberGenerated == game.randomNumberGenerated &&
                active == game.active &&
                Objects.equals(gameName, game.gameName) &&
                Objects.equals(gameStatus, game.gameStatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(gameName, gameId, attempts, randomNumberGenerated, gameStatus, active);
    }
}
