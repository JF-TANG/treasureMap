package main;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TreasureMap tm = new TreasureMap(FileReader.read("TreasureMap.txt"));
        tm.start();
        FileWriter.generateFile(tm.toTxt(), "TreasureMapEnd.txt");
    }
}