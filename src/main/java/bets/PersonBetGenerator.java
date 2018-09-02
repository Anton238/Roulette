package bets;

import players.Player;

import java.util.Scanner;


public class PersonBetGenerator {
    Bet bet;

    public Bet createBet(int minBet, int maxBet, Player p) {
        int sum = getBetSum(p);

        while (sum < minBet || sum > maxBet) {
            System.out.println("Chose bet > min and < max ");
            sum = getBetSum(p);
        }
        while (sum > p.getPlayerMoney()) {
            System.out.println("Chose bet less then player money");
            sum = getBetSum(p);
        }

        return getPersonBet(sum, p);
    }

    public int getBetSum(Player p) {
        System.out.print("\nEnter bet sum for Person Player: " + p);
        return nextInt();
    }

    public Bet getPersonBet(int sum, Player p) {
        Bet bet = null;
        System.out.println(" 'Person Player' " + p + "\nChoose bet type: \n");
        System.out.println(
                "1:     COLUMN,\n" +
                        "2:     CORNER,\n" +
                        "3:     EVENODD,\n" +
                        "4:     FIVE,\n" +
                        "5:     LINE,\n" +
                        "6:     LOWHIGH,\n" +
                        "7:     REDBLACK,\n" +
                        "8:     SPLIT,\n" +
                        "9:     STRAIGHT,\n" +
                        "10:    STREET,\n" +
                        "11:    TWELVE");
        int index = nextInt();
        switch (index) {
            case 1:
                bet = generateNewColumnBet(sum);
                break;
            case 2:
                bet = generateNewCornerBet(sum);
                break;
            case 3:
                bet = generateNewEvenOdd(sum);
                break;
            case 4:
                bet = generateNewFiveBet(sum);
                break;
            case 5:
                bet = generateNewLineBet(sum);
                break;
            case 6:
                bet = generateNewLowHighBet(sum);
                break;
            case 7:
                bet = generateNewRedBlackBet(sum);
                break;
            case 8:
                bet = generateNewSplitBet(sum);
                break;
            case 9:
                bet = generateNewStraightBet(sum);
                break;
            case 10:
                bet = generateNewStreetBet(sum);
                break;
            case 11:
                bet = generateNewTwelveBet(sum);
                break;
        }
        return bet;
    }

    public ColumnBet generateNewColumnBet(int sum) {
        int col;
        System.out.print("Choose column number(0, 1, 2): ");
        col = nextInt();
        while (!(col == 0 || col == 1 || col == 2)) {
            System.out.print("Choose valid column number(0, 1, 2): ");
            col = nextInt();
        }
        return new ColumnBet(sum, col);
    }

    public CornerBet generateNewCornerBet(int sum) {
        System.out.print("Please enter low right corner: ");
        int result = nextInt();
        while (!isValidCorner(result)) {
            System.out.print("Please enter valid low right corner: ");
            result = nextInt();
        }
        return new CornerBet(sum, result);
    }

    public boolean isValidCorner(int result) {
        if (!(result >= 5 && result <= 36))
            return false;
        else if (!(((result - 5) % 3 == 0) || ((result - 6) % 3 == 0)))
            return false;

        return true;
    }

    public EvenOddBet generateNewEvenOdd(int sum) {
        System.out.print("Please choose even or odd - 1 or 2: ");
        int result = nextInt();
        while (!(result == 1 || result == 2)) {
            System.out.println("Please enter valid even or odd - 1 or 2: ");
            result = nextInt();
        }
        return new EvenOddBet(sum, result);
    }

    public FiveBet generateNewFiveBet(int sum) {
        return new FiveBet(sum);
    }

    public LineBet generateNewLineBet(int sum) {
        System.out.print("Enter number of row 2 - 12: ");
        int lowRow = nextInt();
        while (!(lowRow >= 2 && lowRow <= 12)) {
            System.out.print("Enter valid number of row 2 - 12: ");
            lowRow = nextInt();
        }
        return new LineBet(sum, lowRow);
    }

    public LowHighBet generateNewLowHighBet(int sum) {
        System.out.print("Please choose Low(1-18) or High(19-36): 1 or 2: ");
        int result = nextInt();
        while (!(result == 1 || result == 2)) {
            System.out.print("Please choose  valid Low(1-18) or High(19-36): 1 or 2: ");
            result = nextInt();
        }
        return new LowHighBet(sum, result);
    }

    public RedBlackBet generateNewRedBlackBet(int sum) {
        System.out.print("Please choose red or black: 1 or 2: ");
        int result = nextInt();
        while (!(result == 1 || result == 2)) {
            System.out.print("Please enter valid red or black 1 or 2: ");
            result = nextInt();
        }
        return new RedBlackBet(sum, result);
    }

    public StraightBet generateNewStraightBet(int sum) {
        System.out.print("Please choose number in range 1 - 36: ");
        int i = nextInt();
        while (!(i >= 1 && i <= 36)) {
            System.out.print("Please choose valid number in range 1 - 36: ");
            i = nextInt();
        }
        return new StraightBet(sum, i);
    }

    public StreetBet generateNewStreetBet(int sum) {
        System.out.print("Enter number of row 1 - 12: ");
        int i = nextInt();
        while (!(i >= 1 && i <= 12)) {
            System.out.print("Enter valid number of row 1 - 12: ");
            i = nextInt();
        }
        return new StreetBet(sum, i);
    }

    public TwelveBet generateNewTwelveBet(int sum) {
        System.out.print("Choose range of twelves number: 1(1-12), 2(13-24), 3(25-36): ");
        int i = nextInt();
        while (!(i == 1 || i == 2 || i == 3)) {
            System.out.print("Please enter correct value(1, 2 or 3): ");
            i = nextInt();
        }
        return new TwelveBet(sum, i);
    }


    public SplitBet generateNewSplitBet(int sum) {
        System.out.println("Please enter two numbers for split \n");
        System.out.println("Enter number 1:");
        int number1 = nextInt();
        System.out.println("Enter number 2:");
        int number2 = nextInt();
        SplitBet bet = new SplitBet(sum, number1, number2);
        while (!Validator.splitBetCheck(bet)) {
            System.out.println("Please enter two valid numbers for split \n");
            System.out.print("Enter number 1: ");
            number1 = nextInt();
            System.out.print("Enter number 2: ");
            number2 = nextInt();
            bet = new SplitBet(sum, number1, number2);
        }
        return bet;
    }

    private int nextInt() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (java.util.InputMismatchException inputEx) {
            System.out.println("You were taken out of the casino for improper conduct");
            System.exit(-1);
            return 0; // Without return compilation error
        }
    }

}
