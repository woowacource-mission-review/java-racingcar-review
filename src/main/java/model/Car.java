package model;

import model.exception.CarCreateException;
import model.result.MoveResult;

import java.util.Objects;

public class Car implements Comparable<Car> {
    public static final int DEFAULT_POSITION = 0;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private final String name;
    private int position;

    public Car(final String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(final String name, final int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(final String name) {
        validateNull(name);
        validateEmpty(name);
        validateLength(name);
    }

    private void validateNull(final String name) {
        Objects.requireNonNull(name, "차 이름에 NULL 을 입력할 수 없습니다.");
    }

    private void validateEmpty(final String name) {
        if ("".equals(name)) {
            throw new CarCreateException("차 이름에 비어있는 문자열을 입력할 수 없습니다.");
        }
    }

    private void validateLength(final String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new CarCreateException("차 이름은 " + CAR_NAME_MAX_LENGTH + "자 이하이어야합니다.");
        }
    }

    public MoveResult move(final boolean moveFlag) {
        if (moveFlag) {
            return new MoveResult(name, ++position);
        }
        return new MoveResult(name, position);
    }

    public boolean matchPosition(final int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(position, o.position);
    }
}
