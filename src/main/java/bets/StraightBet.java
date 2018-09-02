package bets;


import field.Cell;

public class StraightBet extends Bet {
    int number;

    public StraightBet(int sum, int number) {
        super.sum = sum;
        this.number = number;
        odd = 35;
    }

    public int getNumber(){
        return number;
    }

    @Override
    public String toString() {
        return "StraightBet{" +
                "number=" + number +
                " sum = " + sum +
                '}';
    }

    @Override
    public boolean isWin(Cell winCell) {
        return getNumber() == winCell.getNumber();
    }
}
