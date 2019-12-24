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

    static void findTreasure(Char ch) {
        double expGain = r.nextInt(100);
        int moneyGain = r.nextInt(10);
        ch.experience += expGain;
        ch.money += moneyGain;
        System.out.println(
                "Nice! You found treasure!\n" +
                        expGain + " exp gained!\n" +
                        moneyGain + " money gained!\n"
        );
    }

    static void doNothing() {

        System.out.println("Nothing happens...\n");
    }

    static void findEnemy(GameController gm, Char ch) {
        Actor.Enemy en = new Actor.Enemy(ch.level);
        System.out.println("You found enemy!!!");
        while (en.health > 0) {
            String dec = gm.makeDecision("What?", "Attack!!!", "Defend!!!");
            if (dec == "Attack!!!") {
                en = ch.makeDamage(en);
            }
            en.attack(ch);
            System.out.println(ch.health + " health\n" + en.health + " enemy health\n");
        }
    }
}
