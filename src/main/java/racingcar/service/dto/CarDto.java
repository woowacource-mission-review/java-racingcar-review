package racingcar.service.dto;

import racingcar.domain.Car;

public class CarDto {
    private final String name;
    private final int position;

    public CarDto(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto from(final Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
