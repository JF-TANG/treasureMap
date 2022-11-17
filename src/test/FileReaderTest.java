package test;

import main.FileReader;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class FileReaderTest {

    @Test
    void read() {
        List<String[]> mapEntities = new ArrayList<>();
        mapEntities.add(new String[]{"C", "3", "4"});
        mapEntities.add(new String[]{"M", "1", "0"});
        mapEntities.add(new String[]{"T", "1", "3", "3"});
        mapEntities.add(new String[]{"A", "Lara", "1", "1", "S", "AADADAGGA"});

        List<String[]> actualMapEntities = FileReader.read("TreasureMapTest.txt");
        for (int i = 0 ; i < mapEntities.size() && i < actualMapEntities.size() ; i++){
            assertArrayEquals(mapEntities.get(i), actualMapEntities.get(i));
        }
    }
}
