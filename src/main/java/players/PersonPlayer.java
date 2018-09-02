package players;

import bets.Bet;
import bets.PersonBetGenerator;
import game.RouletteGame;


public class PersonPlayer extends Player {

    public PersonPlayer(int initialMoney) {
        this.name = "person" + PlayerNameGenerator.generateName();
        this.playerMoney = initialMoney;
    }

    @Override
    public Bet getNextBet(int minBet, int maxBet, RouletteGame game) {
        if (playerMoney < minBet) {
            System.out.println("PLAYER " + this + "HAVE NOT ENOUGH MONEY");
            game.removePlayer(this);
            return null;
        }
        PersonBetGenerator personBetGenerator = new PersonBetGenerator();
        return personBetGenerator.createBet(minBet, maxBet, this);
    }

    @Override
    public String toString() {
        return "PersonPlayer{" +
                "name = '" + name + '\'' +
                ", playerMoney = " + playerMoney +
                '}';
    }
}

