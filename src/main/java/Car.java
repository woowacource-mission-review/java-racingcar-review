public class Car {
    private final CarName name;
    private Integer position;

    public Car(CarName name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int num) {
        if (num >= 4) {
            position++;
        }
    }

    public CarName getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }
}
