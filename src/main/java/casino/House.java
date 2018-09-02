package casino;

import game.Game;
import game.RouletteGame;

import java.util.LinkedList;
import java.util.List;

public class House {
    int maxBet;
    int minBet;
    private int houseMoney;
    List<Game> games;

    public House(int minBet, int maxBet) {
        games = new LinkedList<>();
        this.maxBet = maxBet;
        this.minBet = minBet;
    }

    public int getMaxBet() {
        return maxBet;
    }

    public int getMinBet() {
        return minBet;
    }

    public int getHouseMoney() {
        return houseMoney;
    }

    public void addHouseMoney(int add) {
        this.houseMoney += add;
    }

    public void addToGames(RouletteGame game) {
        games.add(game);
    }
}
