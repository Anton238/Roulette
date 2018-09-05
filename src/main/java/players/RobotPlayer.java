package players;

import bets.Bet;
import game.RouletteGame;
import strategies.*;

import java.util.Random;

public class RobotPlayer extends Player {
    private Strategy strategy;

    public RobotPlayer(int initialMoney, int baseBet) {
        this.name = PlayerNameGenerator.generateName();
        this.playerMoney = initialMoney;
        this.strategy = getRandomStrategy(baseBet);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Bet getNextBet(int minBet, int maxBet, RouletteGame game) {
        if (playerMoney < minBet) {
            System.out.println(" PLAYER " + this + " HAVE NOT ENOUGH MONEY");
            game.removePlayer(this);
            return null;
        }

        Bet bet = strategy.nextBet(this);

        if (bet == null)
            return bet;
        if (bet.getSum() < minBet || bet.getSum() > maxBet) {
            resetStrategy();
            bet = getNextBet(minBet, maxBet, game);
        }
        if (bet.getSum() > playerMoney) {
            resetStrategy();
            bet = getNextBet(minBet, maxBet, game);
        }

        return bet;
    }

    public Strategy getRandomStrategy(int baseBet) {
        int index = new Random().nextInt(StrategyType.values().length);
        StrategyType strategyType = StrategyType.values()[index];
        switch (strategyType) {
            case WAITING:
                return new Waiting(baseBet);
            case MARTINGALE:
                return new Martingale(baseBet);
            case SYSTEM1326:
                return new System1326(baseBet);
            case CANCELLATION:
                return new Cansellation(baseBet);
        }
        return null;
    }

    private void resetStrategy() {
        setStrategy(getRandomStrategy(strategy.getBaseBet()));
    }

    @Override
    public String toString() {
        return "RobotPlayer{" +
                "name = '" + name + '\'' +
                ", playerMoney = " + playerMoney +
                ", strategy = " + strategy.toString() +
                '}';
    }
}
