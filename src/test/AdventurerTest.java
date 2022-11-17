package test;

import main.Adventurer;
import main.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdventurerTest {

    @Test
    public void Adventurer() {
        Adventurer a = new Adventurer("Lara", new Position(1, 1), "S", new String[]{"A", "A", "D", "A", "D", "A" ,"G", "G", "A"});
        assertEquals(new Adventurer("Lara", new Position(1, 1), "S", new String[]{"A", "A", "D", "A", "D", "A" ,"G", "G", "A"}), a);
    }

    @Test
    public void equals() {
        Adventurer aA = new Adventurer("Lara", new Position(1, 1), "S", new String[]{"A", "A", "D", "A", "D", "A" ,"G", "G", "A"});
        Adventurer aB = new Adventurer("Lara", new Position(1, 1), "S", new String[]{"A", "A", "D", "A", "D", "A" ,"G", "G", "A"});

        assertEquals(aA, aB);
    }
}

