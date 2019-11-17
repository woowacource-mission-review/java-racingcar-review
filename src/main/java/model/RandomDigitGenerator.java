package model;

import java.util.Random;

public class RandomDigitGenerator {
    private Random random = new Random();

    public int getRandomDigit() {
        return random.nextInt(10);
    }
}