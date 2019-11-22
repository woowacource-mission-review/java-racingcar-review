package model.result;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoundResults implements Iterable<RoundResult> {
    private final List<RoundResult> roundResults = new ArrayList<>();

    public void addRoundResult(final RoundResult roundResult) {
        roundResults.add(roundResult);
    }

    public RoundResult getRoundResult(final int round) {
        return roundResults.get(round - 1);
    }

    @Override
    public Iterator<RoundResult> iterator() {
        return roundResults.iterator();
    }
}
