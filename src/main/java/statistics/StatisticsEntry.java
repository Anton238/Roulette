package statistics;

import field.Cell;
import players.Player;

import java.util.HashSet;

public class StatisticsEntry {
    Cell winCell;

    private HashSet<Player> winPlayers;

    public StatisticsEntry(Cell winCell, HashSet<Player> players) {
        this.winCell = winCell;
        this.winPlayers = players;
    }

    public HashSet<Player> getWinPlayers() {
        return winPlayers;
    }

    public boolean isWinner(Player p) {
        return winPlayers.contains(p);
    }

    public Cell getWinCell() {
        return winCell;
    }

    @Override
    public String toString() {
        return "StatisticsEntry{" +
                "winCell = " + winCell.toString() +
                ", winPlayers = " + winPlayers.toString() +
                '}';
    }
}
