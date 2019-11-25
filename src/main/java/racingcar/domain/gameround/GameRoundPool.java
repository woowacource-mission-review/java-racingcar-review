package racingcar.domain.gameround;

import com.google.common.collect.Maps;

import java.util.Map;

public class GameRoundPool {

    private static final Map<Long, GameRound> ROUND_POOL = Maps.newHashMap();

    private GameRoundPool() {
    }

    public static GameRound of(long round) {
        if (ROUND_POOL.containsKey(round)) {
            return ROUND_POOL.get(round);
        }

        GameRound gameRound = new GameRound(round);
        ROUND_POOL.put(round, gameRound);

        return gameRound;
    }
}
