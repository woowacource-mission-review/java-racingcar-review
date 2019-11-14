package model;

import model.exception.CarCreateException;

public class Car {
    private String name;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
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
}
