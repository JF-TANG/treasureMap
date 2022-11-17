package main;

import java.util.Objects;

public class Treasure {
    int numberOfChestsLeft;

    public Treasure(int numberOfChestsLeft) {
        this.numberOfChestsLeft = numberOfChestsLeft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treasure treasure = (Treasure) o;
        return numberOfChestsLeft == treasure.numberOfChestsLeft;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfChestsLeft);
    }

    @Override
    public String toString() {
        return "Treasure{" +
                "numberOfChestsLeft=" + numberOfChestsLeft +
                '}';
    }
}
