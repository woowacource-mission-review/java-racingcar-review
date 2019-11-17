package model.result;

import java.util.Iterator;
import java.util.List;

public class RoundResult implements Iterable<MoveResult> {
    private List<MoveResult> moveResults;

    public RoundResult(List<MoveResult> moveResults) {
        this.moveResults = moveResults;
    }

    public boolean contains(MoveResult moveResult) {
        return moveResults.contains(moveResult);
    }

    @Override
    public Iterator<MoveResult> iterator() {
        return moveResults.iterator();
    }
}
