public class JumpRule implements Rule {

    private final Board board;

    public JumpRule(Board board) {
        this.board = board;
    }

    @Override
    public void apply(MoveContext context, Dice dice) {

        if (context.isSkipTurn()) return;

        int resolved = board.resolvePosition(context.getTentativePosition());
        context.setTentativePosition(resolved);
    }
}