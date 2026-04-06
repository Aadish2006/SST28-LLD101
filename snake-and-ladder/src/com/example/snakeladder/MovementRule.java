public class MovementRule implements Rule {

    @Override
    public void apply(MoveContext context, Dice dice) {

        if (context.isSkipTurn()) return;

        int pos = context.getCurrentPosition() + context.getDiceRoll();
        context.setTentativePosition(pos);
    }
}