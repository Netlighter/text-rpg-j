package com.netlighter;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;

public class Event {
    static Random r = new Random();
    static int eventsCount = 3;

    static void spawnEvent(GameController gm, Char ch) {
        switch (r.nextInt(eventsCount - 1)) {
            case 0:
                doNothing();
            case 1:
                findEnemy(gm, ch);
            case 2:
                findTreasure(ch);

        }
    }
// TODO MAKE 'EM INHER ACTOR OR ANY OPTIMIZE
    static void loot(Char ch, Actor.Treasure tr){
        ch.experience += tr.loot_experience;
        ch.money += tr.loot_money;
        System.out.println(
                tr.loot_experience + " exp gained!\n" +
                        tr.loot_experience + " money gained!\n");
    }

    static void loot(Char ch, Actor.Enemy en){
        ch.experience +=en.loot_experience;
        ch.money += en.loot_money;
        System.out.println(
                en.loot_experience + " exp gained!\n" +
                        en.loot_experience + " money gained!\n");
    }


    static void findTreasure(Char ch) {
        Actor.Treasure tr = new Actor.Treasure(ch.level);
        System.out.println("Nice! You found treasure!\n");
        loot(ch, tr);

    }

    static void doNothing() {

        System.out.println("Nothing happens...\n");
    }

    static void findEnemy(GameController gm, Char ch) {
        String dec;
        Actor.Enemy en = new Actor.Enemy(ch.level);

        System.out.println("You found enemy!!!");

        while (en.health > 0 && ch.health > 0) {
            dec = gm.makeDecision("What?", "Attack!!!", "Defend!!!");

            if (dec == "Attack!!!"){
                en = ch.makeDamage(en);
                en.attack(ch);
            }
            else if (dec == "Defend!!!") ch.health -= 1;

            System.out.println(ch.health + " health\n" + en.health + " enemy health\n");
        }
        if (ch.health <= 0) death(gm, ch);
        if (en.health <=0) loot(ch, en);

    }

    static void death(GameController gm, Char ch){
        String dec;
        dec = gm.makeDecision("YOU DIED",
                "Use Health Potion!(Infinity)", "Rest in peace..."); // TODO ADD HEALTH POTION PLEASE
        if (dec == "Use Health Potion!(Infinity)") {
            ch.health = 100;
        } // TODO SAME
        else if (dec == "Rest in peace..."){
            System.out.println("Well...");
            ch.checkParams();
            gm.gameEnd();
        }
    }
}
