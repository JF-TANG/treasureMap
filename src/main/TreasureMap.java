package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreasureMap {
    Position mapBorder;
    Map<Position, Mountain> mountains = new HashMap<>();
    Map<Position, Treasure> treasures = new HashMap<>();
    List<Adventurer> adventurers = new ArrayList<>();

    public Position getMapBorder() {
        return mapBorder;
    }

    public Map<Position, Mountain> getMountains() {
        return mountains;
    }

    public Map<Position, Treasure> getTreasures() {
        return treasures;
    }

    public List<Adventurer> getAdventurers() {
        return adventurers;
    }

    public TreasureMap(List<String[]> mapInfos) {
        for (String[] mapInfo : mapInfos) {
            switch (mapInfo[0]) {
                case "C" -> mapBorder = new Position(Integer.parseInt(mapInfo[1]), Integer.parseInt(mapInfo[2]));
                case "M" ->
                        mountains.put(new Position(Integer.parseInt(mapInfo[1]), Integer.parseInt(mapInfo[2])), new Mountain());
                case "T" ->
                        treasures.put(new Position(Integer.parseInt(mapInfo[1]), Integer.parseInt(mapInfo[2])), new Treasure(Integer.parseInt(mapInfo[3])));
                case "A" -> {
                    if (mapInfo.length > 6) {
                        adventurers.add(new Adventurer(mapInfo[1], new Position(Integer.parseInt(mapInfo[2]), Integer.parseInt(mapInfo[3])), mapInfo[4], Parser.parse(mapInfo[5], ""), Integer.parseInt(mapInfo[6])));
                    } else {
                        adventurers.add(new Adventurer(mapInfo[1], new Position(Integer.parseInt(mapInfo[2]), Integer.parseInt(mapInfo[3])), mapInfo[4], Parser.parse(mapInfo[5], "")));
                    }
                }

            }
        }

    }

    public boolean hasCollision(Position pos) {
        return pos.posX < 0 || pos.posY < 0 || pos.posX > mapBorder.posX || pos.posY > mapBorder.posY ||
                mountains.containsKey(pos) ||
                adventurers.stream().filter(e -> e.position.equals(pos)).count() > 1;
    }

    public void move(Adventurer adventurer) {
        switch (adventurer.movements.get(0)) {
            case "D":
                switch (adventurer.facingDirection) {
                    case "N" -> adventurer.facingDirection = "E";
                    case "O" -> adventurer.facingDirection = "N";
                    case "S" -> adventurer.facingDirection = "O";
                    case "E" -> adventurer.facingDirection = "S";
                }
                break;
            case "G":
                switch (adventurer.facingDirection) {
                    case "N" -> adventurer.facingDirection = "O";
                    case "O" -> adventurer.facingDirection = "S";
                    case "S" -> adventurer.facingDirection = "E";
                    case "E" -> adventurer.facingDirection = "N";
                }
                break;
            case "A":
                Position futurePosition = new Position(adventurer.position);
                switch (adventurer.facingDirection) {
                    case "N" -> futurePosition.posY--;
                    case "O" -> futurePosition.posX--;
                    case "S" -> futurePosition.posY++;
                    case "E" -> futurePosition.posX++;
                }
                if (!hasCollision(futurePosition)) {
                    adventurer.position = futurePosition;
                    if (treasures.containsKey(futurePosition)) {
                        if (treasures.get(futurePosition).numberOfChestsLeft > 0) {
                            treasures.get(futurePosition).numberOfChestsLeft--;
                            adventurer.treasuresFound++;
                        }
                    }
                }
                break;
        }
        adventurer.movements.remove(0);
    }

    public void start() {

        int max = 0;
        for (Adventurer adventurer : adventurers) {
            if (adventurer.movements.size() > max) {
                max = adventurer.movements.size();
            }
        }

        for (int i = 0; i < max; i++) {
            for (Adventurer adventurer : adventurers) {
                if (!adventurer.movements.isEmpty()) {
                    move(adventurer);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "TreasureMap{" +
                " \n mapBorder=" + mapBorder +
                ", \n mountains=" + mountains +
                ", \n treasures=" + treasures +
                ", \n adventurers=" + adventurers +
                " \n}";
    }

    public String toTxt() {
        String txt = "C - " + mapBorder.posX + " - " + mapBorder.posY;
        for (Position m : mountains.keySet()) {
            txt += "\nM - " + m.posX + " - " + m.posY;
        }

        for (Map.Entry<Position, Treasure> entry : treasures.entrySet()) {
            if (entry.getValue().numberOfChestsLeft > 0) {
                txt += "\nT - " + entry.getKey().posX + " - " + entry.getKey().posY + " - " + entry.getValue().numberOfChestsLeft;
            }
        }

        for (Adventurer a : adventurers) {
            txt += "\nA - " + a.name + " - " + a.position.posX + " - " + a.position.posY + " - " + a.facingDirection + " - " + a.treasuresFound;
        }
        return txt;
    }
}
