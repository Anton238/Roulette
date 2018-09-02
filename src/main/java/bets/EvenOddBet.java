package bets;

import field.Cell;


public class EvenOddBet extends Bet{
    int evenOdd; // 1: even; 2: odd

    public EvenOddBet(int sum, int evenOdd){
        super.sum = sum;
        this.evenOdd = evenOdd;
        odd = 1;
    }

    public int getEvenOdd() {
        return evenOdd;
    }

    @Override
    public String toString() {
        return "EvenOddBet{" +
                "evenOdd = " + evenOdd +
                " sum = " + sum +
                '}';
    }

    @Override
    public boolean isWin(Cell winCell) {
        int betEvenOdd = getEvenOdd();
        if (winCell.getNumber() % 2 == 0 && betEvenOdd == 1) return true;
        if (winCell.getNumber() % 2 != 0 && betEvenOdd == 2) return true;
        else return false;
    }
}
