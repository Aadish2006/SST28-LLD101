public class BoundaryRule implements Rule {

    private final boolean exact;

    public BoundaryRule(boolean exact) {
        this.exact = exact;
    }

    @Override
    public void apply(MoveContext context, Dice dice) {

        if (context.isSkipTurn()) return;

        int pos = context.getTentativePosition();
        int max = context.getMaxCell();

        if (exact && pos > max) {
            System.out.println("❌ Exact landing required.");
            context.setTentativePosition(context.getCurrentPosition());
        } else if (pos >= max) {
            context.setTentativePosition(max);
        }
    }
}