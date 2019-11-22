package model.result;

import java.util.Iterator;
import java.util.List;

public class RoundResult implements Iterable<MoveResult> {
    private final List<MoveResult> moveResults;

    public RoundResult(final List<MoveResult> moveResults) {
        this.moveResults = moveResults;
    }

    public boolean contains(final MoveResult moveResult) {
        return moveResults.contains(moveResult);
    }

    @Override
    public Iterator<MoveResult> iterator() {
        return moveResults.iterator();
    }
}
