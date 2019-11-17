package racing.model;

public class RandomIntegerGenerator implements IntegerGenerator {
    private final int min;
    private final int max;

    public RandomIntegerGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int getRandomInteger() {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
