package com.cloverdcs.stp.game.entity;

import org.junit.Test;
 // JUnit Testing for public void methods only
public class TestGame {


    @Test
    public void testAlwaysPasses() {
        assert true ;
    }

    @Test
    public void testGameSettersAndGetters() {

      //assert  (<Boolean Condition>)

      Game game = new Game();
      game.setRandomNumberGenerated(2);
      assert (game.getRandomNumberGenerated() == 2 );

      try {
          game.setGameName("MyTestGame");
          assert (game.getGameName().length() > 0);

      }catch (Exception e) {
          // error occurred ; Do something here
          System.err.println("Error Occurred when testing Game Name. " +
                  "Type of Error :" + e.getLocalizedMessage());
          e.printStackTrace();
      }

      game.setAttempts(4);
      assert (game.getAttempts() == 4);

      game.setGameId(101);
      assert(game.getGameId()==101);

      game.setGameStatus("Won!");
      assert(game.getGameStatus().equals("Won!"));

      game.setActive(true);
      assert(game.isActive()==true);

      game.getGuesses().add(500);
      assert(game.getGuesses().get(0)==500);
      assert(game.getGuesses().size()==1);

    }

}
