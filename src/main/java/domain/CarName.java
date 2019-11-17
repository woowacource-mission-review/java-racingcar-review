package domain;

import domain.exception.CarNameLengthExcessException;

public class CarName {
    private final static Integer MAX_NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new CarNameLengthExcessException();
        }
    }

    public String getName() {
        return name;
    }
}
