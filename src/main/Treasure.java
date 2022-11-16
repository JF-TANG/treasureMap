package main;

public class Treasure {
    int numberOfChestsLeft;

    public Treasure(int numberOfChestsLeft) {
        this.numberOfChestsLeft = numberOfChestsLeft;
    }

    @Override
    public String toString() {
        return "Treasure{" +
                "numberOfChestsLeft=" + numberOfChestsLeft +
                '}';
    }
}
