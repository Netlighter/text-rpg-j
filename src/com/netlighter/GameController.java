package com.netlighter;

import java.util.Scanner;

public class GameController {
    Scanner sc = new Scanner(System.in);

    static boolean isStop = false;
    public Char gameStart() {
        System.out.println("Type in your name: ");
        Char ch = new Char(sc.nextLine());
        if(makeDecision("Start the game?", "yes", "no")=="yes") { return ch; };
        return null;
    }

    public boolean gameEnd() {
        if(isStop){
            System.out.println("Goodbye");
            return true;
        }
        return false;
    }

    String makeDecision(String question, String... answers) {
        System.out.println(question);
        int i;
        for (i = 0; i < answers.length; i++) {
            System.out.println(i + ". " + answers[i]);
        }
        return answers[sc.nextInt()];
    }
}
