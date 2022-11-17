package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter {
    public static void generateFile(String text, String filename) throws IOException {
        // Defining the file name of the file
        Path filePath = Path.of("src/resources/" + filename);

        // Writing into the file
        Files.writeString(filePath, text);

        // Reading the content of the file
        String file_content = Files.readString(filePath);

        // Printing the content inside the file
        System.out.println(file_content);
    }
}
