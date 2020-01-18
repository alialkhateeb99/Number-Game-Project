package com.cloverdcs.stp.game.controller;

import com.cloverdcs.stp.game.dao.GameDAO;
import com.cloverdcs.stp.game.entity.Game;
import com.cloverdcs.stp.game.exception.GameHasEndedException;
import com.cloverdcs.stp.game.exception.GuessToHighException;
import com.cloverdcs.stp.game.exception.GuessToLowException;
import com.cloverdcs.stp.game.exception.MaxGuessExceededException;
import com.cloverdcs.stp.game.service.GameService;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class PlayGameController extends HttpServlet {

    String GAME_ID= "game-id";
    String GUESS ="guess";

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

// IGNORE ME

        int gameId = Integer.parseInt(req.getParameter(GAME_ID));
        int guess = Integer.parseInt(req.getParameter(GUESS));

        GameService gameService = new GameService();
        Game game = new GameDAO().read(gameId);

        try {
            gameService.isGuessCorrect(game, guess);
            req.setAttribute("message", "Your Guess was Correct !!! ");

        } catch (GuessToHighException e) {
              req.setAttribute("message", "Your gues was too high! Try Again!");
        } catch (GuessToLowException e) {
            req.setAttribute("message", "Your guess was too low! Try Again!");
        } catch (MaxGuessExceededException e) {
            req.setAttribute("message", "Sorry! Your reached the maximum number of guesses!");
        } catch (GameHasEndedException e) {
            req.setAttribute("message", "The game has ended! You lost. Sorry!");
        }


        // respond with view game-list.jsp
        req.getRequestDispatcher("/play-game.jsp").forward(req, res);

    }
}
