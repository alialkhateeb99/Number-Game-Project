package com.cloverdcs.stp.game.controller;

import com.cloverdcs.stp.game.service.GameService;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateGameController extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

       // super.service(req, res);

        String doAction = req.getParameter("do-action");

        if ( doAction!= null && doAction.equals("create-game") ) {
            GameService gameService = new GameService();
            gameService.getNewGame() ;
        }

        // respond with view game-list.jsp
        req.getRequestDispatcher("/game-list.jsp").forward(req, res);

    }
}
