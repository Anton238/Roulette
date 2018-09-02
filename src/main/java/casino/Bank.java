package casino;

import bets.Bet;
import field.Cell;
import players.Player;
import statistics.Statistics;
import statistics.StatisticsEntry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class Bank {
    private int totalAmount;
    private HashMap<Player, Bet> playerBetMap;

    public Bank() {
        this.playerBetMap = new HashMap<>();
    }

    public void addPlayerBet(Player p, Bet b) {
        playerBetMap.put(p, b);
    }

    public void addBankMoney(int add) {
        this.totalAmount += add;
    }

    public HashMap<Player, Bet> getPlayerBetMap() {
        return playerBetMap;
    }

    public void clearBankBets() {
        playerBetMap.clear();
    }

    public void checkWin(Cell winCell) {
        HashSet<Player> winners = new HashSet<>();
        for (Map.Entry<Player, Bet> entry : playerBetMap.entrySet()) {
            if (entry.getValue().isWin(winCell)) {
                System.out.println(entry.getKey() + " won = " + entry.getValue().getSum() * entry.getValue().getOdd());
                payWinners(entry.getKey(), entry.getValue());
                winners.add(entry.getKey());
            }
        }
        Statistics.addStatisticEntry(new StatisticsEntry(winCell, winners));
    }

    public void payWinners(Player player, Bet bet) {
        int sumToPayToWinner = (bet.getSum() * bet.getOdd());
        totalAmount -= sumToPayToWinner;
        player.addMoney(sumToPayToWinner);
    }

    public void dealWithHouse(House house) {
        System.out.println("Bank TotalAmount after round: " + totalAmount);
        house.addHouseMoney(totalAmount);
        totalAmount = 0;
    }
}
