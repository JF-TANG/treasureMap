package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
        if (isEmpty(movements)){
            this.movements = new ArrayList<>();
        }else{
            this.movements = new ArrayList<>(Arrays.asList(movements));
        }
    }

    public Adventurer(String name, Position position, String facingDirection, String[] movements, int treasuresFound) {
        this.name = name;
        this.position = position;
        this.facingDirection = facingDirection;
        if (isEmpty(movements)){
            this.movements = new ArrayList<>();

        }else{
            this.movements = new ArrayList<>(Arrays.asList(movements));

        }
        this.treasuresFound = treasuresFound;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public String getFacingDirection() {
        return facingDirection;
    }

    public List<String> getMovements() {
        return movements;
    }

    public int getTreasuresFound() {
        return treasuresFound;
    }

    public boolean isEmpty(String[] e){
        if (e != null) {
            for (String s : e) {
                if (!s.equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adventurer that = (Adventurer) o;
        return treasuresFound == that.treasuresFound && Objects.equals(name, that.name) && Objects.equals(position, that.position) && Objects.equals(facingDirection, that.facingDirection) && Objects.equals(movements, that.movements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, facingDirection, movements, treasuresFound);
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
