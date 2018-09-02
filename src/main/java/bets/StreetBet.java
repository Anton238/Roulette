package bets;

import field.Cell;
import field.Table;


public class StreetBet extends Bet {
    int row;

    public StreetBet(int sum, int row) {
        super.sum = sum;
        this.row = row;
        odd = 11;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        return "StreetBet{" +
                "row=" + row +
                " sum = " + sum +
                '}';
    }

    @Override
    public boolean isWin(Cell winCell) {
        return getRow() == Table.getRowForm(winCell.getNumber());
    }
}
