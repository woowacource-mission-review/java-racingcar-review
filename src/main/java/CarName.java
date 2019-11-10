public class CarName {
    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new CarNameLengthExcessException();
        }
    }

    public String getName() {
        return name;
    }
}
