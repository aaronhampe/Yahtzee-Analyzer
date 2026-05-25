package analyzer;

import model.Dice;
import model.DiceRoll;

public class PatternAnalyzer {

    public Pattern evaluateThrow(int[] diceValues) {
        int[] histogram = getFrequencies(diceValues);
        if (hasYahtzee(histogram)) {
            return Pattern.YAHTZEE;
        }
        if (hasFourOfAKind(histogram)) {
            return Pattern.FOUROFAKIND;
        }
        if (hasThreeOfAKind(histogram)) {
            return Pattern.THREEOFAKIND;
        }
        return Pattern.CHANCE;
    }

    /**
     * This method returns the amount of values the dices
     * had in one roll per value.
     * 
     * Example: [1, 0, 2, 0, 2, 0] means:
     * 1x1, 0x2, 2x3, 0x4, 2x5, 0x6
     * 
     * @params Dice Values
     */
    public int[] getFrequencies(int[] diceValues) {
        int[] result = new int[7];
        for (int i = 0; i < diceValues.length; i++) {
            result[diceValues[i]]++;
        }
        return result;
    }

    // PAIR
    private boolean hasPair(int[] frequencies) {
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] >= 2) {
                return true;
            }
        }
        return false;
    }

    // THREEOFAKIND
    private boolean hasThreeOfAKind(int[] frequencies) {
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] >= 3) {
                return true;
            }
        }
        return false;
    }

    // YAHTZEE
    private boolean hasYahtzee(int[] frequencies) {
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] == 5) {
                return true;
            }
        }
        return false;
    }

    // FOUROFAKIND
    private boolean hasFourOfAKind(int[] frequencies) {
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] >= 4) {
                return true;
            }
        }
        return false;
    }

    // FULLHOUSE
    private boolean hasFullHouse(int[] frequencies) {
        boolean threeofakind = false;
        boolean pair = false;
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] == 3) {
                threeofakind = true;
            }
            if (frequencies[i] == 2) {
                pair = true;
            }
        }
        return pair && threeofakind;
    }

}
