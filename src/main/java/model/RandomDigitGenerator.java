package model;

import java.util.Random;

class RandomDigitGenerator {
    private Random random = new Random();

    int getRandomDigit() {
        return random.nextInt(10);
    }
}