package bets;

import field.Cell;

public abstract class Bet {
    int sum;
    int odd; //1:x

    public abstract boolean isWin(Cell winCell);
    public void setSum(int sum) {
        this.sum = sum;
    }
    public int getSum(){ return sum; }
    public int getOdd(){
        return odd;
    }

}
