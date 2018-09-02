package strategies;

import bets.Bet;
import players.Player;
import statistics.Statistics;


public class System1326 extends Strategy {
    final int[] multiplaers = new int[]{1, 3, 2, 6};
    int position;

    public System1326(int base) {
        super(base);
    }

    @Override
    public Bet nextBet(Player p) {
        Bet bet = getNextBetType();
        bet.setSum(nextBetSum(p));
        return bet;
    }

    @Override
    public Bet getNextBetType() {
        //return random
        return super.getNextBetTypeDef();
    }

    @Override
    public int nextBetSum(Player p) {
        if (Statistics.getStatistics().size() <= 0)
            return baseBet;
        if (Statistics.isLastWin(p)) {
            if (position >= multiplaers.length - 1)
                position = 0;
            else
                position++;
        } else
            position = 0;
        return multiplaers[position] * baseBet;
    }

    @Override
    public String toString() {
        return "System1326{" +
                '}';
    }
}
