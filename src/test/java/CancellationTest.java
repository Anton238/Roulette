import game.GameManager;
import players.Player;
import players.RobotPlayer;
import strategies.Cancellation;

//robot player launch
public class CancellationTest {
    public static void main(String[] args) {
        Player p = new RobotPlayer(100, 5);
        ((RobotPlayer) p).setStrategy(new Cancellation(5));
        System.out.println(p);
        GameManager manager = new GameManager();
        manager.rouletteGame.getPlayers().add(p);
        manager.rouletteGame.start(manager.house);

    }
}
