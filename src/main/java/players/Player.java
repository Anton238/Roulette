package players;

import bets.Bet;
import game.RouletteGame;


public abstract class Player {
    String name;
    int playerMoney;

    public abstract Bet getNextBet(int min, int max, RouletteGame game);

    public void transferMoney(int substract) {
        playerMoney = playerMoney - substract;
    }

    public void addMoney(int add) {
        playerMoney = playerMoney + add;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }
}
