package model;

import model.exception.CarCreateException;
import model.result.MoveResult;

import java.util.Objects;

public class Car implements Comparable<Car> {
    public static final int DEFAULT_POSITION = 0;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private String name;
    private int position;

    public Car(String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        validateNull(name);
        validateEmpty(name);
        validateLength(name);
    }

    private void validateNull(String name) {
        Objects.requireNonNull(name, "차 이름에 NULL 을 입력할 수 없습니다.");
    }

    private void validateEmpty(String name) {
        if ("".equals(name)) {
            throw new CarCreateException("차 이름에 비어있는 문자열을 입력할 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new CarCreateException("차 이름은 " + CAR_NAME_MAX_LENGTH + "자 이하이어야합니다.");
        }
    }

    public MoveResult move(boolean moveFlag) {
        if (moveFlag) {
            return new MoveResult(name, ++position);
        }
        return new MoveResult(name, position);
    }

    public boolean matchPosition(int position) {
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
