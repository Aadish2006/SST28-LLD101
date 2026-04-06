import java.util.HashMap;
import java.util.Map;

public class Board {

    private final int maxCell;
    private final Map<Integer, Jump> jumps = new HashMap<>();

    public Board(int size) {
        this.maxCell = size * size;
    }

    public int getMaxCell() { return maxCell; }

    public boolean hasJump(int pos) {
        return jumps.containsKey(pos);
    }

    public void addJump(Jump jump) {

        if (jumps.containsKey(jump.getStart())) return;

        int start = jump.getStart();
        int end = jump.getEnd();

        int curr = end;
        while (jumps.containsKey(curr)) {
            curr = jumps.get(curr).getEnd();
            if (curr == start) return; // cycle
        }

        jumps.put(start, jump);
    }

    public int resolvePosition(int pos) {
        while (jumps.containsKey(pos)) {
            Jump j = jumps.get(pos);
            System.out.println("Jump from " + j.getStart() + " to " + j.getEnd());
            pos = j.getEnd();
        }
        return pos;
    }
}