package statistics;

import players.Player;

import java.util.LinkedList;


public class Statistics {

    private static LinkedList<StatisticsEntry> statistics = new LinkedList<>();
    final static int CAPACITY = 7;

    public static void removeFirst() {
        statistics.removeFirst();
    }

    public static StatisticsEntry getLastWin() {
        return statistics.getLast();
    }

    public static LinkedList<StatisticsEntry> getStatistics() {
        return statistics;
    }

    public static boolean isLastWin(Player p) {
        return Statistics.getLastWin().isWinner(p);
    }

    public static void addStatisticEntry(StatisticsEntry entry) {
        if (entry != null)
            statistics.add(entry);
        if (statistics.size() > CAPACITY)
            removeFirst();
    }
}
