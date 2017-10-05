package se.academy.main;

import com.googlecode.lanterna.terminal.Terminal;

public class Map {
    private char[][] map;
    private Terminal.Color colour;


    public Map() {
        map = new char[63][30];
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map.length - 33; y++) {
                if (x == 0 || x == map.length - 1 || y == 0 || y == map.length - 34) {
                    map[x][y] = '\u2588';
                }
            }
        }
        colour = Terminal.Color.WHITE;
    }
    public char[][] secondMap() {
        map = new char[63][30];
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map.length - 33; y++) {
                if (x == 0 || x == map.length - 1 || y == 0 || y == map.length - 34) {
                    map[x][y] = '\u2588';
                }
            }
        }
        colour = Terminal.Color.CYAN;
        return map;
    }
    public char[][] getMap() {
        return map;
    }

    public Terminal.Color getColour() {
        return colour;
    }
}
