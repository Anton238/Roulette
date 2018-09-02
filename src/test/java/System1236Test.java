import org.junit.Test;
import bets.Bet;
import field.Cell;
import field.Color;
import game.GameManager;
import game.RouletteGame;
import players.Player;
import players.RobotPlayer;
import statistics.Statistics;
import statistics.StatisticsEntry;
import strategies.System1326;

import java.util.HashSet;

// integration test for robot player with system 1236 strategy
public class System1236Test {
    public static void main(String[] args) {
        Player p = new RobotPlayer(100, 5);
        ((RobotPlayer) p).setStrategy(new System1326(5));
        System.out.println(p);
        GameManager manager = new GameManager();
        manager.rouletteGame.getPlayers().add(p);
        manager.rouletteGame.start(manager.house);

    }

    @Test
    public void test1() {
        Player p = new RobotPlayer(100, 5);
        ((RobotPlayer) p).setStrategy(new System1326(5));
        HashSet<Player> players = new HashSet<>();
        RouletteGame r = new RouletteGame();
        Bet b1 = p.getNextBet(5, 1000, r);
        System.out.println(b1.getSum() + " 0 ");
        for (int i = 0; i < 2; i++) {
            Cell c1 = new Cell(1, Color.Red);
            players.add(p);
            Statistics.addStatisticEntry(new StatisticsEntry(c1, players));
            System.out.println();
        }
        System.out.println(p.getNextBet(5, 1000, r) + " 1 ");

        for (int i = 0; i <= 2; i++) {
            Cell c1 = new Cell(1, Color.Red);
            players.add(p);
            Statistics.addStatisticEntry(new StatisticsEntry(c1, players));
            System.out.println();
        }
        System.out.println(p.getNextBet(5, 1000, r) + " 2 ");

        for (int i = 0; i <= 3; i++) {
            Cell c1 = new Cell(1, Color.Red);
            players.add(p);
            Statistics.addStatisticEntry(new StatisticsEntry(c1, players));
            System.out.println();
        }
        System.out.println(p.getNextBet(5, 1000, r) + " 3 ");


        for (int i = 0; i <= 4; i++) {
            Cell c1 = new Cell(1, Color.Red);
            players.add(p);
            Statistics.addStatisticEntry(new StatisticsEntry(c1, players));
            System.out.println();
        }
        System.out.println(p.getNextBet(5, 1000, r) + " 4 ");
    }
}