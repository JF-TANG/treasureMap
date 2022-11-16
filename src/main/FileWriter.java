package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter {
    public static void generateFile(String text) throws IOException {
        // Defining the file name of the file
        Path fileName = Path.of("src/resources/TreasureMapEnd.txt");

        // Writing into the file
        Files.writeString(fileName, text);

        // Reading the content of the file
        String file_content = Files.readString(fileName);

        // Printing the content inside the file
        System.out.println(file_content);
    }
}
