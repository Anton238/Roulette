package bets;

import field.Cell;
import field.Table;


public class ColumnBet extends Bet {
    int column;

    public ColumnBet(int sum, int column){
        super.sum = sum;
        this.column = column;
        odd = 2;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "ColumnBet{" +
                "column = " + column +
                " sum = " + sum +
                '}';
    }

    @Override
    public boolean isWin(Cell winCell) {
        int columnBet = getColumn();
        int columnWin = Table.getColumnForm(winCell.getNumber());
        return columnBet == columnWin;
    }
}
