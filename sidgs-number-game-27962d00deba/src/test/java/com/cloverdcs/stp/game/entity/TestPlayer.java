package com.cloverdcs.stp.game.entity;

import org.junit.Test;

// JUnit testing for Player class

public class TestPlayer{
    @Test
        public void testAlwaysPasses(){
            assert(true);
        }
    @Test
        public void testPlayerGettersAndSetters(){
            Player player1 = new Player();

            player1.setName("ali");
            assert(player1.getName().equals("ali"));

            player1.setEmail("alialkhateeb97@gmail.com");
            assert(player1.getEmail().equals("alialkhateeb97@gmail.com"));

            Game g1 = new Game();
            player1.getList().add(g1);
            assert(player1.getList().size()==1);
        }
}
