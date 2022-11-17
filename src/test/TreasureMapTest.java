package test;

import main.FileReader;
import main.Position;
import main.TreasureMap;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TreasureMapTest {

    @Test
    public void TreasureMap(){
        List<String[]> mapEntities = new ArrayList<>();
        mapEntities.add(new String[]{"C", "3", "4"});
        mapEntities.add(new String[]{"M", "1", "0"});
        mapEntities.add(new String[]{"T", "1", "3", "3"});
        mapEntities.add(new String[]{"A", "Lara", "1", "1", "S", "AADADAGGA"});

        TreasureMap tm = new TreasureMap(mapEntities);
        TreasureMap actualTm = new TreasureMap(FileReader.read("TreasureMapTest.txt"));

        assertEquals(tm.getMapBorder(), actualTm.getMapBorder());
        assertEquals(tm.getMountains() , actualTm.getMountains());
        assertEquals(tm.getTreasures() , actualTm.getTreasures());
        assertEquals(tm.getAdventurers() , actualTm.getAdventurers());
    }

    @Test
    public void hasCollision(){
        List<String[]> mapEntities = new ArrayList<>();
        mapEntities.add(new String[]{"C", "3", "4"});
        mapEntities.add(new String[]{"M", "1", "0"});
        mapEntities.add(new String[]{"T", "1", "3", "3"});
        mapEntities.add(new String[]{"A", "Lara", "1", "1", "N", "A"});

        TreasureMap actualTm = new TreasureMap(mapEntities);

        assertTrue(actualTm.hasCollision(new Position(1, 0)));
        assertTrue(actualTm.hasCollision(new Position(4, 4)));
        assertTrue(actualTm.hasCollision(new Position(-1, 4)));

        assertFalse(actualTm.hasCollision(new Position(1, 3)));
    }

    @Test
    public void move(){
        List<String[]> mapEntities = new ArrayList<>();
        mapEntities.add(new String[]{"C", "3", "4"});
        mapEntities.add(new String[]{"M", "1", "0"});
        mapEntities.add(new String[]{"T", "1", "3", "3"});
        mapEntities.add(new String[]{"A", "Lara", "1", "1", "S", "A"});

        TreasureMap actualTm = new TreasureMap(mapEntities);
        actualTm.move(actualTm.getAdventurers().get(0));
        assertEquals(actualTm.getAdventurers().get(0).getPosition(), new Position(1, 2));
    }

    @Test
    public void start(){
        List<String[]> mapEntities = new ArrayList<>();
        mapEntities.add(new String[]{"C", "3", "4"});
        mapEntities.add(new String[]{"M", "1", "0"});
        mapEntities.add(new String[]{"T", "1", "3", "2"});
        mapEntities.add(new String[]{"A", "Lara", "0", "3", "S", "", "1"});

        TreasureMap tm = new TreasureMap(mapEntities);
        TreasureMap actualTm = new TreasureMap(FileReader.read("TreasureMapTest.txt"));
        actualTm.start();

        assertEquals(tm.getMapBorder(), actualTm.getMapBorder());
        assertEquals(tm.getMountains() , actualTm.getMountains());
        assertEquals(tm.getTreasures() , actualTm.getTreasures());
        assertEquals(tm.getAdventurers(), actualTm.getAdventurers());
    }

    @Test
    public void toTxt(){
        TreasureMap actualTm = new TreasureMap(FileReader.read("TreasureMapTest.txt"));
        actualTm.start();
        String s = """
                C - 3 - 4
                M - 1 - 0
                T - 1 - 3 - 2
                A - Lara - 0 - 3 - S - 1""";

        assertEquals(s, actualTm.toTxt());

    }
}
