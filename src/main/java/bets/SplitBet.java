package bets;

import field.Cell;


public class SplitBet extends Bet{

    int number1;
    int number2;

    public SplitBet(int sum, int number1, int number2){
        super.sum = sum;
        this.number1 = number1;
        this.number2 = number2;
        odd = 17;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    @Override
    public String toString() {
        return "SplitBet{" +
                "number1=" + number1 +
                ", number2=" + number2 +
                " sum = " + sum +
                '}';
    }

    @Override
    public boolean isWin(Cell winCell) {
        return winCell.getNumber() == getNumber1() || winCell.getNumber() == getNumber2();
    }
}
