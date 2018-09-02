package game;

import casino.House;
import players.PersonPlayer;
import players.Player;
import players.RobotPlayer;

import java.util.Scanner;


public class GameManager {
    public House house;
    public RouletteGame rouletteGame;


    public GameManager() {
        this.house = new House(5, 1000);
        this.rouletteGame = new RouletteGame();
        house.addToGames(rouletteGame);
    }

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();//cause createPlayersForRouletteGame is non-static
        gameManager.createPlayersForRouletteGame();
        System.out.println(gameManager.rouletteGame.getPlayers());
        gameManager.rouletteGame.start(gameManager.house);
    }

    public void createPlayersForRouletteGame() {
        System.out.print("Enter number of person players: ");
        int personPlayers = nextInt();

        for (int i = 0; i < personPlayers; i++) {
            System.out.print("Enter initial amount of money for player" + (i + 1) + ": ");
            int initMoneyForPlayer = nextInt();
            Player p = new PersonPlayer(initMoneyForPlayer);
            rouletteGame.getPlayers().add(p);
        }

        System.out.print("Enter number of auto player: ");
        int auto = nextInt();

        if (auto > 0) {
            System.out.print("Enter initial amount of money for RobotPlayers: ");
            int initMoneyForPlayer = nextInt();
            for (int i = 0; i < auto; i++) {
                Player p = new RobotPlayer(initMoneyForPlayer, house.getMinBet());
                rouletteGame.addPlayer(p);
            }
        }
    }

    private int nextInt() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (java.util.InputMismatchException inputEx) {
            System.out.println("You were taken out of the casino for improper conduct");
            System.exit(-1); //Although the program will finish its execution after exit(),
            return 0;              //without return there will be a compilation error.
        }
    }

}
