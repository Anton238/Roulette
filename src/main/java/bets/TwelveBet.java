package bets;

import field.Cell;


public class TwelveBet extends Bet {

    int numberOfRange; // 1: 1-12, 2: 13- 24, 3: 25-36

    public TwelveBet(int sum, int numberOfRange){
        super.sum = sum;
        this.numberOfRange = numberOfRange;
        odd = 2;
    }

    public int getNumberOfRange() {
        return numberOfRange;
    }

    @Override
    public String toString() {
        return "TwelveBet{" +
                "numberOfRange=" + numberOfRange +
                " sum = " + sum +
                '}';
    }

    @Override
    public boolean isWin(Cell winCell) {
        int range = getNumberOfRange();
        int result = winCell.getNumber();
        if ((result >= 1 && result <= 12) && range == 1) return true;
        if ((result >= 13 && result <= 24) && range == 2) return true;
        if ((result >= 25 && result <= 36) && range == 3) return true;
        else return false;
    }
}

