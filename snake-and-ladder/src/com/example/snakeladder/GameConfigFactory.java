import java.util.Arrays;
import java.util.List;

public class GameConfigFactory {

    public static GameConfig getConfig(String difficulty, Board board) {

        if ("hard".equalsIgnoreCase(difficulty)) {

            List<Rule> rules = Arrays.asList(
                    new RollDiceRule(),
                    new ThreeSixRule(),
                    new MovementRule(),
                    new BoundaryRule(true),
                    new JumpRule(board)
            );

            return new GameConfig(
                    new HardStrategy(),
                    new RuleEngine(rules)
            );
        }

        List<Rule> rules = Arrays.asList(
                new RollDiceRule(),
                new MovementRule(),
                new BoundaryRule(false),
                new JumpRule(board)
        );

        return new GameConfig(
                new EasyStrategy(),
                new RuleEngine(rules)
        );
    }
}