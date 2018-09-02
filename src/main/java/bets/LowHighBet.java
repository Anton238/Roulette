package bets;

import field.Cell;


public class LowHighBet extends Bet {

    int lowHigh; // 1: 1-18; 2: 19-36

    public LowHighBet(int sum, int lowHigh) {
        super.sum = sum;
        this.lowHigh = lowHigh;
        odd = 1;
    }

    public int getLowHigh() {
        return lowHigh;
    }

    @Override
    public String toString() {
        return "LowHighBet{" +
                "lowHigh = " + lowHigh +
                " sum = " + sum +
                '}';
    }

    @Override
    public boolean isWin(Cell winCell) {
        int lowHighBet = getLowHigh();
        int result = winCell.getNumber();
        if ((result >= 1 && result <= 18) && lowHighBet == 1) return true;
        if ((result >= 19 && result <= 36) && lowHighBet == 2) return true;
        else return false;
    }
}
