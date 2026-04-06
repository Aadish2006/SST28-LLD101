import java.util.Random;

public class Dice {

    private static final int FACES = 6;
    private final Random random = new Random();

    public int roll() {
        return random.nextInt(FACES) + 1;
    }
}