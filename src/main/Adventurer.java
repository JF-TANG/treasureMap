package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Adventurer {
    String name;
    Position position;
    String facingDirection;
    List<String> movements;
    int treasuresFound = 0;

    public Adventurer(String name, Position position, String facingDirection, String[] movements) {
        this.name = name;
        this.position = position;
        this.facingDirection = facingDirection;
        this.movements = new ArrayList<>(Arrays.asList(movements));
    }

    @Override
    public String toString() {
        return "Adventurer{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", facingDirection='" + facingDirection + '\'' +
                ", movements=" + movements +
                ", treasuresFound=" + treasuresFound +
                '}';
    }
}
