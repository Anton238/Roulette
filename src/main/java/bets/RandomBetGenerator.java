package bets;

import field.Cell;
import field.Table;

import java.util.ArrayList;
import java.util.List;


public class RandomBetGenerator {
    public ColumnBet generateRandomColumnBet(int sum){
        int col = (int)(Math.random() * 3);
        return new ColumnBet(sum, col);
    }

    public CornerBet generateRandomCornerBet(int sum){
        int x = (int)(Math.random() * 11);
        int y = (int)(Math.random() * 11);
        int result = (int) (Math.random() * 2 + 1) == 1 ? 5 + x * 3 : 6 + y * 3;
        return new CornerBet(sum, result);
    }

    public EvenOddBet generateRandomEvenOdd(int sum){
        int col = (int)(1 + Math.random() * 2);
        return new EvenOddBet(sum, col);
    }

    public FiveBet generateRandomFiveBet(int sum){
        return new FiveBet(sum);
    }

    public LineBet generateRandomLineBet(int sum){
        int lowRow = (int)(2 + Math.random() * 12);
        return new LineBet(sum, lowRow);
    }

    public LowHighBet generateRandomLowHighBet(int sum){
        int lowHigh = (int)(1 + Math.random() * 2);
        return new LowHighBet(sum, lowHigh);
    }

    public RedBlackBet generateRandomRedBlackBet(int sum){
        int redBlack = (int)(1 + Math.random() * 2);
        return new RedBlackBet(sum, redBlack);
    }

    public StraightBet generateRandomStraightBet(int sum){
        int i = (int)(1 + Math.random() * 36);
        return new StraightBet(sum, i);
    }

    public StreetBet generateRandomStreetBet(int sum){
        int i = (int)(1 + Math.random() * 11);
        return new StreetBet(sum, i);
    }

    public TwelveBet generateRandomTwelveBet(int sum){
        int i = (int)(1 + Math.random() * 3);
        return new TwelveBet(sum, i);
    }

    private List<Cell> getPossibleCellForSplit(int row, int collumn){
        List<Cell> possibleCells = new ArrayList<>();
        if(row > 1) possibleCells.add(Table.getCell(row - 1, collumn ));
        if(row < 12) possibleCells.add(Table.getCell(row + 1, collumn ));
        if(collumn >= 1) possibleCells.add(Table.getCell(row,collumn -1));
        if(collumn < 2) possibleCells.add(Table.getCell(row,collumn + 1));
        return possibleCells;
    }

    public SplitBet generateRandomSplitBet(int sum){
        int number1 = (int)(1 + Math.random() * 36);
        int row = Table.getRowForm(number1);
        int column = Table.getColumnForm(number1);
        List<Cell> possibleCells = getPossibleCellForSplit(row, column);
        int number2Index = (int)(Math.random() * possibleCells.size());
        Cell c = possibleCells.get(number2Index);
        int number2 = c.getNumber();
        return new SplitBet(sum, number1, number2);
    }

}
