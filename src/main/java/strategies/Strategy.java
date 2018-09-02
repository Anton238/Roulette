package strategies;

import bets.Bet;
import bets.RandomBetGenerator;
import players.Player;


public abstract class Strategy {
    int baseBet;

    public abstract Bet nextBet(Player p);

    public abstract Bet getNextBetType();

    public abstract int nextBetSum(Player p);

    public Strategy(int baseBet) {
        this.baseBet = baseBet;
    }

    Bet getNextBetTypeDef() {
        String[] betType = {"COLUMN", "CORNER", "EVENODD", "FIVE", "LINE", "LOWHIGH", "REDBLACK", "SPLIT",
                "STRAIGHT", "STREET", "TWELVE"};

        int betTypeIndex = (int) (Math.random() * betType.length);
        RandomBetGenerator generator = new RandomBetGenerator();

        switch (betType[betTypeIndex]) {
            case "COLUMN":
                return generator.generateRandomColumnBet(baseBet);
            case "CORNER":
                return generator.generateRandomCornerBet(baseBet);
            case "EVENODD":
                return generator.generateRandomEvenOdd(baseBet);
            case "FIVE":
                return generator.generateRandomFiveBet(baseBet);
            case "LINE":
                return generator.generateRandomLineBet(baseBet);
            case "LOWHIGH":
                return generator.generateRandomLowHighBet(baseBet);
            case "REDBLACK":
                return generator.generateRandomRedBlackBet(baseBet);
            case "SPLIT":
                return generator.generateRandomSplitBet(baseBet);
            case "STRAIGHT":
                return generator.generateRandomStraightBet(baseBet);
            case "STREET":
                return generator.generateRandomStreetBet(baseBet);
            case "TWELVE":
                return generator.generateRandomTwelveBet(baseBet);
        }
        return null;
    }

    public int getBaseBet() {
        return baseBet;
    }

}
