<!DOCTYPE html>
<html lang="en">
<%@page
import="com.cloverdcs.stp.game.dao.*,com.cloverdcs.stp.game.service.*,com.cloverdcs.stp.game.entity.*" %>
<head>

    <meta charset="UTF-8">
    <title>Play Game</title>
</head>
<body>

<div>
    <h2> Guess your Number </h2>
    <form action="/number-game/game/play">
        <input type="number" name="guess" value="play"> Guess a number between 1.. 100 </input>
        <input type="hidden" name="game-id" value=<%=request.getParameter("game-id")%> >
        <button type="submit" value="Submit">Play</button>
    </form>
</div>

<div>
<% if (request.getAttribute("message")!= null) { %>

<h3> Message <%=request.getAttribute("message")  %>

<% } %>
</div>

<div>

<h3> Attempts left : <%
       GameDAO obj1 = new GameDAO();
       Game obj2 = new Game();
       Integer id = new Integer(request.getParameter("game-id"));
       obj2 = obj1.read(id);
       out.println(10-obj2.getGuesses().size());
%>
  </h3>

<h4> List of guesses should be shown below </h4>


</div>

</body>
</html>