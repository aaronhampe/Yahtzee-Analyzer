package model;

import java.util.Random;

public class Dice {
    private int value;
    private Random random = new Random();

    public int getValue() {
        return this.value;
    }

    public void roll() {
        this.value = random.nextInt(1,7);
    }
}
