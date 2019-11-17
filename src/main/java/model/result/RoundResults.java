package model.result;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoundResults implements Iterable<RoundResult> {
    private List<RoundResult> roundResults = new ArrayList<>();

    public void addRoundResult(RoundResult roundResult) {
        roundResults.add(roundResult);
    }

    @Override
    public Iterator<RoundResult> iterator() {
        return roundResults.iterator();
    }

    public RoundResult getRoundResult(int round) {
        return roundResults.get(round - 1);
    }
}
