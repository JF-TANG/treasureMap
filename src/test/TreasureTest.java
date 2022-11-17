package test;

import main.Position;
import main.Treasure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TreasureTest {

    @Test
    public void Treasure() {
        Treasure t = new Treasure(1);
        assertEquals(new Treasure(1), t);
    }

    @Test
    public void equals() {
        Treasure tA = new Treasure(2);
        Treasure tB = new Treasure(2);

        assertEquals(tA, tB);
    }
}
