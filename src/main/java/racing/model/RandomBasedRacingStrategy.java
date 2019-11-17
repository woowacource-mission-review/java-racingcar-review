package racing.model;

public class RandomBasedRacingStrategy implements RacingCarProceedStrategy {
    private final IntegerGenerator generator;
    private final int threshold;

    public RandomBasedRacingStrategy(IntegerGenerator generator, int threshold) {
        this.generator = generator;
        this.threshold =threshold;
    }

    @Override
    public boolean isGo() {
        return  generator.getRandomInteger() >= threshold;
    }
}
