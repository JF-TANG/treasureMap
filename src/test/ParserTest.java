package test;

import main.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ParserTest {

    @Test
    public void parse(){
        String[] p = {"C", "1" , "2"};
        assertArrayEquals(p, Parser.parse("C - 1 - 2", " - "));
    }
}
