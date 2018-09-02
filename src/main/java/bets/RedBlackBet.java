package bets;

import field.Cell;
import field.Color;


public class RedBlackBet extends Bet {
    int redBlack; // 1: red; 2: black

    public RedBlackBet(int sum, int redBlack){
        super.sum = sum;
        this.redBlack = redBlack;
        odd = 1;
    }

    public int getRedBlack() {
        return redBlack;
    }

    @Override
    public String toString() {
        return "RedBlackBet{" +
                "redBlack=" + redBlack +
                " sum = " + sum +
                '}';
    }

    @Override
    public boolean isWin(Cell winCell) {
        int redBlack = getRedBlack();
        if (redBlack == 1 && winCell.getColor() == Color.Red) return true;
        if (redBlack == 2 && winCell.getColor() == Color.Black) return true;
        else return false;
    }
}
