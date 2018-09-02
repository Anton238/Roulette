package bets;

import field.Cell;

import java.util.ArrayList;
import java.util.Arrays;


public class FiveBet extends Bet {

    public FiveBet(int sum) {
        super.sum = sum;
        odd = 6;
    }

    @Override
    public String toString() {
        return "FiveBet{" +
                "sum = " + sum +
                '}';
    }

    @Override
    public boolean isWin(Cell winCell) {
        return new ArrayList<>(Arrays.asList(0, 1, 2, 3, 37))
                .contains(winCell.getNumber());
    }
}
