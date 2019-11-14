package model;

import model.exception.CarCreateException;

public class Car {
    private String name;
    private Integer position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, Integer position) {
        validateName(name);
        validatePosition(position);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        validateNull(name);
        validateEmpty(name);
    }

    private void validateNull(String name) {
        if (name == null) {
            throw new CarCreateException("차 이름에 NULL 을 입력할 수 없습니다.");
        }
    }

    private void validateEmpty(String name) {
        if ("".equals(name)) {
            throw new CarCreateException("차 이름에 비어있는 문자열을 입력할 수 없습니다.");
        }
    }

    private void validatePosition(Integer position) {
        if (position == null) {
            throw new CarCreateException("위치에 NULL을 입력할 수 없습니다.");
        }
    }

    public boolean matchPosition(Integer position) {
        return this.position.equals(position);
    }
}
