package com.company;

import java.util.Random;

public class Snake extends Obstacle{
    public Snake() {
        super(4, "Yılan", damagePoint(), 12, 0);
    }

    private static int damagePoint(){
        Random dmg = new Random();
        return dmg.nextInt(4) + 3;
    }
}
