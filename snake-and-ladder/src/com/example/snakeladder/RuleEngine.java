import java.util.List;

public class RuleEngine {

    private final List<Rule> rules;

    public RuleEngine(List<Rule> rules) {
        this.rules = rules;
    }

    public int execute(Player player, int currentPosition, Dice dice, int maxCell) {

        MoveContext ctx = new MoveContext(player, currentPosition, maxCell);

        for (Rule rule : rules) {
            rule.apply(ctx, dice);
            if (ctx.isSkipTurn()) break;
        }

        return ctx.getTentativePosition();
    }
}