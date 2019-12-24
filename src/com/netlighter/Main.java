package com.netlighter;

import javafx.scene.paint.Stop;

public class Main {
    public static void main(String[] args) {
        GameController gm = new GameController();
        Char ch = gm.gameStart();
        if(ch==null){
            gm.isStop = true;
        }

        while(!gm.gameEnd()){
            ch.checkParams();
            Event.spawnEvent(gm, ch);


        }
    }
}
