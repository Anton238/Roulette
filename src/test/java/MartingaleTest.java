import game.GameManager;
import players.Player;
import players.RobotPlayer;
import strategies.Martingale;


// robot player with martingale strategy
public class MartingaleTest {
    public static void main(String[] args) {
        Player p = new RobotPlayer(100, 5);
        ((RobotPlayer) p).setStrategy(new Martingale(5));
        System.out.println(p + "player");
        GameManager manager = new GameManager();
        manager.rouletteGame.getPlayers().add(p);
        manager.rouletteGame.start(manager.house);
    }
}
