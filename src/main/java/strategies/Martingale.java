package strategies;

import bets.Bet;
import players.Player;
import statistics.Statistics;


public class Martingale extends Strategy {
    public Martingale(int baseBet) {
        super(baseBet);
        currentBet = baseBet;
        minBet = baseBet;
    }

    int currentBet;
    int minBet;

    @Override
    public Bet nextBet(Player p) {
        Bet nextBet = getNextBetType();
        nextBet.setSum(nextBetSum(p));
        return nextBet;
    }

    public int nextBetSum(Player p) {
        if (Statistics.getStatistics().size() <= 0)
            return minBet;
        else {
            if (!Statistics.isLastWin(p))
                currentBet = currentBet * 2;
            else
                currentBet = minBet;
        }
        return currentBet;
    }

    public Bet getNextBetType() {
        //get random Bet!!
        return super.getNextBetTypeDef();
    }

    @Override
    public String toString() {
        return "Martingale{" +
                '}';
    }
}
