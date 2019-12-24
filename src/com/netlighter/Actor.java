package com.netlighter;

import java.util.Random;

public class Actor {
    static class Enemy{

        Random r = new Random();
        int health;
        int level;

        Enemy(int l){
            level = l+r.nextInt(3);
            health = 100*level;
        }
        Char attack(Char ch){
            if(ch.armor != 0) {
                ch.armor -= r.nextInt(10 * level);
            }
            else if(ch.armor == 0) {
                ch.health -= r.nextInt(10 * level);
            }
            return ch;
        }
    }
    interface Treasure{}

}
