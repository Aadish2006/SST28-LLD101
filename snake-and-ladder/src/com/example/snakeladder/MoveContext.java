public class MoveContext {

    private final Player player;
    private int currentPosition;
    private int tentativePosition;
    private int diceRoll;
    private final int maxCell;
    private boolean skipTurn;

    public MoveContext(Player player, int currentPosition, int maxCell) {
        this.player = player;
        this.currentPosition = currentPosition;
        this.maxCell = maxCell;
        this.tentativePosition = currentPosition;
    }

    public Player getPlayer() { return player; }
    public int getCurrentPosition() { return currentPosition; }
    public int getTentativePosition() { return tentativePosition; }
    public void setTentativePosition(int pos) { this.tentativePosition = pos; }
    public int getDiceRoll() { return diceRoll; }
    public void setDiceRoll(int roll) { this.diceRoll = roll; }
    public int getMaxCell() { return maxCell; }
    public boolean isSkipTurn() { return skipTurn; }
    public void setSkipTurn(boolean val) { this.skipTurn = val; }
}