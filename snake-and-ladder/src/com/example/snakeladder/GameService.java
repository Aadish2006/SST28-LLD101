import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameService {

    private final Queue<Player> players;
    private final Board board;
    private final Dice dice;
    private final RuleEngine engine;

    public GameService(List<Player> players, Board board, RuleEngine engine) {
        this.players = new LinkedList<>(players);
        this.board = board;
        this.dice = new Dice();
        this.engine = engine;
    }

    public void startGame() {

        while (players.size() > 1) {

            Player curr = players.poll();

            System.out.println("\n" + curr.getName() + "'s turn:");

            int newPos = engine.execute(
                    curr,
                    curr.getPosition(),
                    dice,
                    board.getMaxCell()
            );

            curr.setPosition(newPos);

            System.out.println(curr.getName() + " at " + newPos);

            if (newPos == board.getMaxCell()) {
                System.out.println(curr.getName() + " WON!");
            } else {
                players.add(curr);
            }
        }

        System.out.println("Game Over!");
    }
}