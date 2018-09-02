package bets;

import field.RowColumn;
import field.Table;

public class Validator {

    public static boolean columnBetCheck(ColumnBet columnBet) {
        return (columnBet.column == 0 || columnBet.column == 1 || columnBet.column == 2);
    }

    public static boolean cornerCheck(CornerBet cornerBet) {
        RowColumn rowColumn = Table.getRowColumnForm(cornerBet.rightLowCornerNumber);
        return rowColumn.getRow() >= 2 && rowColumn.getColumn() >= 1;
    }

    public static boolean evenOddCheck(EvenOddBet evenOddBet) {
        return evenOddBet.evenOdd == 1 || evenOddBet.evenOdd == 2;
    }

    public static boolean lineBetCheck(LineBet lineBet) {
        return lineBet.downRow >= 2;
    }

    public static boolean lowHighCheck(LowHighBet lowHighBet) {
        return lowHighBet.lowHigh == 1 || lowHighBet.lowHigh == 2;
    }

    public static boolean redBlackCheck(RedBlackBet redBlackBet) {
        return redBlackBet.redBlack == 1 || redBlackBet.redBlack == 2;
    }

    public static boolean splitBetCheck(SplitBet splitBet) {
        RowColumn rowColumn = Table.getRowColumn(splitBet.number1);
        int row = rowColumn.getRow();
        int column = rowColumn.getColumn();
        if (row - 1 > 0 && Table.getCell(row - 1, column).getNumber() == splitBet.number2) {
            return true;
        } else if (row < 12 && Table.getCell(row + 1, column).getNumber() == splitBet.number2) {
            return true;
        } else if (column >= 1 && Table.getCell(row, column - 1).getNumber() == splitBet.number2) {
            return true;
        } else if (column < 2 && Table.getCell(row, column + 1).getNumber() == splitBet.number2) {
            return true;
        }
        return false;
    }

    public static boolean StreetBet(StreetBet bet) {
        return bet.getRow() <= 12 && bet.getRow() > 0;
    }

    public static boolean TwelveBet(TwelveBet bet) {
        return bet.getNumberOfRange() == 1 || bet.getNumberOfRange() == 2 || bet.getNumberOfRange() == 3;
    }




}
