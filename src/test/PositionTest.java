package test;

import main.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositionTest {

    @Test
    public void Position(){
        Position p = new Position(1, 2);
        assertEquals(new Position(1, 2), p);
    }

    @Test
    public void equals(){
        Position pA = new Position(1, 2);
        Position pB = new Position(1, 2);

        assertEquals(pA, pB);
    }
}
