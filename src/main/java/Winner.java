public class Winner {
    private Car winnerCar;

    public Winner(Car winnerCar) {
        this.winnerCar = winnerCar;
    }

    public String getWinnerName() {
        return winnerCar.getName();
    }
}
