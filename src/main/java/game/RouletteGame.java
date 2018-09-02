package game;

import bets.Bet;
import casino.Bank;
import casino.House;
import casino.Wheel;
import field.Cell;
import field.Table;
import players.Player;
import statistics.Statistics;
import statistics.StatisticsEntry;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RouletteGame extends Game {
    public List<Player> players;
    private Wheel wheel;
    private Bank bank;

    public RouletteGame() {
        Table.populateTable();
        this.players = new LinkedList<>();
        this.wheel = new Wheel();
        this.bank = new Bank();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    @Override
    public void start(House house) {
        while (players.size() > 0) {
            int currSize;

            for (int i = 0; i < players.size() && players.size() != 0; i++) {
                currSize = players.size();
                Player p = players.get(i);
                collectBet(p, house.getMinBet(), house.getMaxBet());
                if (currSize != players.size())
                    i--;
            }

            for (Map.Entry<Player, Bet> entry : bank.getPlayerBetMap().entrySet()) {
                System.out.println("Bank has:");
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

            if (players.size() == 0) {
                bank.dealWithHouse(house);
                System.out.println("Game over");
                break;
            }

            Cell wheelResult = wheel.spinWheel();
            System.out.println("\nWheel result: " + wheelResult);
            bank.checkWin(wheelResult);
            bank.dealWithHouse(house);
            bank.clearBankBets();
            System.out.println("\nPlayers after cycle:");

            for (Player p : players)
                System.out.println(p);

            System.out.println("\nFull Statistics: ");

            for (StatisticsEntry entry : Statistics.getStatistics())
                System.out.println(entry.toString());

            System.out.println("  MONEY IN HOUSE = " + house.getHouseMoney());
        }
    }

    private void collectBet(Player p, int minBet, int maxBet) {
        Bet bet = p.getNextBet(minBet, maxBet, this);

        if (bet == null)
            return;

        bank.addPlayerBet(p, bet);
        bank.addBankMoney(bet.getSum());
        p.transferMoney(bet.getSum());
    }

    public void removePlayer(Player p) {
        players.remove(p);
    }

}
