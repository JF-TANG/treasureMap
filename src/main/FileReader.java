package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List<String[]> read (String fileName){
        List<String[]> mapEntities = new ArrayList<>();
        try {
            File filePath = new File("src/resources/" + fileName);
            Scanner myReader = new Scanner(filePath);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                mapEntities.add(Parser.parse(data, " - "));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return mapEntities;
    }
}
