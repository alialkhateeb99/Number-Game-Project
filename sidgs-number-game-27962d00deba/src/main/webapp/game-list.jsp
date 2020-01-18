<!DOCTYPE html>
<%@page
import="com.cloverdcs.stp.game.dao.*,com.cloverdcs.stp.game.service.*,com.cloverdcs.stp.game.entity.*"
contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>

<body>

    <H1 ALINE = CENTER>GAME PAGE</H1>

    <%
       GameDAO dao = new GameDAO();
       GameService gameService = new GameService();

              if ( gameService.getTotalGamesPlayed() <=0 ) {

                       // for (int i = 0 ; i <  5; i++ ) {

                            // Add a new game to the data store
                         //    Game game = gameService.getNewGame();

                         //}
               }

       out.println(new java.util.Date());
     %>

    <Div>
            <table cellspacing="2px" cellpadding="2px" border="1px">
            <tr>
                <th>GAME NO</th>
                <th>STATUS</th>
                <th>ACTIVE/NOT</th>
                <th>ATTEMPTS</th>
                <th>OPTIONS </th>

            </tr>
            <!-- Get a list of Games -->
            <% for (Game game : (new GameDAO()).getAllGames()) { %>
            <tr>
                                <td><%= game.getGameId() %> </td>
                                <td><%= game.getGameStatus()%></td>
                                <td><%= game.isActive()%></td>
                                <td><%= game.getGuesses().size()%></td>
                                <td> <a href="/number-game/play-game.jsp?game-id=<%= game.getGameId() %>"> Play </a> </td>
              </tr>
            <% } %>

        </table>
    </Div>

    <%-- Get the total # of Games Played  --%>
    <div>
    <H4>TOTAL NO OF GAMES PLAYED : <%= gameService.getTotalGamesPlayed() %> </H4>
    </div>



<div>
<form action="./game/create">
  <input type="hidden" name="do-action" value="create-game">
        <button type="submit" value="Submit">Create  Game</button>
</form>

</div>
    <div>



      <button type="submit" value="Submit">Resume the Game</button>




</body>
</html>