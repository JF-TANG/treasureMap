package test;

import main.Mountain;
import main.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MountainTest {

    @Test
    public void Position() {
        Mountain m = new Mountain();
        assertEquals(new Mountain(), m);
    }

    @Test
    public void equals() {
        Mountain mA = new Mountain();
        Mountain mB = new Mountain();

        assertEquals(mA, mB);
    }
}
