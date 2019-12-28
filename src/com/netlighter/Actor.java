package com.netlighter;

import java.util.Random;

public class Actor {

    static class Enemy{
        Random r = new Random();
        int health;
        int level;
        int loot_experience;
        int loot_money;

        Enemy(int l){
            level = l+r.nextInt(3)/2;
            health = 20*level;
            loot_experience = r.nextInt((health - health/2)+1) + health/2;
            loot_money = r.nextInt((level*10 - level*5)+1) + level*5;

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
    static class Treasure{
        Random r = new Random();
        int loot_experience;
        int loot_money;

        Treasure(int level){
            loot_experience = r.nextInt((level*70 - level*30)+1) + level*30;
            loot_money = r.nextInt((level*10 - level*5)+1) + level*5;
        }
    }

}
