package bets;

import field.Cell;
import field.Table;


public class LineBet extends Bet {

    int downRow;

    public LineBet(int sum, int downRow){
        super.sum = sum;
        this.downRow = downRow;
        odd = 5;
    }

    public int getDownRow() {
        return downRow;
    }

    @Override
    public String toString() {
        return "LineBet{" +
                "downRow = " + downRow +
                " sum = " + sum +
                '}';
    }

    @Override
    public boolean isWin(Cell winCell) {
        int lowRow = getDownRow();
        int resultRow = Table.getRowForm(winCell.getNumber());
        return resultRow == lowRow || resultRow == lowRow - 1;
    }
}
