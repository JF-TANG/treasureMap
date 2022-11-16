package main;

public class Parser {
    public static String[] parse(String input, String regex) {
        return input.split(regex);
    }
}
