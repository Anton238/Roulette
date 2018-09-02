package bets;

import field.Cell;
import field.Table;

public class CornerBet extends Bet {

    int rightLowCornerNumber;

    public CornerBet(int sum, int rightLowCornerNumber){
        super.sum = sum;
        this.rightLowCornerNumber = rightLowCornerNumber;
        odd = 8;
    }

    public int getRightLowCornerNumber() {
        return rightLowCornerNumber;
    }

    @Override
    public String toString() {
        return "CornerBet{" +
                "rightLowCornerNumber = " + rightLowCornerNumber +
                " sum = " + sum +
                '}';
    }

    @Override
    public boolean isWin(Cell winCell) {
        int betRightLowCorner = getRightLowCornerNumber();
        int result = winCell.getNumber();
        if (result == betRightLowCorner)
            return true;

        int resultRow = Table.getRowForm(result);
        int resultColumn = Table.getColumnForm(result);
        int betRow = Table.getRowForm(betRightLowCorner);
        int betColumn = Table.getColumnForm(betRightLowCorner);

        if (resultRow == betRow - 1 && resultColumn == betColumn - 1)
            return true;
        if (resultRow == betRow - 1 && resultColumn == betColumn)
            return true;
        if (resultRow == betRow && resultColumn == betColumn - 1)
            return true;

        return false;
    }
}
