package racing.model;

public class RacingCar {
    private final String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public void goForward(RacingCarProceedStrategy strategy) {
        this.position += strategy.isGo() ? 1 : 0;
    }

    public int getPosition() {
        return this.position;
    }
}
