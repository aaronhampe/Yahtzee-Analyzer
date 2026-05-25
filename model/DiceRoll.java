package model;

public class DiceRoll {
    Dice[] fiveDices = new Dice[5];

    public DiceRoll() {
        for (int i = 0; i < 5; i++) {
            fiveDices[i] = new Dice();
        }
    }

    public void rollAll() {
        for (int i = 0; i < 5; i++) {
            fiveDices[i].roll();
        }
    }

    public int[] getResultValues() {
        int[] result = new int[5];
        for (int i = 0; i < 5; i++) {
            result[i] = fiveDices[i].getValue();
        }
        return result;
    }
}
