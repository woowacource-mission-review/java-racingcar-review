package racingcar.service.dto;

import racingcar.domain.Car;

import java.util.Objects;

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
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CarDto carDto = (CarDto) o;
        return position == carDto.position &&
                Objects.equals(name, carDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
