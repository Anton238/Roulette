import bets.*;
import field.Table;
import org.junit.Assert;
import org.junit.Test;
import strategies.Cancellation;
import strategies.Strategy;


public class BetGeneratorTest {

    @Test
    public void testSplit() {
        Table.populateTable();
        RandomBetGenerator generator = new RandomBetGenerator();
        Bet bet = generator.generateRandomSplitBet(50);
        System.out.println(bet.toString());
        Assert.assertTrue(Validator.splitBetCheck((SplitBet) bet));
    }

    @Test
    public void testStraight() {
        Table.populateTable();
        RandomBetGenerator generator = new RandomBetGenerator();
        Bet bet = generator.generateRandomStraightBet(50);
        System.out.println(bet.toString());
        Assert.assertTrue(bet instanceof StraightBet);
    }

    @Test
    public void testCancellationNextBetType() {
        Table.populateTable();
        Strategy s = new Cancellation(20);
        Bet bet = s.getNextBetType();
        System.out.println(bet);
    }


    @Test
    public void cornerValidatorForPerson() {
        PersonBetGenerator p = new PersonBetGenerator();
        Assert.assertFalse(p.isValidCorner(4));
        Assert.assertTrue(p.isValidCorner(5));
        Assert.assertTrue(p.isValidCorner(6));
        Assert.assertTrue(p.isValidCorner(36));
        Assert.assertFalse(p.isValidCorner(10));
        Assert.assertTrue(p.isValidCorner(12));
    }

    @Test
    public void testColumnBet() {
        Table.populateTable();
        RandomBetGenerator generator = new RandomBetGenerator();
        Bet bet = generator.generateRandomColumnBet(50);
        Assert.assertTrue(Validator.columnBetCheck((ColumnBet) bet));
    }

    @Test
    public void testCornerBet() {
        Table.populateTable();
        RandomBetGenerator generator = new RandomBetGenerator();
        Bet bet = generator.generateRandomCornerBet(50);
        Assert.assertTrue(Validator.cornerCheck((CornerBet) bet));
    }


    @Test
    public void testEvenOddBet() {
        Table.populateTable();
        RandomBetGenerator generator = new RandomBetGenerator();
        Bet bet = generator.generateRandomEvenOdd(50);
        Assert.assertTrue(Validator.evenOddCheck((EvenOddBet) bet));
    }

    @Test
    public void testLineBetCheck() {
        Table.populateTable();
        RandomBetGenerator generator = new RandomBetGenerator();
        Bet bet = generator.generateRandomLineBet(50);
        Assert.assertTrue(Validator.lineBetCheck((LineBet) bet));
    }

    @Test
    public void testLowHighBetCheck() {
        Table.populateTable();
        RandomBetGenerator generator = new RandomBetGenerator();
        Bet bet = generator.generateRandomLowHighBet(50);
        Assert.assertTrue(Validator.lowHighCheck((LowHighBet) bet));
    }

    @Test
    public void testRedBlackBetCheck() {
        Table.populateTable();
        RandomBetGenerator generator = new RandomBetGenerator();
        Bet bet = generator.generateRandomRedBlackBet(50);
        Assert.assertTrue(Validator.redBlackCheck((RedBlackBet) bet));
    }

    @Test
    public void testStreetBetCheck() {
        Table.populateTable();
        RandomBetGenerator generator = new RandomBetGenerator();
        Bet bet = generator.generateRandomStreetBet(50);
        Assert.assertTrue(Validator.StreetBet((StreetBet) bet));
    }

    @Test
    public void testTwelveBetCheck() {
        Table.populateTable();
        RandomBetGenerator generator = new RandomBetGenerator();
        Bet bet = generator.generateRandomTwelveBet(50);
        Assert.assertTrue(Validator.TwelveBet(((TwelveBet) bet)));
    }
}
