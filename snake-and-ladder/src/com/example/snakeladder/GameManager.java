import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int playersCount = sc.nextInt();
        String difficulty = sc.next();

        Board board = new Board(n);

        GameConfig config = GameConfigFactory.getConfig(difficulty, board);

        config.getStrategy().generateJumps(board, n);

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= playersCount; i++) {
            players.add(new Player("Player " + i));
        }

        GameService game = new GameService(
                players,
                board,
                config.getRuleEngine()
        );

        game.startGame();
    }
}