package com.cloverdcs.stp.game.entity;
import java.util.*;
public class Player {
        private String name;
        private String email;
        private ArrayList<Game> list = new ArrayList<Game>();


        public void setName(String x){
            this.name = x;
        }
        public String getName(){
            return this.name;
        }
        public void setEmail(String x){
            this.email = x;
        }
        public String getEmail(){
            return this.email;
        }
        public ArrayList<Game> getList(){
            return this.list;
        }
        public void setList(ArrayList<Game> x){
            this.list = x;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(email, player.email) &&
                Objects.equals(list, player.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, list);
    }
}
