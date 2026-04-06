import java.util.Random;

public class EasyStrategy implements DifficultyStrategy {

    private final Random rand = new Random();

    @Override
    public void generateJumps(Board board, int count) {
        int max = board.getMaxCell();

        int created = 0;
        while (created < count) {
            int head = rand.nextInt(max - 1) + 2;
            int tail = rand.nextInt(head - 1) + 1;

            if (!board.hasJump(head)) {
                board.addJump(new Snake(head, tail));
                created++;
            }
        }

        created = 0;
        while (created < count) {
            int start = rand.nextInt(max - 1) + 1;
            int end = start + rand.nextInt((max - start) / 2 + 1);

            if (!board.hasJump(start) && start != end) {
                board.addJump(new Ladder(start, end));
                created++;
            }
        }
    }
}