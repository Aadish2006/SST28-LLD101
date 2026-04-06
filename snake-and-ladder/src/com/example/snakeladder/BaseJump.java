public abstract class BaseJump implements Jump {
    protected int start;
    protected int end;

    public BaseJump(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int getStart() { return start; }
    @Override
    public int getEnd() { return end; }
}