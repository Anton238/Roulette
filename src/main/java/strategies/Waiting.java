package strategies;

import bets.Bet;
import bets.EvenOddBet;
import bets.RedBlackBet;
import field.Cell;
import field.Color;
import players.Player;
import statistics.Statistics;
import statistics.StatisticsEntry;

import java.util.LinkedList;


public class Waiting extends Strategy {
    final int WINDOW = 7;

    public Waiting(int baseBet) {
        super(baseBet);
    }

    @Override
    public Bet nextBet(Player p) {
        Bet nextBet = getNextBetType();
        if (nextBet != null)
            nextBet.setSum(nextBetSum(p));
        return nextBet;
    }

    @Override
    public Bet getNextBetType() {
        if (Statistics.getStatistics().size() < WINDOW)
            return null;
        if (is7Color(Color.Black)) return new RedBlackBet(baseBet, 1);
        if (is7Color(Color.Red)) return new RedBlackBet(baseBet, 2);
        if (is7Odd()) return new EvenOddBet(baseBet, 1);
        if (is7Even()) return new EvenOddBet(baseBet, 2);
        return null; //wait, no bet
    }


    @Override
    public int nextBetSum(Player p) {
        return baseBet;
    }

    private boolean is7Color(Color color) {
        LinkedList<StatisticsEntry> statistics = Statistics.getStatistics();
        for (int i = statistics.size() - 1; i >= statistics.size() - WINDOW; i--) {
            Cell c = statistics.get(i).getWinCell();
            if (!c.getColor().equals(color))
                return false;
        }
        return true;
    }

    private boolean is7Even() {
        LinkedList<StatisticsEntry> statistics = Statistics.getStatistics();
        for (int i = statistics.size() - 1; i >= statistics.size() - WINDOW; i--) {
            Cell c = statistics.get(i).getWinCell();
            if (c.getNumber() == 0)
                return false;
            if (c.getNumber() % 2 != 0)
                return false;
        }
        return true;
    }

    private boolean is7Odd() {
        LinkedList<StatisticsEntry> statistics = Statistics.getStatistics();
        for (int i = statistics.size() - 1; i >= statistics.size() - WINDOW; i--) {
            Cell c = statistics.get(i).getWinCell();
            if (c.getNumber() % 2 == 0)
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Waiting{" +
                '}';
    }
}
