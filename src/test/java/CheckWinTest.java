import org.junit.Assert;
import org.junit.Test;
import bets.*;
import field.Cell;
import field.Color;
import field.Table;

public class CheckWinTest {
    
    @Test
    public void ColumnTest() {
        Table.populateTable();
        ColumnBet b = new ColumnBet(5, 1);
        System.out.println(b.toString());
        Cell result = new Cell(1, Color.Black);
        Cell result2 = new Cell(2, Color.Black);
        Cell result3 = new Cell(3, Color.Black);
        Assert.assertFalse(b.isWin(result));
        Assert.assertTrue(b.isWin(result2));
        Assert.assertFalse(b.isWin(result3));
    }

    @Test
    public void CornerTest() {
        Table.populateTable();
        CornerBet b = new CornerBet(3, 6);
        System.out.println(b.toString());
        Cell result = new Cell(5, Color.Black);
        Cell result2 = new Cell(6, Color.Black);
        Cell result3 = new Cell(11, Color.Black);
        Assert.assertTrue(b.isWin(result));
        Assert.assertTrue(b.isWin(result2));
        Assert.assertFalse(b.isWin(result3));
    }

    @Test
    public void EvenOddTest() {
        Table.populateTable();
        EvenOddBet b = new EvenOddBet(3, 1);
        System.out.println(b.toString());
        Assert.assertFalse(b.isWin(new Cell(1, Color.Black)));
        Assert.assertTrue(b.isWin(new Cell(2, Color.Black)));
        Assert.assertTrue(b.isWin(new Cell(10, Color.Black)));
    }

    @Test
    public void LineBetTest() {
        Table.populateTable();
        LineBet b = new LineBet(3, 2);
        System.out.println(b.toString());
        Assert.assertTrue(b.isWin(new Cell(1, Color.Black)));
        Assert.assertTrue(b.isWin(new Cell(3, Color.Black)));
        Assert.assertFalse(b.isWin(new Cell(10, Color.Black)));

    }

    @Test
    public void LowHighTest() {
        Table.populateTable();
        LowHighBet b = new LowHighBet(3, 1);
        System.out.println(b.toString());
        Assert.assertTrue(b.isWin(new Cell(1, Color.Black)));
        Assert.assertTrue(!b.isWin(new Cell(19, Color.Black)));
    }

    @Test
    public void SplitTest() {
        Table.populateTable();
        SplitBet b = new SplitBet(3, 2, 5);
        System.out.println(b.toString());
        Assert.assertTrue(b.isWin(new Cell(2, Color.Black)));
        Assert.assertTrue(!b.isWin(new Cell(10, Color.Black)));
        Assert.assertTrue(b.isWin(new Cell(5, Color.Black)));
    }

    @Test
    public void StreetTest() {
        Table.populateTable();
        StreetBet b = new StreetBet(3, 2);
        System.out.println(b.toString());
        Assert.assertTrue(b.isWin(new Cell(5, Color.Black)));
        Assert.assertFalse(b.isWin(new Cell(15, Color.Black)));
    }

    @Test
    public void isTwelveTest() {
        TwelveBet b = new TwelveBet(3, 3);
        System.out.println(b.toString());
        Assert.assertTrue(b.isWin(new Cell(36, Color.Black)));
        Assert.assertFalse(b.isWin(new Cell(1, Color.Black)));
        Assert.assertFalse(b.isWin(new Cell(18, Color.Black)));
    }
}
