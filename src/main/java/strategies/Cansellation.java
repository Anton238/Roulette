package strategies;

import bets.Bet;
import players.Player;
import statistics.Statistics;

import java.util.Arrays;
import java.util.LinkedList;


public class Cansellation extends Strategy {
    final LinkedList<Integer> baseNums;
    LinkedList<Integer> currentNums;

    public Cansellation(int baseBet) {
        super(baseBet);
        baseNums = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        this.currentNums = new LinkedList<>(baseNums);
    }

    @Override
    public Bet nextBet(Player p) {
        Bet nextBet = getNextBetType();
        nextBet.setSum(nextBetSum(p));
        return nextBet;
    }

    @Override
    public Bet getNextBetType() {
        // random type
        return super.getNextBetTypeDef();
    }

    @Override
    public int nextBetSum(Player p) {
        if (Statistics.getStatistics().size() > 0) {
            if (currentNums.size() < 2)
                currentNums = new LinkedList<>(baseNums);
            if (Statistics.isLastWin(p)) {
                currentNums.removeFirst();
                currentNums.removeLast();
            } else
                currentNums.add(currentNums.getFirst() + currentNums.getLast());
        }
        return currentNums.getFirst() + currentNums.getLast();
    }

    @Override
    public String toString() {
        return "Cansellation{" +
                '}';
    }
}
