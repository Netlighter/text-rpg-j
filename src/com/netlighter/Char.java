package com.netlighter;

import java.util.Random;

public class Char {
    Random r = new Random();
    String name;
    double health;
    int level;
    int experience;
    int armor;
    int money;
    double force;

    public Char(String name){
        health = 100;
        armor = 0;
        force = 0.1;
        experience = 0;
        level = 1;
        money = 10;
        this.name = name;

        System.out.println("Welcome, "+name+"!");
    }
    public void checkParams(){
        if(health<=0){
            // gameend
        }
        if(experience >= level*level*1200){
            level +=1;
            health+=10;
            System.out.printf("LEVEL UP! %d now!", level);
        }
        System.out.println(
                "-----------------\n" +
                "health = "+health+";\n" +
                "armor = "+armor+";\n" +
                "level = "+level+";\n" +
                "money = "+money+";\n" +
                "-----------------\n");
    }

    private void makeIgnore() {
    }

    private void makeDefend() {
    }

    Actor.Enemy makeDamage(Actor.Enemy en) {
        en.health -= r.nextInt((int) (force*120));
        return en;
    }

}
