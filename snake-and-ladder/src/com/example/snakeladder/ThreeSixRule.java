public class ThreeSixRule implements Rule {

    private int sixCount = 0;

    @Override
    public void apply(MoveContext context, Dice dice) {

        if (context.getDiceRoll() == 6) {
            sixCount++;
            if (sixCount == 3) {
                System.out.println("❌ 3 sixes! Turn skipped.");
                context.setSkipTurn(true);
                sixCount = 0;
            }
        } else {
            sixCount = 0;
        }
    }
}