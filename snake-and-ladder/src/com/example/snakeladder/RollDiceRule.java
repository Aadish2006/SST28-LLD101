public class RollDiceRule implements Rule {

    @Override
    public void apply(MoveContext context, Dice dice) {
        int roll = dice.roll();
        context.setDiceRoll(roll);
        System.out.println(context.getPlayer().getName() + " rolled: " + roll);
    }
}