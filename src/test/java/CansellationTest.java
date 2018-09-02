import game.GameManager;
import players.Player;
import players.RobotPlayer;
import strategies.Cansellation;

//robot player launch
public class CansellationTest {
    public static void main(String[] args) {
        Player p = new RobotPlayer(100, 5);
        ((RobotPlayer) p).setStrategy(new Cansellation(5));
        System.out.println(p);
        GameManager manager = new GameManager();
        manager.rouletteGame.getPlayers().add(p);
        manager.rouletteGame.start(manager.house);

    }
}
